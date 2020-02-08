package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ru.aplana.autotests.pages.ContributionPage;

public class ContributionSteps {
    ContributionPage contributionPage = new ContributionPage();

    @Step("Выбрана валюта '{0}'")
    public void stepSelectCurrency(String currency){
        contributionPage.selectCurrency(currency);
    }
    @Step("Выбран период - '{0} месяцев'")
    public void stepSelectPeriod(String period){
        contributionPage.selectPeriod(period);
    }
    @Step("Поле '{0}' заполняется значением '{1}'")
    public void stepFillField(String field, String value){
        contributionPage.fillField(field, value);
    }
    @Step("Выбран пункт 'Капитализация'")
    public void stepSelectCapitalization(){
        contributionPage.selectCapitalization();
    }

    @Step("Выбран пункт 'Частичное снятие': {0}")
    public void stepSelectPartialOut(String isSelected){
        contributionPage.selectPartialOut(isSelected);
    }
    @Step("Выбрана опция 'Открытие вклада в отделении банка'")
    public void stepSelectOpenInBank(){
        contributionPage.selectOpenInBank();
    }
    @Step("Выбрана опция 'Открытие вклада в онлайн банке'")
    public void stepSelectOpenInOnlineBank(){
        contributionPage.selectOpenInOnlineBank();
    }

    @Step("Поле '{0}' отображает значение '{1}'")
    public void stepCheckField(String field, String value){
        String realValue = contributionPage.getFieldValue(field).replaceAll(" ","");
        Assert.assertEquals("Поле " + field + " имеет значение "+ realValue,value, realValue);
        //Assert.assertEquals(value, contributionPage.getFieldValue(field).replaceAll(" ",""));
    }


}
