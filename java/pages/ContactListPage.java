package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class ContactListPage extends ProjectSpecificationMethod{
    WebDriver driver;

    @FindBy(id = "add-contact")
    private WebElement addContactButton;

    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddContact() {
        addContactButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public boolean isLogoutButtonVisible() {
        return logoutButton.isDisplayed();
    }
}
