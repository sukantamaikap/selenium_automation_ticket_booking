package seleniumBooking.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class BookingEndToEnd extends AbstractUI {
    private static final Logger LOG = LoggerFactory.getLogger(BookingEndToEnd.class);
    private static final String FROM_ROUND = "Bangalore";
    private static final String TO_ROUND = "Seoul";


    @Test(description = "book a ticket till the credit card page!!")
    public void bookTicketForRoundTrip() {
        LOG.info("SELECT ROUND TRIP AS THE TYPE OF BOOKING");


        LOG.info("ENTER FROM AND TO !!");

    }
}
