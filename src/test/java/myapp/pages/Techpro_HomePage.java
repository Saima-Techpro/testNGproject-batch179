package myapp.pages;

import myapp.utilities.Driver1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Techpro_HomePage {

    public Techpro_HomePage(){
        PageFactory.initElements(Driver1.getDriver(),this);
    }

    @FindBy (xpath = "//div[@role='alert']")
    public WebElement successMessage;

    @FindBy(xpath = "//a//i")
    public WebElement logoutButton;


}
