package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {
    /*
    1. Create a constructor and use PageFactory to initialise the page objects
    2. Locate the elements using FindBy annotation

    Traditional / JUnit way:   WebElement userName = driver.findElement(BY.id("username));
     NOTE:  we could make that as public too but we didn't need as the element was inside the same class

    TestNG syntax:
    @FindBy(any locator) public WebElement nameOfTheElement;
    OR
    @FindBy(any locator)
    public WebElement nameOfTheElement;
    NOTE: We have to make elements as public because they're located in Page class different from test class
     */

    public OrangeLoginPage() {  // constructor
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

    // NOTE: We can ALSO create a reusable method that is PAGE SPECIFIC METHOD
    public void login(String userId, String pass){
        userName.sendKeys(userId);
        password.sendKeys(pass);
        loginButton.click();

    }




}
