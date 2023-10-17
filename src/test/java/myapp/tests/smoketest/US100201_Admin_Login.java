package myapp.tests.smoketest;

import myapp.pages.RentalCar_HomePage;
import myapp.pages.RentalCar_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US100201_Admin_Login {
//    As admin, I should be able to log in the application https://www.bluerentalcars.com/
//    Admin email: jack1@gmail.com
//    Admin password: 12345


    @Test
    public void admin_Login(){
//    Given user is on the application home page
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Then clicks on login link
        RentalCar_HomePage rentalCarHomePage = new RentalCar_HomePage(); // create the page object
        rentalCarHomePage.loginButton.click();
        WaitUtils.waitFor(2);

//    Then enters admin email, password
        RentalCar_LoginPage rentalCarLoginPage = new RentalCar_LoginPage(); // create the page object
        rentalCarLoginPage.email.sendKeys("jack1@gmail.com");
        WaitUtils.waitFor(2);
        rentalCarLoginPage.password.sendKeys("12345");
        WaitUtils.waitFor(2);

//    Then click on login button
        rentalCarLoginPage.loginButton.click();
        WaitUtils.waitFor(2);
//    Then verify the login is successful
        Assert.assertTrue(rentalCarLoginPage.userID.isDisplayed());
        WaitUtils.waitFor(2);

        // Close the driver
        Driver.closeDriver();

    }

    @Test
    public void admin_Login_WithResuableMethods(){
//    Given user is on the application home page
//        Driver.getDriver().get("https://www.bluerentalcars.com/");
        // Dynamic way
        Driver.getDriver().get(ConfigReader.getProperty("rentalcar_url"));

//    Then clicks on login link
        RentalCar_HomePage rentalCarHomePage = new RentalCar_HomePage(); // create the page object
//        rentalCarHomePage.loginButton.click();
//        WaitUtils.waitFor(2);

        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarHomePage.loginButton, 2);

//    Then enters admin email, password
        RentalCar_LoginPage rentalCarLoginPage = new RentalCar_LoginPage(); // create the page object
//        rentalCarLoginPage.email.sendKeys("jack1@gmail.com");
//        rentalCarLoginPage.email.sendKeys(ConfigReader.getProperty("admin_email")); // DYNAMIC WAY
//        WaitUtils.waitFor(2);
        // USING REUSABLE METHOD
//        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.email, "jack1@gmail.com", 2);
        // OR
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.email, ConfigReader.getProperty("admin_email"), 2);

//        rentalCarLoginPage.password.sendKeys("12345");
//        rentalCarLoginPage.password.sendKeys(ConfigReader.getProperty("admin_password")); // DYNAMIC WAY
//        WaitUtils.waitFor(2);

        // USING REUSABLE METHOD
//        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.password, "12345", 2);
        // OR
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.password, ConfigReader.getProperty("admin_password"), 2);

//    Then click on login button
//        rentalCarLoginPage.loginButton.click();
//        WaitUtils.waitFor(2);

        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarLoginPage.loginButton, 2);

//    Then verify the login is successful
        Assert.assertTrue(rentalCarLoginPage.userID.isDisplayed());
        WaitUtils.waitFor(2);

        // Close the driver
        Driver.closeDriver();

    }
    @Test
    public void admin_Login_WithResuableMethods2(){
//    Given user is on the application home page
        // Dynamic way
        Driver.getDriver().get(ConfigReader.getProperty("rentalcar_url"));
//    Then clicks on login link
        RentalCar_HomePage rentalCarHomePage = new RentalCar_HomePage(); // create the page object
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarHomePage.loginButton, 2);
//    Then enters admin email, password
        RentalCar_LoginPage rentalCarLoginPage = new RentalCar_LoginPage(); // create the page object
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.email, ConfigReader.getProperty("admin_email"), 2);
        // USING REUSABLE METHOD
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.password, ConfigReader.getProperty("admin_password"), 2);
//    Then click on login button
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarLoginPage.loginButton, 2);

//    Then verify the login is successful
        Assert.assertTrue(rentalCarLoginPage.userID.isDisplayed());
        WaitUtils.waitFor(2);

        // Close the driver
        Driver.closeDriver();

    }

}