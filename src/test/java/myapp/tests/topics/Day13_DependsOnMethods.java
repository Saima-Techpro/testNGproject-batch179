package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day13_DependsOnMethods {
    @Test
    public void homePageTest(){
        System.out.println("home page");
    }
    @Test (dependsOnMethods = "homePageTest")
    public void searchTest(){
        System.out.println("search test");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "searchTest")//checkout is dependent on search. If search is successful, checkoutTest will run
    public void checkOutTest(){
        System.out.println("checkout test");
    }
}
