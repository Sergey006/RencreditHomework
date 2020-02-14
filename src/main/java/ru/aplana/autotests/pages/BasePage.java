package ru.aplana.autotests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;

public class BasePage {
    WebDriver driver =  BaseSteps.getDriver();
    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        /*field.click();*/
        field.clear();
        field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        field.sendKeys(value);
        field.sendKeys(Keys.ENTER);
    }
}
