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
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.aplana.autotests.util.Product;
import ru.aplana.autotests.util.TestProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseSteps {
    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();
    public static ArrayList<Product> cartProducts;
    public static void addToCart(Product product){
        cartProducts.add(product);
    }
    public static WebDriver getDriver(){
        return driver;
    }
    @Before
    public static void startScenario() throws Exception {
        switch (properties.getProperty("browser")) {
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
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        cartProducts = new ArrayList<>();
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public static ArrayList<Product> printProducts(){
        return cartProducts;
    }
    @Attachment
    public static Product printMaxPriceProduct(){
        return cartProducts.stream().max(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getPrice()) - Integer.parseInt(o2.getPrice());
            }
        }).get();
    }
}
