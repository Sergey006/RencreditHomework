package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step("Купить всё")
    public void stepBuyProducts(){
        cartPage.buyProducts();
    }
    @Step("Проверка корзины на содержание выбранных товаров")
    public void stepCheckCart(){
        cartPage.checkCart();
    }

}
