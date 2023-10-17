package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {


    public OrangeLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Username
    @FindBy(name="username")
    public WebElement userName;

    // Password
    @FindBy(name="password")
    public WebElement password;

    // Login Button
    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;

    // We can create a reusable method that is specific to this page
    public void login(String userId, String pass){
        userName.sendKeys(userId);
        password.sendKeys(pass);
        loginButton.click();

    }




}
