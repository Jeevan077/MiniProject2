package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod{
    WebDriver driver;

    @FindBy(id = "signup")
    private WebElement signUpButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSignUpButtonVisible() {
        return signUpButton.isDisplayed();
    }
    
    public void clickSignUp() {
        signUpButton.click();
    }

}
