package ru.aplana.autotests.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.hu.Ha;
import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.aplana.autotests.util.TestProperties;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseSteps {
    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static HashMap<String, String> variables = new HashMap<>();

    public static void setVariable(String key, String value){
        variables.put(key, value);
    }
    public static String getVariable(String key){
        return variables.get(key);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public static void startScenario() throws Exception {
        /*switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
