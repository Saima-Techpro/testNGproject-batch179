package myapp.pages;

import myapp.utilities.Driver1;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_LoginPage {
    // 1. create constructor and initiate PageFactory
    // 2. Locate and store webElements

    public BlueRental_LoginPage(){
        PageFactory.initElements(Driver1.getDriver(), this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement email;
    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;

    @FindBy (id = "dropdown-basic-button")
    public WebElement dropDown;

    @FindBy (linkText = "Logout")
    public WebElement logoutOption;

    @FindBy (xpath = "//button[text()='OK']")
    public WebElement okOption;

    @FindBy(xpath = "//div[@role='alert']")   //div[contains(text(),'User')]
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'Bad')]")
    public WebElement badCredPopUp;

    @FindBy (xpath = "//div[contains(text(),'User')]")
    public WebElement fakeErrorMessage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidEmailMessage;

    public void deleteInputText() {
        email.sendKeys(Keys.COMMAND + "a"); // select all => FOR MAC
//        email.sendKeys(Keys.CONTROL + "a"); // // select all => FOR WINDOWS
        email.sendKeys(Keys.DELETE);
    }


}
