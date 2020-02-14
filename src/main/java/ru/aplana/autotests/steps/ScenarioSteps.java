package ru.aplana.autotests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    SearchSteps searchSteps = new SearchSteps();
    CartSteps cartSteps = new CartSteps();

/*
    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> everyDaySteps.stepFillField((String)field, (String)value)); }
*/


    @When("^выполнен поиск товара '\"(.+)\"'$")
    public void searchProduct(String productName){
        mainSteps.stepSearchProduct(productName);
    }
    @When("^выбрана цена до '\"(.+)\"'$")
    public void limitPriceTo(String priceTo){
        searchSteps.stepLimitPriceTo(priceTo);
    }
    @When("^выполнен клик по чекбоксу 'Высокий рейтинг'$")
    public void selectHighRating(){
        searchSteps.stepSelectHighRating();
    }
    @When("^выбрано значение оперативной памяти в \"(.+)\" ГБ$")
    public void selectRAM(String value){
        searchSteps.stepSelectRAM(value);
    }
    @When("^закрыто сообщение про cookies$")
    public void closeCookies(){
        mainSteps.stepCloseCookies();
    }
    @When("^в корзину добавлены первые восемь нечётных товаров$")
    public void addToCartFirstEightOddProducts(){
        searchSteps.stepAddToCartFirstEightOddProducts();
    }
    @When("^выполнен переход в корзину$")
    public void goToCart(){
        mainSteps.stepGoToCart();
    }
    @When("^куплены товары$")
    public void buyProducts(){
        cartSteps.stepBuyProducts();
    }
    @When("^выполнена проверка наличия выбранных товаров в корзине$")
    public void checkCart(){
        cartSteps.stepCheckCart();
    }

}
