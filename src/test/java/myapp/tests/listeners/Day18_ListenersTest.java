package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 We can link test methods to Listeners in 2 ways:
1. we can use @Listeners annotation to implement Listeners within the class => @Listeners(myapp.utilities.ListenerUtils.class)
2. <Listeners> in xml file - RECOMMENDED WAY
 */

//@Listeners(myapp.utilities.ListenerUtils.class)
// instead of above annotation, run from xml file - RECOMMENDED
public class Day18_ListenersTest {
    @Test
    public void test1(){
        Driver.getDriver().get("https://techproeducation.com/");
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("TechPro Education IT Programs")); // pass
    }
    @Test
    public void test2() {
        Driver.getDriver().get("https://amazon.com/");
        Driver.getDriver().navigate().refresh();
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("amazon"));  // fails
    }
    //        takes empty screenshot cox no UI is invoked at this point
    @Test
    public void test3(){
        System.out.println("SKIPPED");
        throw new SkipException("Skipping test case on purpose");
    }
    @Test
    public void test4(){
        System.out.println("THROW NoSuchElementException");
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().findElement(By.id("wrong-id"));//throw NoSuchElementException
//        throw new NoSuchElementException("No Such Exception on Purpose");
    }

}
