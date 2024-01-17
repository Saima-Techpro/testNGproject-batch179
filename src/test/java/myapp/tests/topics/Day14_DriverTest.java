package myapp.tests.topics;

import myapp.utilities.Driver1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_DriverTest {
    @Test
    public void driverTest() throws InterruptedException {
//        in JUnit, we called driver like this:
//        driver.get("https://www.google.com");
//        driver => Driver.getDriver();

        Driver1.getDriver().get("https://www.amazon.com");
        Thread.sleep(2000);
        Driver1.getDriver().navigate().refresh();
//        get the page title
        String title = Driver1.getDriver().getTitle();
        Assert.assertTrue(title.contains("Amazon"));
//        closing driver
        Driver1.closeDriver();


//        WITH more DYNAMIC DRIVER CLASS
//        Driver.getDriver().get("https://www.amazon.com");
////        get the page title
//        String title = Driver.getDriver().getTitle();
//        Assert.assertTrue(title.contains("Amazon"));
////        closing driver
//        Driver.closeDriver();
    }
}
