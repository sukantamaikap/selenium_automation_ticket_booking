package seleniumBooking.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seleniumBooking.drivers.Driver;

public class MMTPaymentPage extends AbstractPage {

    private static final Logger LOG = LoggerFactory.getLogger(MMTPaymentPage.class);

    private final String PASSENGER_DETAILS_XPATH = "//div[@id=travellerId%s]";

    public MMTPaymentPage(Driver browserDriver) {
        super(browserDriver);
    }

    public void enterAdultPassengerDetails(final int index) {

    }
}
