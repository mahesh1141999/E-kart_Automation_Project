package StepsDefination;

import Pages.HomePage;
import Pages.RegisterPage;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class Register {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("User navigates to Register Accounts Page")
    public void user_navigates_to_register_accounts_page() {
        driver = DriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnRegisterOption();
        registerPage = new RegisterPage(driver);
    }

    @When("User enters the details into below fileds")
    public void user_enters_the_details_into_below_fileds(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(dataMap.get("email"));
        registerPage.enterTelephone(dataMap.get("telephone"));

        registerPage.enterPassword(dataMap.get("Password"));
        registerPage.enterConfirmPassword(dataMap.get("Password"));
    }

    @And("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        registerPage.clickOnAgreePolicy();

    }

    @And("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        registerPage.clickOnContinueButton();
    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        boolean b = driver.getTitle().equals("Your Account Has Been Created!");
        Assert.assertTrue(b);
    }

    @When("User Selects Yes for NewsLetter")
    public void user_selects_yes_for_news_letter() {

        registerPage.clickOnYesOption();
    }

    @Then("User should get proper warning message about duplicate email")
    public void user_should_get_proper_warning_message_about_duplicate_email() {
        String message = driver.findElement(By.xpath("//div [contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertEquals("Warning: E-Mail Address is already registered!", message);
    }

    @When("User don't enters any details into  fileds")
    public void user_don_t_enters_any_details_into_fileds() {
        // intentionally blank
    }

    @Then("User should get proper warning message for every mandatory field")
    public void user_should_get_proper_warning_message_for_every_mandatory_field() {
        Assert.assertTrue(driver.findElement(By.xpath("//div [contains(text(), 'to the Privacy Policy!')]")).getText().contains("You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div [contains(text(), 'First Name must be')]")).getText());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div [contains(text(), 'Last Name must be')]")).getText());
        Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//div [contains(text(), 'E-Mail Address does')]")).getText());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//div [contains(text(), 'Telephone must be')]")).getText());
        Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//div [contains(text(), 'Password must be')]")).getText());
    }

}
