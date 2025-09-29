package hooks;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyHooks {
    WebDriver driver;

    @Before
    public void setup() {
        DriverFactory.initializeBrowser("chrome");
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}