package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//div[@class='product-info']")
    List<WebElement> products;

    public void addProduct(String productName){
        for (WebElement item:products){
            if (item.findElement(By.xpath(".//a[@title]")).
                    getAttribute("title").
                    equalsIgnoreCase(productName)){
                String price = item.findElement(By.xpath(".//span[@class='price']")).getText().replaceAll("\\D","");
                BaseSteps.setVariable(productName, price);
                item.findElement(By.xpath(".//button[@title='Заказать']")).click();
                return;
            }
            Assert.fail("Не найден продукт");
        }
    }
}
