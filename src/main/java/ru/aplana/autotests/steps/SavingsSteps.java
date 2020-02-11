package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.SavingsPage;

public class SavingsSteps {
    SavingsPage savingsPage = new SavingsPage();

    @Step("выбран счёт {savingName}")
    public void stepSelectSaving(String savingName){
        savingsPage.selectSaving(savingName);
    }
}
