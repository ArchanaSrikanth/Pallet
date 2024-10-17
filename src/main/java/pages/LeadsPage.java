package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for the Zoho CRM Leads Module.
 */
public class LeadsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By newLeadButton = By.xpath("//button[text()='New Lead']");
    private By leadNameField = By.name("Last Name"); // Adjust based on actual locator
    private By saveButton = By.xpath("//button[text()='Save']");
    private By filterField = By.xpath("//input[@placeholder='Filter']");
    private By deleteLeadButton = By.xpath("//button[text()='Delete']");
    private By confirmationDeleteButton = By.xpath("//button[text()='Confirm']"); // Adjust as per actual locator

    // Constructor
    public LeadsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // 20 seconds timeout
    }

    // Methods to interact with the Leads Page

    /**
     * Navigates to the Leads module.
     */
    public void navigateToLeads() {
        By leadsTab = By.xpath("//a[@href='/crm/org123456789/tab/Leads']"); // Adjust href as per actual URL
        wait.until(ExpectedConditions.elementToBeClickable(leadsTab)).click();
    }

    /**
     * Creates a new lead with the provided name.
     * @param leadName The name of the lead to be created.
     */
    public void createNewLead(String leadName) {
        wait.until(ExpectedConditions.elementToBeClickable(newLeadButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(leadNameField)).sendKeys(leadName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    /**
     * Edits an existing lead with the provided name.
     * @param existingLeadName The name of the lead to be edited.
     * @param newLeadName The new name to update the lead.
     */
    public void editLead(String existingLeadName, String newLeadName) {
        By leadToEdit = By.xpath("//span[text()='" + existingLeadName + "']/ancestor::tr//button[@title='Edit']");
        wait.until(ExpectedConditions.elementToBeClickable(leadToEdit)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(leadNameField)).clear();
        driver.findElement(leadNameField).sendKeys(newLeadName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    /**
     * Filters leads based on the provided criteria.
     * @param filterCriteria The criteria to filter leads.
     */
    public void filterLeads(String filterCriteria) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterField)).clear();
        driver.findElement(filterField).sendKeys(filterCriteria);
        driver.findElement(filterField).submit(); // Assuming Enter submits the filter
    }

    /**
     * Deletes a lead with the specified name.
     * @param leadName The name of the lead to delete.
     */
    public void deleteLead(String leadName) {
        By leadToDelete = By.xpath("//span[text()='" + leadName + "']/ancestor::tr//button[@title='Delete']");
        wait.until(ExpectedConditions.elementToBeClickable(leadToDelete)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmationDeleteButton)).click();
    }

    /**
     * Verifies if a lead exists in the Leads list.
     * @param leadName The name of the lead to verify.
     * @return true if lead exists, false otherwise.
     */
    public boolean isLeadPresent(String leadName) {
        try {
            By leadLocator = By.xpath("//span[text()='" + leadName + "']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(leadLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
