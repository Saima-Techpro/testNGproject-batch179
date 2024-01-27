package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

public class BlueRental_NegativeTests {
    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRental_loginPage = new BlueRental_LoginPage();


    // FAKE EMAIL
    @Test
    public void negativeLoginTest() {

//    Go to: https://www.bluerentalcars.com/
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Click login button
        blueRentalHomePage = new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 2);

//    Enter fake email address and password
        blueRental_loginPage = new BlueRental_LoginPage();

        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_fake_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.password, ConfigReader.getProperty("bluerental_fake_password"), 2);
        BrowserUtils.clickWithTimeOut(blueRental_loginPage.loginButton,2);
        WaitUtils.waitFor(5);

//    Verify error message, "User with email fake@bluerentalcars.com not found"
        BrowserUtils.verifyExpectedAndActualTextMatch("User with email fake@bluerentalcars.com not found", blueRental_loginPage.errorMessage);

        Driver.closeDriver();
    }


//    CORRECT email address but INCORRECT password
    @Test
    public void badCredentialTest() {

//    Go to: https://www.bluerentalcars.com/
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Click login button
        blueRentalHomePage = new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 2);

//    Enter CORRECT email address but INCORRECT password
        blueRental_loginPage = new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.password, ConfigReader.getProperty("bluerental_fake_password"), 2);
        BrowserUtils.clickWithTimeOut(blueRental_loginPage.loginButton,2);
        WaitUtils.waitFor(5);

//    Verify error message, "Bad credentials"
        BrowserUtils.verifyExpectedAndActualTextMatch("Bad credentials", blueRental_loginPage.errorMessage);

        Driver.closeDriver();
    }

//    INVALID email format
    @Test
    public void invalidEmailTest(){

//    Go to: https://www.bluerentalcars.com/
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Click login button
        blueRentalHomePage = new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 2);

//    Enter INCORRECT email address but CORRECT password
        blueRental_loginPage = new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_incomplete_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.password, ConfigReader.getProperty("bluerental_password"), 2);

//    Verify error message, "email must be a valid email"
        BrowserUtils.verifyExpectedAndActualTextMatch("email must be a valid email", blueRental_loginPage.invalidEmailMessage);

//    Enter valid email domain
        WaitUtils.waitFor(2);

//        blueRental_loginPage.email.sendKeys(Keys.COMMAND + "a"); // select all => FOR MAC
////        blueRental_loginPage.email.sendKeys(Keys.CONTROL + "a"); // select all => FOR WINDOWS
//        WaitUtils.waitFor(2);
//        blueRental_loginPage.email.sendKeys(Keys.DELETE);  // Delete the incomplete email

//        OR
        blueRental_loginPage.deleteInputText();

//        Send the valid email
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_email"), 2);

//    Verify the error message no longer appears
        BrowserUtils.verifyElementNotDisplayed(blueRental_loginPage.invalidEmailMessage);

        Driver.closeDriver();
    }
}
