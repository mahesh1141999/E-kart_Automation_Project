package StepsDefination;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Map;


public class Register {
    WebDriver driver;
    @Given("User navigates to Register Accounts Page")
    public void user_navigates_to_register_accounts_page() {
        driver= DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
       driver.findElement(By.linkText("Register")).click();
    }

    @When("User enters the details into below fileds")
    public void user_enters_the_details_into_below_fileds(DataTable dataTable) {
    Map<String, String > dataMap= dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password"));
    }

    @And("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        driver.findElement(By.xpath("//input [@name= 'agree']")).click();

    }

    @And("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.xpath("//input [@value= 'Continue']")).click();

    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
     boolean b = driver.getTitle().equals("Your Account Has Been Created!");
        Assert.assertTrue(b);
    }

    @When("User Selects Yes for NewsLetter")
    public void user_selects_yes_for_news_letter() {
        driver.findElement(By.xpath("//*[text()= 'Yes']")).click();
    }

    @Then("User should get proper warning message about duplicate email")
    public void user_should_get_proper_warning_message_about_duplicate_email() {
      String message=  driver.findElement(By.xpath("//div [contains(@class, 'alert-dismissible')]")).getText();
      Assert.assertEquals("Warning: E-Mail Address is already registered!",message);
    }

    @When("User don't enters any details into  fileds")
    public void user_don_t_enters_any_details_into_fileds() {
   // intentionally blank
    }

    @Then("User should get proper warning message for every mandatory field")
    public void user_should_get_proper_warning_message_for_every_mandatory_field() {
     Assert.assertTrue(driver.findElement(By.xpath("//div [contains(text(), 'to the Privacy Policy!')]")).getText().contains("You must agree to the Privacy Policy!"));
     Assert.assertEquals("First Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//div [contains(text(), 'First Name must be')]")).getText());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//div [contains(text(), 'Last Name must be')]")).getText());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",driver.findElement(By.xpath("//div [contains(text(), 'E-Mail Address does')]")).getText());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",driver.findElement(By.xpath("//div [contains(text(), 'Telephone must be')]")).getText());
        Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//div [contains(text(), 'Password must be')]")).getText());
    }

}
