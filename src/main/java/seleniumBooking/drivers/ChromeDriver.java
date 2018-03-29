package seleniumBooking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Driver for Chrome.
 */
public class ChromeDriver implements Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public ChromeDriver() {
        System.setProperty("webdriver.chrome.driver","/usr/bin/google-chrome-stable");
        this.webDriver = new org.openqa.selenium.chrome.ChromeDriver();
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
