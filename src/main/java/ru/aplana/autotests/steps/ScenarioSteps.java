package ru.aplana.autotests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import ru.aplana.autotests.pages.SavingsPage;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    SavingsSteps savingsSteps = new SavingsSteps();
    EveryDaySteps everyDaySteps = new EveryDaySteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenu(String menuItem){
        mainSteps.stepSelectElement(menuItem);
    }
    @When("^выбран подпункт меню \"(.+)\"$")
    public void selectSubMenu(String menuItem){
        mainSteps.stepSelectSubmenuElement(menuItem);
    }
    @When("^подтвержден город$")
    public void selectAgreeCity(){
        mainSteps.stepAgreeCity();
    }

    @When("^выбран счёт \"(.+)\"$")
    public void selectSaving(String savingName){
        savingsSteps.stepSelectSaving(savingName);
    }
    @Then("^заголовок страницы содержит \"(.+)\"$")
    public void checkTitle(String title){
        everyDaySteps.stepCheckTitle(title);
    }
    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> everyDaySteps.stepFillField((String)field, (String)value));

    }
    @When("^выбран город \"(.+)\"$")
    public void selectCity(String cityName){
        everyDaySteps.stepSelectCity(cityName);
    }
    @When("^выбрано отделение \"(.+)\"$")
    public void selectBranch(String branchName){
        everyDaySteps.stepSelectBranch(branchName);
    }
    @When("^кликнут чекбокс согласия$")
    public void selectAgree(){
        everyDaySteps.stepSelectCheckbox();
    }

}
