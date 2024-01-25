package myapp.tests.smoketest;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day19_Admin_Login_WithExtentReport {
//    As admin, I should be able to log in the application https://www.bluerentalcars.com/
//    Admin email: jack1@gmail.com
//    Admin password: 12345

    /*
    Add Extent Report Capability to this test
    1. use reateTestReport(String name,String description) first to create the Test Report
    2. use the methods that are stored in Utils Class such as pass, fail, info
    3. Remember to add ExtentReportUtils.flush(); as a last step to generate ExtentSpark Report
     */
    @Test
    public void admin_Login_WithResuableMethods2(){
//    Given user is on the application home page
        // Dynamic way
//        1.
        ExtentReportUtils.createTestReport("Smoke Test", "Admin Login Test" );
        Driver.getDriver().get(ConfigReader.getProperty("rentalcar_url"));

        ExtentReportUtils.pass("User is on the HomePage");

//    Then clicks on login link
        BlueRental_HomePage rentalCarHomePage = new BlueRental_HomePage(); // create the page object
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarHomePage.userIcon, 2);
        ExtentReportUtils.pass("User is able to click on the login button");
//    Then enters admin email, password
        BlueRental_LoginPage rentalCarLoginPage = new BlueRental_LoginPage(); // create the page object
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.email, ConfigReader.getProperty("admin_email"), 2);
        // USING REUSABLE METHOD
        BrowserUtils.sendKeysWithTimeout(rentalCarLoginPage.password, ConfigReader.getProperty("admin_password"), 2);

        ExtentReportUtils.info("User Credentials: Admin email: "
                +ConfigReader.getProperty("admin_email") + "Admin Password: "
                + ConfigReader.getProperty("admin_password"));

//    Then click on login button
        // USING REUSABLE METHOD
        BrowserUtils.clickWithTimeOut(rentalCarLoginPage.loginButton, 2);
        ExtentReportUtils.pass("User is able to login successfully");
//    Then verify the login is successful
        Assert.assertTrue(rentalCarLoginPage.userID.isDisplayed());
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is logged in");

        // Close the driver
        Driver.closeDriver();

        ExtentReportUtils.flush();

    }

}
