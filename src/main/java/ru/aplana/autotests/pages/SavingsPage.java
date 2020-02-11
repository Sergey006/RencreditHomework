package ru.aplana.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class SavingsPage {
    public SavingsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath="//div[@class='b-card__content']")
    List<WebElement> savingsList;

    public void selectSaving(String savingName){
        for (WebElement item:savingsList){
            if (item.findElement(By.xpath("./div[@class='b-card__title']/p")).getText().contains(savingName)){
                item.findElement(By.xpath(".//a[@class='button'][contains(text(),'счет')]")).click();
                return;
            }
        }
    }
}
