package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.CatalogPage;

public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();

    @Step("Выбран продукт - {0}")
    public void stepAddProduct(String productName){
        catalogPage.addProduct(productName);
    }

}
