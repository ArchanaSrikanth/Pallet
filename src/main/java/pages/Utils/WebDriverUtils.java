package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Utility class for WebDriver setup and teardown.
 */
public class WebDriverUtils {

    /**
     * Initializes and returns a Chrome WebDriver instance.
     * @return WebDriver instance.
     */
    public static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Add any ChromeOptions if needed, e.g., headless mode
        // options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    /**
     * Tears down the WebDriver instance by quitting the browser.
     * @param driver The WebDriver instance to quit.
     */
    public static void tearDown(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
