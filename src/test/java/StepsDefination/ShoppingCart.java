package StepsDefination;

import Pages.HomePage;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class ShoppingCart {
    WebDriver driver;
    HomePage homePage;
    @And("Click on the Add to cart button")
    public void Click_on_the_Add_to_cart_button () {
       // driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnAddToCartButton();

    }
}
