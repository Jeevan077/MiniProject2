package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.LoginPage;
import utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

public class LoginTest extends ProjectSpecificationMethod{
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterEmail("jeevanreddafoxx@gmail.com");
        loginPage.enterPassword("Jeevan@05");
        loginPage.clickLogin();
        // Verify if user is redirected to the Contact List page
        Assert.assertTrue(driver.getCurrentUrl().contains("contact-list"), "Should redirect to the Contact List page.");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.enterEmail("jeev@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLogin();
        // Assert that login fails and stays on the login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Should stay on the Login page.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        if (driver != null) {
            Utility.captureScreenshot(driver, "LoginPageTest");
            driver.quit();
        }
    }
}
