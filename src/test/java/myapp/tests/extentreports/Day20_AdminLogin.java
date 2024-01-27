package myapp.tests.extentreports;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

public class Day20_AdminLogin {

    /*
    ADD EXTENT REPORTS CAPABILITY
    1. use createTestReport(String name,String description) first for creating extent report capability
    2. then use any method to mark as pass, info, fail
    3. Then use flush to generate the report
 */

    /*
    ADD LOGGER REPORT CAPABILITY
    1. use any method from LoggerUtils directly.
     */

    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();


    @Test
    public void adminLoginWithExtentReports(){
//        Using logger utils
        LoggerUtils.info("Test case begins .. ");

//        1.......
        ExtentReportUtils.createTestReport("Smoke Test Report","Admin Login Test");

//        2......
        ExtentReportUtils.pass("Starting the admin login test...");
        //        As admin, I should be able to log in the application  https://www.bluerentalcars.com/
        //        Given user is on the application home page

//        ALTERNATIVELY get the url from config property
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

//        2.....
        ExtentReportUtils.pass("User is on the home page....");


//        Admin email: jack1@gmail.com
//        Admin password: 12345

//        ALTERNATIVELY - use reusable method to click with timeout dynamically
        blueRentalHomePage.userIcon.click();


//        2......
        ExtentReportUtils.pass("Navigated to the login page....");

//        ALTERNATIVELY - use reusable method to type with timeout dynamically

//        2.....
        ExtentReportUtils.info("Entering the username and password...Username : "+ConfigReader.getProperty("bluerental_email")+".Password : "+ConfigReader.getProperty("bluerental_password") );
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email,ConfigReader.getProperty("bluerental_email"),5);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password,ConfigReader.getProperty("bluerental_password"),5);

//        2.....
        ExtentReportUtils.passAndCaptureScreenshot(
                "Username : "+ConfigReader.getProperty("admin_username")
                        +" password : "+ConfigReader.getProperty("admin_password")+" are entered successfully");


//        Then click on login button
//        rentalLoginPage.loginButton.click();
//        WaitUtils.waitFor(2);
//        ALTERNATIVELY - use reusable method to click with timeout dynamically
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,5);

//        2......
        ExtentReportUtils.pass("Entered Admin credentials, and clicked on the login button successfully");

//        Then verify the login is successful
//        Assert.assertTrue(rentalHomePage.userID.isDisplayed());
//        ALTERNATIVELY - use reusable method to verify with timeout dynamically
        BrowserUtils.verifyElementDisplayed(blueRentalHomePage.userIcon);

//        2.....
        ExtentReportUtils.passAndCaptureScreenshot("Login is verified....");


//        close the browser
        Driver.closeDriver();

//        2.....
        ExtentReportUtils.pass("Driver is closed.... Test is completed successfully...");

//        3......
        ExtentReportUtils.flush();


//        Logger utils
        LoggerUtils.info("Test completed...");
    }
}
