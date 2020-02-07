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
    @FindBy(xpath="//ul[@id='desktopMenuMain']//a[text()]")
    List<WebElement> menuItems;
    @FindBy(xpath = "//a[@title='Перейти в корзину']")
    WebElement cart;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String menuItem){
        for (WebElement item:menuItems){
            if (item.getText().equalsIgnoreCase(menuItem)){
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найдён пункт меню " + menuItem);
    }
    public void goToCard(){
        cart.click();
    }

    /*public void selectMenuItem(String itemName){
        driver.findElement(By.xpath("//ul[@id='desktopMenuMain']/li/a[contains(text(), '"+itemName+"')]")).click();
    }

    public void selectSubmenuItem(String itemName){
        WebElement element = driver.findElement(By.xpath("//div[@class='main-menu__wrap']//a[contains(text(), '"+itemName+"')]"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }*/
}
