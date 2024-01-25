package myapp.homeworks;

import myapp.pages.Techpro_HomePage;
import myapp.pages.Techpro_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
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
//        techproLoginPage.userName.sendKeys("techproed");
//        techproLoginPage.password.sendKeys("SuperSecretPassword");
//        OR

        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_username"));
        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_password"));
        techproLoginPage.submitButton.click();

//      Verify login is successful:
        techproHomePage = new Techpro_HomePage();
//        Assert.assertTrue(techproHomePage.successMessage.getText().contains("You logged into a secure area!")); // OR
        BrowserUtils.verifyExpectedAndActualTextMatch("You logged into a secure area!", techproHomePage.successMessage);

//      Logout
        BrowserUtils.clickWithTimeOut(techproHomePage.logoutButton, 1);

//      Verify logout is successful:
//        BrowserUtils.verifyElementDisplayed(techproLoginPage.loginPageHeader);  // OR
        BrowserUtils.verifyElementDisplayed(techproLoginPage.userName);

        Driver.closeDriver();
    }
}
