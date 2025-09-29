package StepsDefination;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login {
    WebDriver driver;
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver= DriverFactory.getDriver();
        driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("USer has entered valid email address {string} into the email filed")
    public void u_ser_has_entered_valid_email_address_into_the_email_filed(String emailText) {
        driver.findElement(By.id("input-email")).sendKeys(emailText);
    }

    @And("User has entered valid password {string} into password filed")
    public void user_has_entered_valid_password_into_password_filed(String passwordText) {
        driver.findElement(By.id("input-password")).sendKeys(passwordText);

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//input [@type='submit']")).click();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

    }

    @When("USer has entered invalid email address {string} into the email filed")
    public void u_ser_has_entered_invalid_email_address_into_the_email_filed(String invalidEmailText) {
        driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);
    }

    @When("User has entered invalid password {string} into password filed")
    public void user_has_entered_invalid_password_into_password_filed(String invalidPasswordText) {
        driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
    }


    @Then("User should get warning message about credentials mismatch")
    public void user_should_get_warning_message_about_credentials_mismatch() {
        boolean b=  driver.findElement(By.xpath("//div [contains(@class, 'alert alert-danger')]")).getText().equals("Warning: No match for E-Mail Address and/or Password.");
        Assert.assertTrue(b);
    }

    @When("User don't enter email address into email field")
    public void user_don_t_enter_email_address_into_email_field() {
        driver.findElement(By.id("input-email")).sendKeys("");
    }

    @When("User don't enter password address into password field")
    public void user_don_t_enter_password_address_into_password_field() {
        driver.findElement(By.id("input-password")).sendKeys("");
    }

}
