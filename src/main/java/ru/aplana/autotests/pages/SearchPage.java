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
    @FindBy(xpath = "//div[contains(@data-widget,'searchResultsV2')]/div/div/div")
    List<WebElement> productsList;
    @FindBy(xpath = "//div[contains(text(),'Бренды')]/../div/div/input")
    WebElement brandField;



    public void clickOptionCheckbox(String checkboxName){
        if (checkboxName.equalsIgnoreCase("false")) return;
        driver.findElement(By.xpath("//div[@class='cs4']/..//label//span[contains(text(), '"+ checkboxName +"')]")).click();
    }
    public void selectBrand(String brandName){
        if (brandName.equalsIgnoreCase("false")) return;
        List<WebElement> showAll = null;
        if ((showAll = driver.findElements(By.xpath("//span[@data-test-id='filter-block-brand-show-all']"))).size() > 0){
            showAll.get(0).click();
        }
        fillField(brandField, brandName);
        WebElement brand = driver.findElement(By.xpath("//div[contains(text(),'Бренды')]/..//label//span[contains(text(), '"+ brandName +"')]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(brand)).click();
    }
    public void addProductsToCart(String quantity, String isEven){
        int quantityInt = 0;
        try{
            quantityInt = Integer.parseInt(quantity);
        }catch(NumberFormatException e){
            if (quantity.equalsIgnoreCase("все")){
                quantityInt = productsList.size();
            }
        }

        for (int count = isEven.equalsIgnoreCase("true")?1:0; count < productsList.size() && count < quantityInt*2; count += 2){
            WebElement product = driver.findElements(By.xpath("//div[contains(@data-widget,'searchResultsV2')]/div/div/div")).get(count);
            List<WebElement> buyButton = product.findElements(By.xpath(".//button[@qa-id='tile-buy-button']"));
            if (buyButton.size() > 0){
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
