package ru.aplana.autotests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.aplana.autotests"},
        plugin = {"pretty",
            "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
        }
)
public class CucumberRunner {
        /*
        *
        * И выполнен поиск товара '"iphone"'
    И выбрана цена до '"100000"'
    И выбрано значение оперативной памяти в "3" ГБ
    И выполнен клик по чекбоксу 'Высокий рейтинг'
    И в корзину добавлены первые восемь нечётных товаров
        *
        *
        * */
}
