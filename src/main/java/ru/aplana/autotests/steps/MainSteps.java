package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выполнен поиск товара {0}")
    public void stepSearchProduct(String productName){
        mainPage.searchProduct(productName);
    }
    @Step("Закрыто сообщение про cookies")
    public void stepCloseCookies(){
        mainPage.closeCookies();
    }
    @Step("Закрыта всплывающая реклама(при наличии)")
    public void stepCloseAdvertisement(){
        mainPage.closePopupAdvertisement();
    }
    @Step("Выполнен переход в корзину")
    public void stepGoToCart(){
        mainPage.goToCart();
    }
}
