package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver);
    }

    @Test
    public void testSignUpButtonVisible() {
        Assert.assertTrue(homePage.isSignUpButtonVisible(), "Sign up button should be visible.");
    }

    @Test
    public void testSignUpButtonClick() {
        homePage.clickSignUp();
        // Verify if the page redirects to the Sign Up page (check for an element on that page)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/signup"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "The page should redirect to the SignUp Page.");
    }
    }
/*
    @Test
    public void testLoginButtonVisible() {
        Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button should be visible.");
    }

    @Test
    public void testLoginButtonClick() {
        homePage.clickLogin();
        // Verify if the page redirects to the Login page (check for an element on that page)
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "The page should redirect to the Login Page.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        if (driver != null) {
            Utility.captureScreenshot(driver, "HomePageTest");
            driver.quit();
        }
    }
    */

