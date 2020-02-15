package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.util.Product;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage() { PageFactory.initElements(BaseSteps.getDriver(), this); }

    @FindBy(xpath = "//button[@qa-id='cart-proceed-to-checkout-btn']")
    WebElement buy;
    @FindBy(xpath = "//div[contains(text(),'гр')]/../../..")
    List<WebElement> productsCards;

    public void checkCart(){
        ArrayList<Product> currentProductsInCart = new ArrayList<>();
        for (WebElement item : productsCards){
            String productName = item.findElement(By.xpath(".//a/span")).getText();
            String productPrice = item.
                    findElements(By.xpath(".//span[contains(text(), '₽') and not(contains(text(),'Кредит'))]")).
                    get(0).getText().replaceAll("\\D","");
            currentProductsInCart.add(new Product(productName, productPrice));
        }
        for (Product p : BaseSteps.cartProducts){
            if (!currentProductsInCart.contains(p)){
                Assert.fail("В корзине не хватает продукта: " + p);
            }
            System.out.println(p);
        }
    }

    public void buyProducts(){
        buy.click();
    }
}
