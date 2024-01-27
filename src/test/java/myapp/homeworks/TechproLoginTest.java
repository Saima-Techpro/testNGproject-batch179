package myapp.homeworks;

import myapp.pages.Techpro_HomePage;
import myapp.pages.Techpro_LoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

public class TechproLoginTest {

    Techpro_LoginPage techproLoginPage = new Techpro_LoginPage();
    Techpro_HomePage techproHomePage = new Techpro_HomePage();

    @Test
    public void loginTest(){
//      Go to Login page:
        Driver.getDriver().get(ConfigReader.getProperty("techpro_url"));

//      Enter username and password:
        techproLoginPage = new Techpro_LoginPage();
        techproLoginPage.userName.sendKeys("techproed");
        WaitUtils.waitFor(2);
        techproLoginPage.password.sendKeys("SuperSecretPassword");
        WaitUtils.waitFor(2);
//        OR

//        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_username"));
//        WaitUtils.waitFor(1);
//        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_password"));
//        WaitUtils.waitFor(1);
        techproLoginPage.submitButton.click();

//      Verify login is successful:
        techproHomePage = new Techpro_HomePage();
//        Assert.assertTrue(techproHomePage.successMessage.getText().contains("You logged into a secure area!")); // OR
        BrowserUtils.verifyExpectedAndActualTextMatch("You logged into a secure area!", techproHomePage.successMessage);
        WaitUtils.waitFor(2);
//      Logout
        BrowserUtils.clickWithTimeOut(techproHomePage.logoutButton, 1);

//      Verify logout is successful:
//        BrowserUtils.verifyElementDisplayed(techproLoginPage.loginPageHeader);  // OR
        BrowserUtils.verifyElementDisplayed(techproLoginPage.userName);
        WaitUtils.waitFor(2);

        Driver.closeDriver();
    }
}
