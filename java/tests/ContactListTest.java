package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.ContactListPage;
import utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

public class ContactListTest extends ProjectSpecificationMethod {
    WebDriver driver;
    ContactListPage contactListPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/contact-list");
        contactListPage = new ContactListPage(driver);
    }

    @Test
    public void testLogoutButtonVisible() {
        Assert.assertTrue(contactListPage.isLogoutButtonVisible(), "Logout button should be visible.");
    }

    @Test
    public void testLogoutFunctionality() {
        contactListPage.clickLogout();
        // Assert that after logout the user is redirected to the homepage
        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Should redirect to the Home page.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        if (driver != null) {
            Utility.captureScreenshot(driver, "ContactListPageTest");
            driver.quit();
        }
    }
}
