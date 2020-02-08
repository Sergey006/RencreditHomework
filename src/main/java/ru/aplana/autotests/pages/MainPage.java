package ru.aplana.autotests.pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;


public class MainPage extends BasePage {

    @FindBy(xpath="//div[@class='service__title-text']/..")
    List<WebElement> menuItems;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String menuItem){
        for (WebElement item:menuItems){
            if (item.findElement(By.xpath("./div")).getText().equalsIgnoreCase(menuItem)){
                new WebDriverWait(driver, 10).
                        until(ExpectedConditions.elementToBeClickable(item.findElement(By.xpath("./a")))).
                        click();
                return;
            }
        }
        Assert.fail("Не найдён пункт меню " + menuItem);
    }
}
