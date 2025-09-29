package StepsDefination;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import driverFactory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
    WebDriver driver;
    private LoginPage loginPage;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {

        driver = DriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLoginOption();
        loginPage = new LoginPage(driver);
    }

    @When("USer has entered valid email address {string} into the email filed")
    public void u_ser_has_entered_valid_email_address_into_the_email_filed(String emailText) {

        loginPage.enterEmailAddress(emailText);
    }

    @And("User has entered valid password {string} into password filed")
    public void user_has_entered_valid_password_into_password_filed(String passwordText) {
        loginPage.enterPassword(passwordText);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        AccountPage accountpage = new AccountPage(driver);
        Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInfoOption());

    }

    @When("USer has entered invalid email address {string} into the email filed")
    public void u_ser_has_entered_invalid_email_address_into_the_email_filed(String emailText) {

        loginPage.enterEmailAddress(emailText);
    }

    @When("User has entered invalid password {string} into password filed")
    public void user_has_entered_invalid_password_into_password_filed(String invalidPasswordText) {
        loginPage.enterPassword(invalidPasswordText);
    }


    @Then("User should get warning message about credentials mismatch")
    public void user_should_get_warning_message_about_credentials_mismatch() {
        boolean b = loginPage.displayCredentialsMismatchMessage();
        Assert.assertTrue(b);
    }

    @When("User don't enter email address into email field")
    public void user_don_t_enter_email_address_into_email_field() {
        loginPage.enterEmailAddress("");
    }

    @When("User don't enter password address into password field")
    public void user_don_t_enter_password_address_into_password_field() {
        loginPage.enterPassword("");
    }

}
