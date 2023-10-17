package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalCar_HomePage {
    // 1. create constructor and initiate PageFactory
    // 2. Locate and store webElements

    public RentalCar_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginButton;
}
