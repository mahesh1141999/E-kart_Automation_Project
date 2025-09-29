package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy (xpath = "//input [@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div [contains(@class, 'alert alert-danger')]")
    private WebElement credentialsMismatchMassage;


    public void enterEmailAddress(String emailText) {

        emailField.sendKeys(emailText);

    }


    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }

    public boolean displayCredentialsMismatchMessage (){
        return credentialsMismatchMassage.getText().equals("Warning: No match for E-Mail Address and/or Password.");
    }
}
