package myapp.tests.dataprovider;

import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day16_DataProvider1 {
    // Data Provider Method
    @DataProvider
    public Object[][] productListProvider() {
        Object productList[][] = {{"tesla"}, {"toyota"}, {"bmw"}, {"volvo"}, {"honda"}};
        return productList;
    }

    // Test Method 1
    @Test(dataProvider = "productListProvider" )
    public void test(String eachData){
        System.out.println(eachData);
    }

    // Data Provider Method 2
    @DataProvider (name = "manager_credentials")
    public Object[][] credentialsProvider(){
        Object credentials[][] = {
                {"admin1", "pass1", "CEO", "56"},
                {"admin2","pass2", "QA","34"},
                {"admin3","pass3", "PM","45"}
        };
        return credentials;
    }
//    // Test Method 2
//    @Test(dataProvider = "credentialsProvider" ) // connecting with method name which has @DataProvider annotation
//    public void test2(String userName, String password, String title, String age){
//        System.out.println("Username: "+userName+ ", Password: "+password+ ", Title: "+title+ ", Age: "+age);
//
//    }

    // Test Method 2
    @Test(dataProvider = "manager_credentials" ) // connecting with custom name used for the DataProvider method
    public void test2(String userName, String password, String title, String age){
        System.out.println("Username: "+userName+ ", Password: "+password+ ", Title: "+title+ ", Age: "+age);

    }

    // NOTE: We can store DataProvider methods in UTILS class
    // If the data is coming form another class, we need to provide the address/name of the class as well
    // Get the data from excel data provider stored in Utils Class
    // FLow of the data => excel -> data provider method -> test method
    // Test Method 3
    @Test(dataProvider = "employeeCredentialsProvider", dataProviderClass = DataProviderUtils.class)
    public void test3(String email, String password){
        System.out.println("Email: "+email + " | Password: "+ password);
    }


}
