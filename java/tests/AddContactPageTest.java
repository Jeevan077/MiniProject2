package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AddContactPage;
import pages.ContactListPage;
import pages.LoginPage;
import utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

public class AddContactPageTest extends ProjectSpecificationMethod{
    WebDriver driver;
    AddContactPage addContactPage;
    ContactListPage contactListPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/contact-list");
        contactListPage = new ContactListPage(driver);
        contactListPage.clickAddContact(); // Navigate to Add Contact page
        addContactPage = new AddContactPage(driver);
    }

    @Test
    public void testAddValidContact() {
        addContactPage.enterFirstName("Jeevan");
        addContactPage.enterLastName("Sanjay");
        addContactPage.enterEmail("jeevanreddafoxx@gmail.com");
        addContactPage.enterPhone("9080810935");
        addContactPage.submitContact();
        // Assert that the contact is displayed in the contact list
        Assert.assertTrue(driver.getPageSource().contains("Jeevan Sanjay"), "Contact should be added and displayed.");
    }

    @Test
    public void testAddContactWithMissingFields() {
        addContactPage.enterFirstName("Jeevan");
        addContactPage.enterEmail("jeevanreddafoxx@gmail.com");
        addContactPage.submitContact();
        // Verify if the form allows adding incomplete contact (if allowed by the app)
        Assert.assertTrue(driver.getPageSource().contains("Jeevan Sanjay"), "Contact with missing fields should be allowed.");
    }

    @Test
    public void testAddDuplicateContact() {
        addContactPage.enterFirstName("Jeevan");
        addContactPage.enterLastName("Sanjay");
        addContactPage.enterEmail("jeevanreddafoxx@gmail.com");
        addContactPage.enterPhone("9080810935");
        addContactPage.submitContact();
        
        // Try adding the same contact again
        addContactPage.enterFirstName("Jeevan");
        addContactPage.enterLastName("Sanjay");
        addContactPage.enterEmail("jeevanreddafoxx@gmail.com");
        addContactPage.enterPhone("9080810935");
        addContactPage.submitContact();
        
        // Assert if the app prevents duplicates (you may need to check an error message)
        Assert.assertTrue(driver.getPageSource().contains("Error: Duplicate contact"), "Duplicate contact should not be allowed.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        if (driver != null) {
            Utility.captureScreenshot(driver, "AddContactPageTest");
            driver.quit();
        }
    }
}
