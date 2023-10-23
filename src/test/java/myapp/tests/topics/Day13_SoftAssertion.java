package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day13_SoftAssertion {
    @Test
    public void hardAssert(){
        /*
        TestNG
        Hard Assertion : if an assertion fails, then test case STOPS executing
        Assert class is used for hard assertion in TestNG
        Hard assertion is more common than soft assert
         */
        System.out.println("line 14");//prints
        Assert.assertTrue(true);//PASS so continues
        System.out.println("line 17");//prints
        Assert.assertTrue(false);//FAILS so does not run rest of the test case
        System.out.println("line 19");// doesn't print
    }
    @Test
    public void javaAssert(){
        /*
        Java
        this is also hard assertion but this comes from java
        if this assertion fails, then test case STOPS executing
        Note: We prefer testNG assertion instead of java assertion
        if assert fails, then it throws java.lang.AssertionError
         */
        System.out.println("line 30");//prints
        assert 3<5;//PASS
        System.out.println("line 32");//prints
        assert "apple"=="apple";//PASS
        System.out.println("line 34");//prints
        assert "Apple".toLowerCase().contains("a");//PASS
        System.out.println("line 36");//prints
        assert "java".equals("selenium");//FAILS so does not run rest of the test case.
        //this type of Java assertion works like if-else statement => if("java".equals("selenium")){PASS}else{throw java.lang.AssertionError}
        System.out.println("line 38");// doesn't print
    }
    @Test
    public void softAssert(){
        /* Soft assertion: if a soft assertion fails, test continues to execute
        STEPS:
        1. create soft assert object
        2. use the soft assert for assertions
        3. use assertAll() to get the result

         */
        System.out.println("Line 50");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5, 5); // PASS so test continues
        System.out.println("Line 54"); // prints
        softAssert.assertTrue(false); // FAILS but test still continues
        System.out.println("line 56");
        softAssert.assertEquals("apple","orange"); // FAILS but test still continues
        System.out.println("line 58");
        softAssert.assertAll("Test case complete!!");
    }
}
