package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()= 'My Account']")
    private WebElement myAccountDropMenu;
    @FindBy(linkText = "Login")
    private WebElement loginOption;
    @FindBy(xpath = "//div [@id='search']/input [@name='search']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    @FindBy(xpath = "//*[contains (text(), 'There is no product')]")
    private WebElement matchNotFoundWarning;
    @FindBy(xpath = "//div[@class=\"button-group\"]/child::button[1]")
    private WebElement addToCartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount() {

        myAccountDropMenu.click();
    }

    public void clickOnLoginOption() {
        loginOption.click();
    }

    public void clickOnRegisterOption() {
        registerOption.click();
    }

    public void EnterTextInSearchBox(String text) {
        searchBox.sendKeys(text);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public String matchNotFoundWarning() {
        return matchNotFoundWarning.getText();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

}
