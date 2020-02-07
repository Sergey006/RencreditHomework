package ru.aplana.autotests.steps;

import com.sun.tools.script.shell.Main;
import io.qameta.allure.Step;
import ru.aplana.autotests.pages.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("Выбран пункт меню - {0}")
    public void stepSelectMenu(String menuName){
        mainPage.selectMenuItem(menuName);
    }

    @Step("Выполнен переход в корзину")
    public void stepGoToCard(){
        mainPage.goToCard();
    }
}
