package ru.aplana.autotests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    ContributionSteps contributionSteps = new ContributionSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenu(String menuName){
        mainSteps.stepSelectMenu(menuName);
    }


    @When("^выбрана валюта - \"(.+)\"$")
    public void selectCurrency(String currency){
        contributionSteps.stepSelectCurrency(currency);
    }
    @When("^заполняются поля:$")
    public void fillField(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> contributionSteps.stepFillField((String)field, (String)value));
    }
    @When("^выбран период - \"(.+)\" месяцев$")
    public void selectPeriod(String period){
        contributionSteps.stepSelectPeriod(period);
    }
    @When("^выбран пункт 'Капитализация'$")
    public void selectCapitalization(){
        contributionSteps.stepSelectCapitalization();
    }
    @When("^выбран пункт 'Частичное снятие': \"(.+)\"$")
    public void selectPartialOut(String isSelected){
        contributionSteps.stepSelectPartialOut(isSelected);
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> contributionSteps.stepCheckField((String)field, (String)value));
    }






}
