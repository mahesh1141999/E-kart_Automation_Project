package StepsDefination;

import Pages.HomePage;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
    WebDriver driver;
    HomePage homePage;
    @Given("User opens the Application")
    public void user_opens_the_application() {

        driver = DriverFactory.getDriver();
         homePage = new HomePage(driver);

    }

    @When("User enters valid product {string} into Search box filed")
    public void user_enters_valid_product_into_search_box_filed(String validProduct) {
      homePage.EnterTextInSearchBox(validProduct);
    }

    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        homePage.clickOnSearchButton();
    }

    @Then("User should get valid product displays in search results")
    public void user_should_get_valid_product_displays_in_search_results() {
        Assert.assertEquals("HP LP3065", driver.findElement(By.linkText("HP LP3065")).getText());
    }

    @When("User enters invalid product {string} into Search box filed")
    public void user_enters_invalid_product_into_search_box_filed(String invalidProduct) {
        homePage.EnterTextInSearchBox(invalidProduct);
    }


    @When("User don't enters any product name into search box field")
    public void user_don_t_enters_any_product_name_into_search_box_field() {
     // intentionally blank
    }

    @Then("User should get message about no product matching")
    public void user_should_get_message_about_no_product_matching() {
        Assert.assertEquals("There is no product that matches the search criteria.", homePage.matchNotFoundWarning());

    }
}
