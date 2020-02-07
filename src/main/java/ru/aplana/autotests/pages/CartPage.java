package ru.aplana.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//td[@class='product-name']/a[text()]")
    List<WebElement> collectionCard;

    @FindBy(xpath = "//span[@id='cartPrice']")
    WebElement totalAmount;

    public boolean productExist(String productName){
        for (WebElement product : collectionCard){
            if (product.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public String getTotalAmount(){
        return totalAmount.getText();
    }
}
