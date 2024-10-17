package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for the Zoho CRM Login Page.
 */
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameField = By.id("login_id");
    private By passwordField = By.id("password");
    private By loginButton = By.id("nextbtn");
    private By submitButton = By.id("signup_url"); // Adjust based on actual locator

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // 20 seconds timeout
    }

    // Methods to interact with the Login Page

    /**
     * Enters the username into the username field.
     * @param username The user's username or email.
     */
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    /**
     * Enters the password into the password field.
     * @param password The user's password.
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    /**
     * Clicks the login button to proceed.
     */
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    /**
     * Complete login process with username and password.
     * @param username User's username or email.
     * @param password User's password.
     */
    public void login(String username, String password) {
        enterUsername(username);
        clickLogin();
        // Wait for password field to appear if login is a two-step process
        enterPassword(password);
        clickSubmit();
    }

    /**
     * Clicks the submit button after entering password.
     */
    private void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
