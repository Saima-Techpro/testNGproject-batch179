package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day16_ExcelLogin {
    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;  // to access ExcelUtils objects and methods

    List<Map<String, String>> dataList;  // this list container will hold the Excel data

    // WITHOUT EXCEL
    @Test
    public void excelTest(){
//        When user go to https://editor.datatables.net/
//        Driver.getDriver().get("https://editor.datatables.net/");
        Driver.getDriver().get(ConfigReader.getProperty("dataTables_url"));
//        Click on the new button
        dataTablesPage = new DataTablesPage(); // Creating the page object
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(1);
//        When user enters all fields
        dataTablesPage.firstName.sendKeys("john");
        WaitUtils.waitFor(1);
        dataTablesPage.lastName.sendKeys("lennon");
        WaitUtils.waitFor(1);
        dataTablesPage.position.sendKeys("musician");
        WaitUtils.waitFor(1);
        dataTablesPage.office.sendKeys("LA");
        WaitUtils.waitFor(1);
        dataTablesPage.extension.sendKeys("52345");
        WaitUtils.waitFor(1);
        dataTablesPage.startDate.sendKeys("2023-12-27");
        WaitUtils.waitFor(1);
        dataTablesPage.salary.sendKeys("1000000");
        WaitUtils.waitFor(1);
//        When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(1);
//        And search for the first name
        dataTablesPage.searchBox.sendKeys("john");
        WaitUtils.waitFor(1);
//        Then verify the name field contains first name
        Assert.assertTrue(dataTablesPage.nameField.getText().contains("john"));
        WaitUtils.waitFor(1);

        // Close the driver
        Driver.closeDriver();

    }

    // WITH EXCEL
    @Test
    public void excelTest2(){
//        path of the Excel sheet
        String pathOfExcel = "./resources/data_sheet.xlsx";
//        INSTANTIATE THE PAGE
        excelUtils = new ExcelUtils(pathOfExcel, "user_data" );

        // Call reusable method to get the data form the Excel sheet
        dataList = excelUtils.getDataList();
        System.out.println(dataList);  // to see the data sets

        // LOOP BEGINS
        for (Map<String, String> eachData : dataList ){  // eachData is a MAP
            //        When user go to https://editor.datatables.net/
//            Driver.getDriver().get("https://editor.datatables.net/");
            Driver.getDriver().get(ConfigReader.getProperty("dataTables_url"));
//        Click on the new button
            dataTablesPage = new DataTablesPage(); // Creating the page object
            dataTablesPage.newButton.click();
            WaitUtils.waitFor(1);
//        When user enters all fields
            dataTablesPage.firstName.sendKeys(eachData.get("first_name"));  // eachData is a MAP so we can use get()
            WaitUtils.waitFor(1);
            dataTablesPage.lastName.sendKeys(eachData.get("last_name"));
            WaitUtils.waitFor(1);
            dataTablesPage.position.sendKeys(eachData.get("position"));
            WaitUtils.waitFor(1);
            dataTablesPage.office.sendKeys(eachData.get("office"));
            WaitUtils.waitFor(1);
            dataTablesPage.extension.sendKeys(eachData.get("extension"));
            WaitUtils.waitFor(1);
            dataTablesPage.startDate.sendKeys(eachData.get("start_date"));
            WaitUtils.waitFor(1);
            dataTablesPage.salary.sendKeys(eachData.get("salary"));
            WaitUtils.waitFor(1);
//        When user clicks on ‘create’ button
            dataTablesPage.createButton.click();
            WaitUtils.waitFor(1);
//        And search for the first name
            dataTablesPage.searchBox.sendKeys(eachData.get("first_name"));
            WaitUtils.waitFor(1);
//        Then verify the name field contains first name
            Assert.assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));
            WaitUtils.waitFor(1);

            System.out.println(eachData);
        }

        // LOOP ENDS

        // Close the driver
        Driver.closeDriver();

    }

}
