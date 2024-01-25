package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_HomePage {
    // 1. create constructor and initiate PageFactory
    // 2. Locate and store webElements

    public BlueRental_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (partialLinkText = "Login")
    public WebElement userIcon;

    @FindBy (xpath = "//select")
    public WebElement selectDropDown;
    @FindBy(xpath = "//div[2]/div/div/div[2]/form/select/option[2]")
    public WebElement selectCar;
    @FindBy(name = "pickUpLocation")
    public WebElement pickUpLocation;
    @FindBy(name = "dropOfLocation")
    public WebElement dropDownLocation;
    @FindBy (xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;
    @FindBy(xpath = "//input[@type='time']")
    public WebElement pickUpTime;
    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;
    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "//div[contains(text(),'login')]")
    public WebElement loginFirst;

}
