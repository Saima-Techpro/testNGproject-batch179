package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MedunnaRegisterPage {

    public MedunnaRegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//div[.='Your SSN is invalid']")
    public WebElement invalidSsn;

    @FindBy(xpath = "//div[.='Your SSN is required.']")
    public WebElement requiredSsn;

    @FindBy(id = "register-submit")
    public WebElement registerSubmit;

    @FindBy(xpath = "//div[.='Your FirstName is required.']")
    public WebElement requiredFirstName;

    @FindBy(xpath = "//div[.='Your LastName is required.']")
    public WebElement requiredLastName;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(xpath = "//div[.='Your username is required.']")
    public WebElement requiredUsername;

    @FindBy(xpath = "//div[.='Your username is invalid.']")
    public WebElement invalidUsername;




}