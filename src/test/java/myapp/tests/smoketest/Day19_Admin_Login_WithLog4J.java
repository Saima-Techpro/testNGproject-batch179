package myapp.tests.smoketest;

import myapp.pages.RentalCar_HomePage;
import myapp.pages.RentalCar_LoginPage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day19_Admin_Login_WithLog4J {
//    As admin, I should be able to log in the application https://www.bluerentalcars.com/
//    Admin email: jack1@gmail.com
//    Admin password: 12345

    /*
    Using Log4J for this test class
     */


    @Test
    public void admin_Login_WithResuableMethods2(){
//    Given user is on the application home page
        // Dynamic way
//        1.
        LoggerUtils.info("Smoke Test");

        Driver.getDriver().get(ConfigReader.getProperty("rentalcar_url"));

        LoggerUtils.info("User is on the HomePage");

//    Then clicks on login link
        RentalCar_HomePage rentalCarHomePage = new RentalCar_HomePage(); // create the page object
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarHomePage.loginButton, 2);
        LoggerUtils.info("User is able to click on the login button");
//    Then enters admin email, password
        RentalCar_LoginPage rentalCarLoginPage = new RentalCar_LoginPage(); // create the page object
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.email, ConfigReader.getProperty("admin_email"), 2);
        // USING REUSABLE METHOD
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.password, ConfigReader.getProperty("admin_password"), 2);

        LoggerUtils.warn("User Credentials: Admin email: "
                +ConfigReader.getProperty("admin_email") + "Admin Password: "
                + ConfigReader.getProperty("admin_password"));

//    Then click on login button
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarLoginPage.loginButton, 2);
        LoggerUtils.info("User is able to login successfully");
//    Then verify the login is successful
        Assert.assertTrue(rentalCarLoginPage.userID.isDisplayed());
        WaitUtils.waitFor(2);
        LoggerUtils.info("User is logged in");

        // Close the driver
        Driver.closeDriver();


    }

}
