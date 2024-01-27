package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

public class BlueRental_LoginRequired {
    /*
     HW:  Require user to login for reservation
     Given user is on the login page
     And tries to book a car
     And click continue reservation
     Then user see the warning message: Please first login
     */

    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();


    @Test
    public void loginRequiredTest() {

        //    Given user is on the login page

        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

        //  And tries to book a car
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.selectDropDown,1);
        BrowserUtils.dropdownSelectByVisibleText(blueRentalHomePage.selectDropDown, "Ferrari");
        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.pickUpLocation,"Texas Victoria", 2);
        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.dropDownLocation,"Texas Sweetwater", 2);

        WaitUtils.waitFor(2);
        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.pickUpDate, "25/01/2024", 2 );
        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.pickUpTime, "10:00", 2 );


        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.dropOffDate, "25/01/2024", 2 );
        BrowserUtils.sendKeysWithTimeout(blueRentalHomePage.dropOffTime, "22:00", 2 );

        // And click continue reservation
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.submitButton,2);

        // Then user see the warning message: Please first login
        BrowserUtils.verifyExpectedAndActualTextMatch("Please first login",blueRentalHomePage.alertMessage); // OR
        BrowserUtils.verifyExpectedAndActualTextMatch("Please first login",blueRentalHomePage.loginFirst);

        Driver.closeDriver();
    }


}
