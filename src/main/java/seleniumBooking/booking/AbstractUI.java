package seleniumBooking.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import seleniumBooking.drivers.DriverFactory;
import seleniumBooking.pages.BookingPageFactory;
import seleniumBooking.utils.ConfigUtil;

import java.io.IOException;

/**
 * Base class for booking using selenium and testNG
 */
public class AbstractUI {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractUI.class);

    protected DriverFactory driverFactory;
    protected BookingPageFactory bookingPageFactory;

    /**
     * Start browser and prepare environment
     */
    @BeforeTest
    public void prepEnvironment() throws IOException {
        if (this.driverFactory != null) {
            LOG.info("WE NEED TO CLOSE ANY DORMANT BROWSER SESSION");
            this.driverFactory.getDriver().quitDriver();
            this.driverFactory = null;
        }

        LOG.info("START A NEW DRIVER SESSION");
        this.driverFactory = DriverFactory.getInstance();

        LOG.info("INIT PAGE");
        this.bookingPageFactory = new BookingPageFactory(this.driverFactory.getDriver());

        LOG.info("MAXIMIZE WINDOW");
        this.driverFactory.getDriver().getWebDriver().manage().window().maximize();


        this.driverFactory.getDriver().getWebDriver().navigate().to(ConfigUtil.getBaseUrl());
    }

    @AfterTest
    public void shutDown() throws Exception {
        this.driverFactory.getDriver().quitDriver();
    }
}
