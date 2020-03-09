package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/login");
    }

    @AfterClass
    public static void closeApp() {
        driver.quit();
    }
}
