package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day13_SoftAssertion {
    @Test
    public void hardAssert(){
        /*
        In JUnit, we had only Hard Assertion.
        Hard Assertion : if an assertion fails, then test case STOPS executing.
        TestNG has two types of assertions: HARD and SOFT Assertion.
        Difference: Assert class is used for hard assertion in TestNG; Assertions class is used in JUnit
        *** Hard assertion is more common than soft assert ***
         */
        System.out.println("line 17");//prints
        Assert.assertTrue(true);//PASS so continues  => THIS IS TestNG ASSERTION
        System.out.println("line 19");//prints
        Assert.assertTrue(false);//FAILS so does not run rest of the test case
        System.out.println("line 21");// doesn't print
    }
    @Test
    public void javaAssert(){
        /*
        Java
        this is also hard assertion but this comes from JAVA
        if this assertion fails, then test case STOPS executing
        Note: We prefer testNG assertion instead of java assertion
        if assert fails, then it throws java.lang.AssertionError
         */
        System.out.println("line 32");//prints
        assert 3<5;//PASS
        System.out.println("line 34");//prints
        assert "apple"=="apple";//PASS
        System.out.println("line 36");//prints
        assert "Apple".toLowerCase().contains("a");//PASS
        System.out.println("line 38");//prints
        assert "java".equals("selenium");//FAILS so does not run rest of the test case.
        //this type of Java assertion works like if-else statement => if("java".equals("selenium")){PASS}else{throw java.lang.AssertionError}
        System.out.println("line 41");// doesn't print
    }
    @Test
    public void softAssert(){
        /*
        Soft assertion: if a soft assertion fails, test continues to execute
        STEPS:
        1. create soft assert object
        2. use the soft assert for assertions
        3. use assertAll() to get the result

         */
        System.out.println("Line 53");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5, 5); // PASS so test continues
        System.out.println("Line 56"); // prints
        softAssert.assertTrue(false); // FAILS but test still continues
        System.out.println("line 58");
        softAssert.assertEquals("apple","orange"); // FAILS but test still continues
        System.out.println("line 60");
        softAssert.assertAll("Test case complete!!");
        // if we don't use assertAll as last step, the test is marked as pass ..
        // which is wrong report about this test
    }
}
