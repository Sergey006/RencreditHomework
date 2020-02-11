package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.EveryDayPage;

public class EveryDaySteps {
    EveryDayPage everyDayPage = new EveryDayPage();

    @Step("проверка, что заголовок содержит {0}")
    public void stepCheckTitle(String title){
        everyDayPage.checkTitle(title);
    }
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        everyDayPage.fillField(field, value);
    }
    @Step("выбран город {0}")
    public void stepSelectCity(String cityName){
        everyDayPage.selectCity(cityName);
    }
    @Step("выбрано отделение {0}")
    public void stepSelectBranch(String branchName){
        everyDayPage.selectBranch(branchName);
    }
    @Step("клик по чекбоксу согласия")
    public void stepSelectCheckbox(){
        everyDayPage.selectCheckbox();
    }



}
