package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class BlueRental_LoginWithExcel {

//    HW:
//    Test the log in functionality of the application with different user profiles (admin, manager, customer services, end user)
//    Test Data URL : https://www.bluerentalcars.com/
//    User Credentials : Excel Sheet

    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage =new BlueRental_LoginPage();
    String pathOfExcel="./resources/data_sheet.xlsx";

    String sheetName = "admin_credentials";


    @Test
    public void loginWithExcelTest(){

        ExcelUtils excelUtils=new ExcelUtils(pathOfExcel, sheetName);


        List<Map<String,String>> listOfData =excelUtils.getDataList();
        System.out.println("listOfData = " + listOfData);

        Map<String,String> data1 = listOfData.get(0);
        System.out.println("data1 = " + data1);

        String lastData1 = data1.get("password").replaceAll("[.0]","");
        System.out.println("lastData1 = " + lastData1);

        String lastData2 = data1.get("username");
        System.out.println("lastData2 = " + lastData2);

        Driver.getDriver().get("https://www.bluerentalcars.com/");

        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 1);

        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email,lastData2,1);

        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password,lastData1,1);

        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        Assert.assertEquals(blueRentalLoginPage.dropDown.getText(), "Jack Nickolson");

        Driver.closeDriver();
    }


    // WITH DATAPROVIDER
    @Test (dataProvider = "adminData", dataProviderClass = DataProviderUtils.class)
    public void loginWithDataProvider(String email, String password){

        Driver.getDriver().get("https://www.bluerentalcars.com/");

        blueRentalHomePage.userIcon.click();

        blueRentalLoginPage.email.sendKeys(email);

        String newPassword = password.substring(0,5);
        blueRentalLoginPage.password.sendKeys(newPassword);

        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,2);

        BrowserUtils.verifyElementDisplayed(blueRentalHomePage.userIcon);

        Driver.closeDriver();
    }

}
