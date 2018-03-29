package seleniumBooking.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumBooking.drivers.Driver;

public class PageElementUtil {
    private Driver browserDriver;
    private WebDriverWait webDriverWait;

    public PageElementUtil(final Driver browserDriver) {
        this.browserDriver = browserDriver;
        this.webDriverWait = this.browserDriver.getWebDriverWait();
    }

    public WebElement findElement(final By by) {
        return this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
