package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod{
    WebDriver driver;

    @FindBy(id = "signup") 
    WebElement signUpButton;
    
    @FindBy(id = "firstName")
    private WebElement firstname;
    
    @FindBy(id = "lastName")
    private WebElement lastname;
    
    @FindBy(id = "email")
    private WebElement email;
    
    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id="submit")
    private WebElement submit;
    
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void signup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();
    }

    public void entersignupdetails(String Firstname, String Lastname, String Email, String Password) {
    	firstname.sendKeys(Firstname);
    	lastname.sendKeys(Lastname);
    	email.sendKeys(Email);
    	password.sendKeys(Password);
    }
    
    public void clicksubmit()
    {
    	submit.click();
    }

}
