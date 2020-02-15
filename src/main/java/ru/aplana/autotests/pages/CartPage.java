package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    @FindBy(xpath="//span[contains(text(),'Удалить выбранные')]")
    WebElement removeChosenProducts;
    @FindBy(xpath = "//h1[contains(text(), 'Корзина пуста')]")
    WebElement header;
    @FindBy(xpath="//span[contains(text(), 'Ваша корзина')]/../span[contains(text(),'товар')]")
    WebElement productsInCartQuantity;

    By removeWindowButton = By.xpath("//button/div/div[contains(text(),'Удалить')]");

    public void checkCartEmptiness(){
        Assert.assertTrue(header.isDisplayed());
    }
    public void checkProductsQuantity(String quantity){
        if (quantity.equalsIgnoreCase("все")){
            quantity = BaseSteps.cartProducts.size() + "";
        }
        String currentQuantity = productsInCartQuantity.getText().split("товар")[0].trim();
        Assert.assertEquals("Проверка, что фактическое количество товаров в корзине '"+ currentQuantity
                + "' равно ожидаемому '"+ quantity +"'", currentQuantity, quantity);
    }
    public void removeChosenProducts(){
        removeChosenProducts.click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.presenceOfElementLocated(removeWindowButton)).click();
    }
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
