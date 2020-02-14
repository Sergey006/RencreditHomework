package ru.aplana.autotests.pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//span[text()='Высокий рейтинг']")
    WebElement highRating;
    @FindBy(xpath = "//div[contains(text(),'Оперативная')]/..//span[contains(text(), 'ГБ')]")
    List<WebElement> listRAM;
    @FindBy(xpath = "//div[@data-widget='searchResultsSort']//span[text()='Цена']")
    WebElement waitPriceElement;

    @FindBy(xpath = "//div[contains(@data-widget,'searchResultsV2')]/div/div")
    List<WebElement> productsList;

    public void buyFirstEightOddProducts(){
        int i = 0;
        for (WebElement product:productsList){
            List<WebElement> buyButton = product.findElements(By.xpath(".//button[@qa-id='tile-buy-button']"));
            if (++i > 8) return;
            if (i % 2 != 0 && buyButton.size() > 0){
                new Actions(driver).moveToElement(buyButton.get(0)).click().perform();
                String productName = product.
                        findElement(By.xpath(".//a[@data-test-id='tile-name']")).
                        getText();
                String productPrice = product.
                        findElement(By.xpath(".//span[@data-test-id='tile-price']")).
                        getText().
                        replaceAll("\\D","");
                BaseSteps.addToCart(new Product(productName, productPrice));
            }
        }
    }
    public void setPriceFrom(String value){
        fillField(fromPriceInput, value);
    }
    public void setPriceTo(String value){
        toPriceInput.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        toPriceInput.sendKeys(value);
        toPriceInput.sendKeys(Keys.ENTER);
        waitForFilterVisibility();
    }
    public void selectHighRating() {
        Actions actions = new Actions(driver);
        actions.moveToElement(highRating).perform();
        highRating.click();
    }
    public void selectRAM(String quantity){
        for (WebElement item:listRAM){
            if (item.getText().contains(quantity)){
                item.click();
                return;
            }
        }
    }
    public void waitForFilterVisibility(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(waitPriceElement));
    }
}
