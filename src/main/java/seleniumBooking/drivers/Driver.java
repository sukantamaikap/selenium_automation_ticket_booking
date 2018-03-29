package seleniumBooking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Browser driver interface.
 */
public interface Driver {
    static final int WEB_DRIVER_WAIT = 30;
    WebDriver getWebDriver();
    WebDriverWait getWebDriverWait();
    void quitDriver();
}
