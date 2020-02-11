package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;

public class EveryDayPage extends BasePage{

    @FindBy(xpath="//h1")
    WebElement title;
    @FindBy(xpath="//div[@class='fullname']//input[contains(@class,'aa-input')]")
    WebElement fioInput;
    @FindBy(xpath="//div[@data-field='root.birthDate']//input")
    WebElement birthDate;
    @FindBy(xpath="//div[@data-field='root.phone.phone']//input")
    WebElement phone;
    @FindBy(xpath="//select[contains(@id,'city')]/..")
    WebElement citySelect;
    @FindBy(xpath="//select[contains(@id,'city')]/../..//input")
    WebElement cityInput;
    @FindBy(xpath = "//select[contains(@id,'branch')]/..")
    WebElement branchSelect;
    @FindBy(xpath="//select[contains(@id,'branch')]/../..//input")
    WebElement branchInput;
    @FindBy(xpath = "//input[contains(@id, 'checkbox')]/..")
    WebElement checkbox;


    public EveryDayPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void checkTitle(String titleName){
        Assert.assertTrue(title.getText().contains(titleName));
    }
    public void selectCity(String cityName){
        citySelect.click();
        fillField(cityInput, cityName);
    }
    public void selectBranch(String branchName){
        branchSelect.click();
        fillField(branchInput, branchName);
    }
    public void selectCheckbox(){
        checkbox.click();
    }
    public void fillField(String name, String value){
        switch(name){
            case "ФИО":
                fillField(fioInput, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                break;
            case "Телефон":
                fillField(phone, value);
                break;
            default: Assert.fail("Не найдено поле " + value);
        }
    }
}
