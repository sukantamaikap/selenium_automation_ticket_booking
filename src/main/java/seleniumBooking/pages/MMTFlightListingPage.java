package seleniumBooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import seleniumBooking.drivers.Driver;

import java.util.List;

public class MMTFlightListingPage extends AbstractPage {

    private static final Logger LOG = LoggerFactory.getLogger(MMTFlightListingPage.class);

    private static final String BOOK_RECOMANDED_XPATH = "//a[@id='bookButton']";

    public MMTFlightListingPage(final Driver browserDriver) {
        super(browserDriver);
    }

    public void bookRecommendedFlight() {
        LOG.info("BOOK THE RECOMMENDED FLIGHT");
        final List<WebElement> bookButtons = this.getElementUtil().findElements(By.xpath(BOOK_RECOMANDED_XPATH));

        if (bookButtons.size() == 0) {
            Assert.fail("No flight found for the specified parameters !!");
        }

        bookButtons.get(0).click();
    }
}
