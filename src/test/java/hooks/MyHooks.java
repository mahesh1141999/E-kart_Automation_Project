package hooks;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MyHooks {
    WebDriver driver;

    @Before
    public void setup() throws IOException {
        Properties prop = ConfigReader.intializeProperties();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}