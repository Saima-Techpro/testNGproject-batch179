package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlueRental_LoginWithDataProvider {

//    HW:
//    Test the log in functionality of the application with different user profiles (admin, manager, customer services, end user)
//    Test Data URL : https://www.bluerentalcars.com/
//    User Credentials : Excel Sheet

    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage =new BlueRental_LoginPage();


    // WITH DATAPROVIDER
    @Test (dataProvider = "adminData", dataProviderClass = DataProviderUtils.class)
    public void loginWithDataProvider(String email, String password){

        Driver.getDriver().get("https://www.bluerentalcars.com/");

        blueRentalHomePage.userIcon.click();

        blueRentalLoginPage.email.sendKeys(email);
        WaitUtils.waitFor(1);

        String newPassword = password.substring(0,5); // to remove decimal part that comes from excel data
        blueRentalLoginPage.password.sendKeys(newPassword);
        WaitUtils.waitFor(1);
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,2);
        WaitUtils.waitFor(1);
        Assert.assertEquals(blueRentalLoginPage.dropDown.getText(), "Jack Nickolson");

        Driver.closeDriver();
    }

}
