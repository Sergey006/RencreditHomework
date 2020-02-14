package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInput;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchSubmitButton;
    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    WebElement closeCookies;
    @FindBy(xpath = "//a[@data-widget='cart']")
    WebElement cart;



    public void searchProduct(String productName){
        fillField(searchInput, productName);
        searchSubmitButton.click();
    }
    public void closeCookies(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(closeCookies));
        Actions action = new Actions(driver);
        action.moveToElement(closeCookies).click().perform();
    }
    public void goToCart(){
        cart.click();
    }

}
