package myapp.pages;

import myapp.utilities.Driver1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeDashboardPage {
    // 1. create constructor with PageFactory
    // 2. Locate and store webElements

    public OrangeDashboardPage(){
        PageFactory.initElements(Driver1.getDriver(), this);
    }

    @FindBy(className = "oxd-userdropdown-name")
    public WebElement profileLink;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;
}
