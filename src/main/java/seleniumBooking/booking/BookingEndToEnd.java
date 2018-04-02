package seleniumBooking.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import seleniumBooking.pages.MMTHomePage;

public class BookingEndToEnd extends AbstractUI {
    private static final Logger LOG = LoggerFactory.getLogger(BookingEndToEnd.class);
    private static final String FROM_ROUND = "Singapore";
    private static final String TO_ROUND = "Seoul";
    private MMTHomePage homePage;

    @BeforeClass
    public void preparePage() {
        this.homePage = this.bookingPageFactory.getMMTHomePage();
    }


    @Test(description = "book a ticket till the credit card page!!")
    public void bookTicketForRoundTrip() {
        LOG.info("SELECT ROUND TRIP AS THE TYPE OF BOOKING");
        this.homePage.selectRoundTrip();

        LOG.info("ENTER FROM AND TO");
        this.homePage.enterFrom(FROM_ROUND);
        this.homePage.enterTo(TO_ROUND);

        LOG.info("ENTER DEPART AND RETURN DATE");
        this.homePage.selectDepartDate();
        this.homePage.selectReturnDate();

    }
}
