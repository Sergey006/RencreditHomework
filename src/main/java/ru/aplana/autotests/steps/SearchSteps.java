package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.SearchPage;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();
    @Step("Цена ограничена до {0}")
    public void stepLimitPriceTo(String value){
        searchPage.setPriceTo(value);
    }
    @Step("Выбран чекбокс 'Высокий рейтинг'")
    public void stepSelectHighRating(){
        searchPage.selectHighRating();
    }
    @Step("Выбрана оперативная память в {0} ГБ")
    public void stepSelectRAM(String valueRAM){
        searchPage.selectRAM(valueRAM);
    }

    @Step("Добавлены в корзину первые {0} четные:{1} товаров")
    public void stepAddProductsToCart(String quantity, String isEven){
        searchPage.addProductsToCart(quantity, isEven);
    }
    @Step("Выполнен клик по чекбоксу '{0}'")
    public void stepClickCheckbox(String checkboxName){
        searchPage.clickOptionCheckbox(checkboxName);
    }
    @Step("Выбран бренд '{0}'")
    public void stepSelectBrand(String brandName){
        searchPage.selectBrand(brandName);
    }
}
