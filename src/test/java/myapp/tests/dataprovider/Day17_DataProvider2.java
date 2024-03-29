package myapp.tests.dataprovider;

import myapp.pages.DataTablesPage;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;

import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_DataProvider2 {

    /*
    PLAN:
        1. create a data provider source in Utils that will take data from user_data sheet
        2. connect this test method to the data provider using  dataProvider and dataProviderClass
        3. complete your test case with the data that comes from the excel
        NOTE: try using existing code that might help. we will use userCreationWithExcel test method

         */
    DataTablesPage dataTablesPage;  // Create PAGE OBJECT

    @Test(dataProvider = "dataTablesData", dataProviderClass = DataProviderUtils.class)
    public void userCreatingWithDataProvider(
            String firstName,
            String lastName,
            String position,
            String office,
            String extension,
            String startDate,
            String salary
    ){

//        When user go to  https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");
//        Click on the new button
        WaitUtils.waitFor(1);
        dataTablesPage = new DataTablesPage();
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(1);
//        When user enters all fields
//        dataTablesPage.firstName.sendKeys(eachData.get("first_name"));
//        REPLACE eachData.get("first_name") WITH firstName coming as parameter
        dataTablesPage.firstName.sendKeys(firstName);

        WaitUtils.waitFor(1);
//        dataTablesPage.lastName.sendKeys(eachData.get("last_name"));
        dataTablesPage.lastName.sendKeys(lastName);
        WaitUtils.waitFor(1);
//        dataTablesPage.position.sendKeys(eachData.get("position"));
        dataTablesPage.position.sendKeys(position);
        WaitUtils.waitFor(1);
//        dataTablesPage.office.sendKeys(eachData.get("office"));
        dataTablesPage.office.sendKeys(office);
        WaitUtils.waitFor(1);
//        dataTablesPage.extension.sendKeys(eachData.get("extension"));
        dataTablesPage.extension.sendKeys(extension);
        WaitUtils.waitFor(1);
//        dataTablesPage.start_date.sendKeys(eachData.get("start_date"));
        dataTablesPage.startDate.sendKeys(startDate);
        WaitUtils.waitFor(1);
//        dataTablesPage.salary.sendKeys(eachData.get("salary"));
        dataTablesPage.salary.sendKeys(salary);
        WaitUtils.waitFor(1);
//        When clicks create button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(1);
//        And search for the first name
//        dataTablesPage.searchBox.sendKeys(eachData.get("first_name"));
        dataTablesPage.searchBox.sendKeys(firstName);
        WaitUtils.waitFor(1);
//        Then verify the name fields contains first name
//        Assert.assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));
        Assert.assertTrue(dataTablesPage.nameField.getText().contains(firstName));
        WaitUtils.waitFor(1);
//        Close driver
        Driver.closeDriver();
    }
}
