package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step("Купить всё")
    public void stepBuyProducts(){
        cartPage.buyProducts();
    }
    @Step("Проверка корзины на содержание добавленных товаров")
    public void stepCheckCart(){
        cartPage.checkCart();
    }
    @Step("Проверка наличия в корзине {0} товаров")
    public void stepCheckProductsQuantity(String quantity){
        cartPage.checkProductsQuantity(quantity);
    }
    @Step("Удаление товаров из корзины")
    public void stepRemoveProducts(){
        cartPage.removeChosenProducts();
    }
    @Step("Проверка пустоты корзины")
    public void stepCheckCartEmptiness(){
        cartPage.checkCartEmptiness();
    }

}
