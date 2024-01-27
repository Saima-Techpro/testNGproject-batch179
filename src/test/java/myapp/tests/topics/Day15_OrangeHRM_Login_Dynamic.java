package myapp.tests.topics;


import myapp.pages.OrangeDashboardPage;
import myapp.pages.OrangeLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver1;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

public class Day15_OrangeHRM_Login_Dynamic {
//    Automate login functionality, using page object model
//    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//
//    Given user is the application login page
//    Then enter the credentials
//    Then verify the login is successful
//    And logout the application
//    Then verify the logout is successful

    @Test(groups = "minor_regression_group")
    public void orangeLoginTest(){

        //    Given user is the application login page
        //  Dynamic => we use ConfigReader
        Driver1.getDriver().get(ConfigReader.getProperty("hrm_url"));
        WaitUtils.waitFor(2);  // HARD WAIT

        //  Then enter the credentials
        // In order to access the webElements located in OrangeLogingPage, we have to create its object
        OrangeLoginPage orangeLoginPage = new OrangeLoginPage();  // creating the page object

        //  using PAGE SPECIFIC REUSABLE METHOD
        orangeLoginPage.login("Admin", "admin123");
        WaitUtils.waitFor(2);

        //    Then verify the login is successful
        OrangeDashboardPage orangeDashboardPage = new OrangeDashboardPage(); // creating the page object

//      Use Reusable Method - RECOMMENDED
        BrowserUtils.verifyElementDisplayed(orangeDashboardPage.profileLink);

        //    And logout the application

        BrowserUtils.clickWithTimeOut(orangeDashboardPage.profileLink, 5);  // dynamic custom method
        BrowserUtils.clickWithTimeOut(orangeDashboardPage.logoutButton, 5);  // dynamic custom method

        //    Then verify the logout is successful
        BrowserUtils.verifyElementDisplayed(orangeLoginPage.userName);  //      Use Reusable Method - RECOMMENDED

//        NOTE: WE DON'T GET StaleElementReferenceException IN PAGE OBJECT MODEL

        // Close the driver
        Driver1.closeDriver();

    }

}
