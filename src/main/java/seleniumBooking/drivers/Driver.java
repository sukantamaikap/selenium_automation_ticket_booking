package seleniumBooking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Browser driver interface.
 */
public interface Driver {
    WebDriver getDriver();
    WebDriverWait getWebDriverWait();
    void quitDriver();
}
