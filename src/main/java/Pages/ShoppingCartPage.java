package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
