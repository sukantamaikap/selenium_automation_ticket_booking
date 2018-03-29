package seleniumBooking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Driver for Firefox.
 */
public class FirefoxDriver implements Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public FirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.10.0-win64\\geckodriver.exe");
        this.webDriver = new org.openqa.selenium.firefox.FirefoxDriver();
        this.webDriverWait = new WebDriverWait(this.webDriver, WEB_DRIVER_WAIT);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    public void quitDriver() {
        this.webDriver.quit();
    }
}
