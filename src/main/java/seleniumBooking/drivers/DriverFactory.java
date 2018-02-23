package seleniumBooking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import seleniumBooking.utils.ConfigUtil;

import java.io.IOException;

/**
 * DriverFactory for selenium drivers
 */
public final class DriverFactory {
    private Driver driver;
    private WebDriver webDriver;
    private DriverFactory driverFactory;

    private DriverFactory() {
        try {
            if (ConfigUtil.getBrowser().equalsIgnoreCase("firefox")) {
                this.driver = new FirefoxDriver();
            } else if (ConfigUtil.getBrowser().equalsIgnoreCase("chrome")) {
                this.driver = new ChromeDriver();
            } else {
                Assert.fail("Unknown browser option, please check config.properties");
            }
        } catch (IOException e) {
            Assert.fail("Properties file does not exist!!");
        }
    }

    /**
     * Get the interface {@link Driver}, the common interface for all browser driver.
     * @return {@link Driver} interface
     */
    public Driver getDriver() {
        return this.driver;
    }

    /**
     *
     * @return instance of {@link WebDriver} for the chosen browser.
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * Factory - supposed to be singleton.
     * @return instance of {@link DriverFactory}
     */
    public DriverFactory getInstance() {
        if (this.driverFactory == null) {
            return new DriverFactory();
        }
        return this.driverFactory;
    }
}
