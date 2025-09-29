package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement Password;

    @FindBy(id = "input-confirm")
    private WebElement ConfirmPassword;

    @FindBy(xpath = "//input [@name= 'agree']")
    private WebElement AgreePolicy;

    @FindBy(xpath ="//input [@value= 'Continue']" )
    private WebElement ContinueButton;

    @FindBy(xpath ="//*[text()= 'Yes']" )
    private WebElement SelectYesOption;

    public void enterFirstName(String FirstName) {
        firstName.sendKeys(FirstName);
    }

    public void enterLastName(String LastName) {
        lastName.sendKeys(LastName);
    }

    public void enterEmail(String Email) {
        email.sendKeys(Email);
    }

    public void enterTelephone(String Phone) {
        telephone.sendKeys(Phone);
    }

    public void enterPassword(String password) {
        Password.sendKeys(password);
    }

    public void enterConfirmPassword(String confPassword) {
        ConfirmPassword.sendKeys(confPassword);
    }

    public void clickOnAgreePolicy (){
        AgreePolicy.click();
    }

    public void clickOnContinueButton (){
        ContinueButton.click();
    }
    public void clickOnYesOption (){
        SelectYesOption.click();
    }


}
