package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.SignUpPage;
import utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;

public class SignUpTest extends ProjectSpecificationMethod{
    WebDriver driver;
    SignUpPage signUpPage;

    
    	@BeforeMethod
    	@Parameters("url")
    	public void launchingBrowserandLoadingURL(@Optional("https://thinking-tester-contact-list.herokuapp.com/") String url) {
    	    driver = new ChromeDriver();
    	    driver.manage().window().maximize();
    	    driver.get(url);
    	    
    	    // Navigate to Sign Up Page
    	    HomePage homePage = new HomePage(driver);
    	    homePage.clickSignUp();

    	    // Initialize SignUpPage
    	    signUpPage = new SignUpPage(driver); 
    	}

    @Test
    public void testValidSignUp() {
        signUpPage.signup();
        signUpPage.entersignupdetails("Jeevan", "Sanjay", "jeevanreddafoxx@gmail.com", "Jeevan@05");
        signUpPage.clicksubmit();
        // Assert redirection to Contact List page or a success message
       // Assert.assertTrue(driver.getCurrentUrl().contains("contact-list"), "Should redirect to Contact List page.");
        
    }

    /*
    @Test
    public void testInvalidSignUp() {
        signUpPage.enterEmail("jeev@gmail");
        signUpPage.enterPassword("123");
        signUpPage.clickSubmit();
        // Assert error message or page stay on sign-up
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "Should stay on Sign Up page.");
    }

    public void tearDown() throws IOException {
        if (driver != null) {
            Utility.captureScreenshot(driver, "SignUpPageTest");
            driver.quit();
        }
    }
    */
}
