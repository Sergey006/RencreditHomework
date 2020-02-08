package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class ContributionPage extends BasePage {

    @FindBy(xpath ="//span[@class='calculator__currency-field-text']")
    List<WebElement> currencies;
    @FindBy (xpath="//input[@name='amount']")
    WebElement amount;
    @FindBy (xpath="//select[@name='period']")
    WebElement period;
    @FindBy (xpath = "//input[@name='replenish']")
    WebElement replenish;
    @FindBy(xpath = "//input[@name='capitalization']/..")
    WebElement capitalization;
    @FindBy(xpath = "//input[@name='partial_out']/..")
    WebElement partialOut;
    @FindBy(xpath = "//input[@name='deposit_b_n']/..")
    WebElement openInBank;
    @FindBy(xpath = "//input[@name='deposit_b_y']/..")
    WebElement openInOnlineBank;

    @FindBy(xpath="//span[@class='js-calc-rate']")
    WebElement percentView;
    @FindBy(xpath="//span[@class='js-calc-earned']")
    WebElement earnedMoneyView;
    @FindBy(xpath="//span[@class='js-calc-replenish']")
    WebElement replenishView;
    @FindBy(xpath="//span[@class='js-calc-result']")
    WebElement resultMoneyView;




    public ContributionPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectCurrency(String currency){
        for (WebElement item:currencies){
            if (item.getText().equalsIgnoreCase(currency)){
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найдёна валюта " + currency );
    }

    public void selectPeriod(String monthQuantity){
        Select selectPeriod = new Select(period);
        selectPeriod.selectByValue(monthQuantity);
    }

    public void fillField(String fieldName, String value){
        String currentResult = resultMoneyView.getText();
        switch(fieldName){
            case "Сумма вклада":
                fillField(amount, value);
                waitForChange(currentResult);
                break;
            case "Ежемесячное пополнение":
                fillField(replenish, value);
                waitForChange(currentResult);
                break;
            default:
                Assert.fail("Не найдено поле " + fieldName);
        }
    }

    public String getFieldValue(String fieldName){
        switch (fieldName){
            case  "Ставка":
                return percentView.getText();
            case  "Начислено":
                return earnedMoneyView.getText();
            case  "Пополнение":
                return replenishView.getText();
            case "К снятию":
                return resultMoneyView.getText();
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void selectCapitalization(){
        String currentResult = resultMoneyView.getText();
        capitalization.click();
        waitForChange(currentResult);
    }
    public void selectPartialOut(String isSelected){
        if (isSelected.equalsIgnoreCase("true")) {
            String currentResult = resultMoneyView.getText();
            partialOut.click();
            waitForChange(currentResult);
        }
    }
    public void selectOpenInBank(){
        openInBank.click();
    }
    public void selectOpenInOnlineBank(){
        openInOnlineBank.click();
    }

    public void waitForChange(String currentValue){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(ExpectedConditions
                    .textToBePresentInElement(resultMoneyView, currentValue)));
    }
}
