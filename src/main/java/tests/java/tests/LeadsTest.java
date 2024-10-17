package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LeadsPage;
import pages.LoginPage;
import utils.WebDriverUtils;

/**
 * TestNG Test Class for Zoho CRM Leads Module.
 */
public class LeadsTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LeadsPage leadsPage;

    // Credentials (Use environment variables or a secure method to handle credentials)
    private final String USERNAME = "your-username"; // Replace with actual username
    private final String PASSWORD = "your-password"; // Replace with actual password

    @BeforeMethod
    public void setUp() {
        driver = WebDriverUtils.initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zoho.com/crm/"); // Adjust URL if needed

        loginPage = new LoginPage(driver);
        leadsPage = new LeadsPage(driver);

        // Perform login
        loginPage.login(USERNAME, PASSWORD);
    }

    @Test(priority = 1, description = "Test creating a new lead")
    public void testCreateNewLead() {
        String leadName = "John Doe";
        leadsPage.navigateToLeads();
        leadsPage.createNewLead(leadName);
        
        // Verify the lead is created
        boolean isPresent = leadsPage.isLeadPresent(leadName);
        Assert.assertTrue(isPresent, "Lead should be present after creation.");
    }

    @Test(priority = 2, description = "Test editing an existing lead")
    public void testEditLead() {
        String originalLeadName = "John Doe";
        String updatedLeadName = "John Doe Updated";
        leadsPage.navigateToLeads();

        // Ensure the lead exists before editing
        Assert.assertTrue(leadsPage.isLeadPresent(originalLeadName), "Original lead should exist before editing.");

        leadsPage.editLead(originalLeadName, updatedLeadName);

        // Verify the lead has been updated
        boolean isUpdatedPresent = leadsPage.isLeadPresent(updatedLeadName);
        Assert.assertTrue(isUpdatedPresent, "Lead should be present with updated name.");
    }

    @Test(priority = 3, description = "Test filtering leads")
    public void testFilterLeads() {
        String filterCriteria = "John"; // Adjust based on actual filter functionality
        leadsPage.navigateToLeads();
        leadsPage.filterLeads(filterCriteria);

        // Verification can be enhanced based on how filtering displays results
        // For simplicity, assuming that at least one lead is present after filtering
        Assert.assertTrue(leadsPage.isLeadPresent("John Doe Updated"), "Filtered lead should be present.");
    }

    @Test(priority = 4, description = "Test deleting a lead")
    public void testDeleteLead() {
        String leadNameToDelete = "John Doe Updated";
        leadsPage.navigateToLeads();

        // Ensure the lead exists before deletion
        Assert.assertTrue(leadsPage.isLeadPresent(leadNameToDelete), "Lead should exist before deletion.");

        leadsPage.deleteLead(leadNameToDelete);

        // Verify the lead has been deleted
        boolean isDeleted = !leadsPage.isLeadPresent(leadNameToDelete);
        Assert.assertTrue(isDeleted, "Lead should not be present after deletion.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverUtils.tearDown(driver);
    }
}
