package myapp.tests.topics;


import myapp.pages.OrangeDashboardPage;
import myapp.pages.OrangeLoginPage;
import myapp.utilities.Driver1;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_OrangeHRM_Login {
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
         Driver1.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WaitUtils.waitFor(2);  // HARD WAIT

        //  Then enter the credentials
        // In order to access the webElements located in OrangeLogingPage, we have to create its object
        OrangeLoginPage orangeLoginPage = new OrangeLoginPage();  // creating the page object
//        orangeLoginPage.userName.sendKeys("Admin");
//        orangeLoginPage.password.sendKeys("admin123");
//        orangeLoginPage.loginButton.click();
        // OR using PAGE SPECIFIC REUSABLE METHOD
        orangeLoginPage.login("Admin", "admin123");
        WaitUtils.waitFor(2);

        //    Then verify the login is successful
        OrangeDashboardPage orangeDashboardPage = new OrangeDashboardPage(); // creating the page object
        Assert.assertTrue(orangeDashboardPage.profileLink.isDisplayed());
        WaitUtils.waitFor(2);


        //    And logout the application
        orangeDashboardPage.profileLink.click();
        orangeDashboardPage.logoutButton.click();
        WaitUtils.waitFor(2);

        //    Then verify the logout is successful
        Assert.assertTrue(orangeLoginPage.userName.isDisplayed());
        WaitUtils.waitFor(2);

//        NOTE: WE DON'T GET StaleElementReferenceException IN PAGE OBJECT MODEL

        // Close the driver
        Driver1.closeDriver();

    }

}
