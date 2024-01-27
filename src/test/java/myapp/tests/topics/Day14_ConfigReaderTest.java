package myapp.tests.topics;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_ConfigReaderTest {
    @Test
    public void configReaderTest(){
//        driver.get("https://www.google.com");
//        driver => Driver.getDriver();
//        "https://www.amazon.com"  =>  ConfigReader.getProperty(amazon_url)
//        Driver.getDriver().get("https://www.amazon.com");
        Driver1.getDriver().get(ConfigReader.getProperty("amazon_url"));

//        get the page title
        String title = Driver1.getDriver().getTitle();
        System.out.println("title = " + title);

//        Assert.assertTrue(title.contains("Amazon"));
        Assert.assertTrue(title.contains(ConfigReader.getProperty("amazon_title")));

//        closing driver
        Driver1.closeDriver();
    }
}
