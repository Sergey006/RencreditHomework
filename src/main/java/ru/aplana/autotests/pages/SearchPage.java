package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.util.Product;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//input[contains(@id,'to')]")
    WebElement toPriceInput;
    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//input[contains(@id,'from')]")
    WebElement fromPriceInput;
    @FindBy(xpath = "//div[@value='Высокий рейтинг']//span[text()='Высокий рейтинг']/..")
    WebElement highRating;
    @FindBy(xpath = "//div[contains(text(),'Оперативная')]/..//span[contains(text(), 'ГБ')]")
    List<WebElement> listRAM;
    @FindBy(xpath = "//div[@data-widget='searchResultsSort']//span[text()='Цена']")
    WebElement waitPriceElement;

    @FindBy(xpath = "//div[contains(@data-widget,'searchResultsV2')]/div/div/div")
    List<WebElement> productsList;
    @FindBy(xpath="//span[contains(text(), 'Ваша корзина')]/../span[contains(text(),'товар')]")
    WebElement productsInCartQuantity;

    public void checkProductsQuantity(String quantity){
        String currentQuantity = productsInCartQuantity.getText().split("товар")[0].trim();
        Assert.assertEquals("Проверка, что фактическое количество товаров в корзине '"+ currentQuantity
                + "' равно ожидаемому '"+ quantity +"'", currentQuantity, quantity);
    }

    public void buyFirstEightOddProducts(){
        int i = 0;
        for (WebElement product:productsList){
            //if (++i > 14) break;
            List<WebElement> buyButton = product.findElements(By.xpath(".//button[@qa-id='tile-buy-button']"));
            if (++i % 2 != 0 && buyButton.size() > 0){
                String productName = product.
                        findElement(By.xpath(".//a[@data-test-id='tile-name']")).
                        getText();
                String productPrice = product.
                        findElement(By.xpath(".//span[@data-test-id='tile-price']")).
                        getText().
                        replaceAll("\\D","");
                BaseSteps.addToCart(new Product(productName, productPrice));
                new Actions(driver).moveToElement(buyButton.get(0)).click().perform();
            }
        }
    }
    public void setPriceFrom(String value){
        fillField(fromPriceInput, value);
    }
    public void setPriceTo(String value){
        toPriceInput.click();
        toPriceInput.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        toPriceInput.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        toPriceInput.sendKeys(value);
        toPriceInput.sendKeys(Keys.ENTER);
        waitForFilterVisibility("Цена");
    }
    public void selectHighRating() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", highRating);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(highRating));
        Actions actions = new Actions(driver);
        actions.moveToElement(highRating).click().perform();
        //waitForFilterVisibility("рейтинг");
    }
    public void selectRAM(String quantity){
        for (WebElement item:listRAM){
            if (item.getText().contains(quantity)){
                item.click();
                return;
            }
        }
    }
    public void waitForFilterVisibility(String filterName){
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@data-widget='searchResultsSort']//span[contains(text(),'"+filterName+"')]")));}
}
