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

    @Step("Добавлены в корзину первые восемь нечетных товаров")
    public void stepAddToCartFirstEightOddProducts(){
        searchPage.buyFirstEightOddProducts();
    }

}
