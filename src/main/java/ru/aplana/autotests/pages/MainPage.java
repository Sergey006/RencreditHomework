package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    @FindBy(xpath = "//ul[@class='main-menu']//a")
    List<WebElement> menuElements;

    @FindBy(xpath = "//a[@class='menu-section-link']")
    List<WebElement> submenuElements;
    @FindBy(xpath = "//div[@class='informer__btns']/div[contains(text(), 'Да')]")
    WebElement agreementYes;

    public void selectMenuItem(String menuItem){
        for (WebElement item : menuElements){
            if (item.getText().contains(menuItem)){
                item.click();
                return;
            }
        }
        Assert.fail("Не найден пункт "+ menuItem);
    }

    public void selectSubmenuItem(String submenuItem){
        for (WebElement item : submenuElements){
            if (item.getText().contains(submenuItem)){
                item.click();
                return;
            }
        }
        Assert.fail("Не найден пункт "+ submenuItem);
    }
    public void agreeCity(){
        agreementYes.click();
    }
}
