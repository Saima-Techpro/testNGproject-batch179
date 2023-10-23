package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 We can link test methods to Listeners in 2 ways:
1. we can use @Listeners annotation to implement Listeners
2. <Listeners> in xml file - RECOMMENDED WAY
 */

@Listeners(myapp.utilities.ListenerUtils.class)
public class Day18_ListenersTest {
    @Test
    public void test1(){
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2() {
        System.out.println("FAILS");
        Assert.assertTrue(false);
    }
    //        takes empty screenshot cox no UI is invoked at this point
    @Test
    public void test3(){
        System.out.println("SKIPPED");
        throw new SkipException("Skipping test case on purpose");
    }
    @Test
    public void test4(){
        System.out.println("THROW ");
//        throw new NoSuchElementException("No Such Exception on Purpose");
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().findElement(By.id("wrong-id"));//throw NoSuchElementException
    }

}
