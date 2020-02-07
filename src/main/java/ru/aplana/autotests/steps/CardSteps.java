package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ru.aplana.autotests.pages.CartPage;

public class CardSteps {
    CartPage cartPage = new CartPage();
    @Step("Товар {0} найден в корзине")
    public void stepCheckExistProduct(String productName){
        Assert.assertTrue("Не найден продукт "+ productName, cartPage.productExist(productName));
    }

    @Step("Проверка суммы ")
    public void stepCheckAmount(int expectedAmount){
        Assert.assertEquals(expectedAmount, Integer.parseInt(cartPage.getTotalAmount()));
    }
}
