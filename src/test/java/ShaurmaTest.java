
import cucumber.api.java.it.Ma;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.aplana.autotests.pages.CatalogPage;
import ru.aplana.autotests.pages.MainPage;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.steps.CardSteps;
import ru.aplana.autotests.steps.CatalogSteps;
import ru.aplana.autotests.steps.MainSteps;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ShaurmaTest extends BaseSteps {

    @Test
    @DisplayName("Проверка корзины")
    public void testMethod() throws InterruptedException {
        MainSteps mainSteps = new MainSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        CardSteps cardSteps = new CardSteps();

        mainSteps.stepSelectMenu("Меню доставки");
        mainSteps.stepSelectMenu("Бургеры и Шаурма");
        catalogSteps.stepAddProduct("Шаурма с бараниной");

        //AllureJunit4 - testFailure(){
        // takeScreenshot}
        //-DforkCount=0
    }

}
