package seleniumBooking.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import seleniumBooking.helper.PassengerInfoBuilder;
import seleniumBooking.pages.MMTFlightListingPage;
import seleniumBooking.pages.MMTHomePage;
import seleniumBooking.pages.MMTPaymentPage;
import seleniumBooking.pages.MMTSelectedFlightDetailsPage;
import seleniumBooking.utils.Months;
import seleniumBooking.utils.PassengerDetails;
import seleniumBooking.utils.SitClass;

import java.security.SecureRandom;

public class BookingEndToEnd extends AbstractUI {
    private static final Logger LOG = LoggerFactory.getLogger(BookingEndToEnd.class);
    private static final String FROM_ROUND = "Singapore";
    private static final String TO_ROUND = "Seoul";
    private static final String BOOKING_EMAIL = "xyz@yahoo.com";

    private MMTHomePage homePage;
    private MMTFlightListingPage flightListingPage;
    private MMTSelectedFlightDetailsPage selectedFlightDetailsPage;
    private MMTPaymentPage paymentPage;

    @BeforeClass
    public void preparePage() {
        this.homePage = this.bookingPageFactory.getMMTHomePage();
        this.flightListingPage = this.bookingPageFactory.getMMTFlightListingPage();
        this.selectedFlightDetailsPage = this.bookingPageFactory.getMMTSelectedFlightDetailsPage();
        this.paymentPage = this.bookingPageFactory.getMMTPaymentPage();
    }


    @Test(description = "book a ticket till the credit card page!!")
    public void bookTicketForRoundTrip() {
        LOG.info("SELECT ROUND TRIP AS THE TYPE OF BOOKING");
        this.homePage.selectRoundTrip();

        LOG.info("ENTER FROM AND TO");
        this.homePage.enterFrom(FROM_ROUND);
        this.homePage.enterTo(TO_ROUND);

        LOG.info("ENTER DEPART AND RETURN DATE");
//        this.homePage.selectDepartDate(12, Months.APRIL);
//        this.homePage.selectReturnDate();

        LOG.info("ENTER PASSENGERS");
        this.homePage.enterPassengers(2, 0, 1, SitClass.ECONOMY);

        LOG.info("HIT SEARCH!!");
        this.homePage.search();

        LOG.info("SELECT THE RECOMMENDED FLIGHT / FIRST FLIGHT FROM THE LIST");
        this.flightListingPage.bookRecommendedFlight();

        LOG.info("ENTER DETAILS FOR BOOKING");
        this.selectedFlightDetailsPage.enterEmail(BOOKING_EMAIL);
        this.selectedFlightDetailsPage.selectContinueAsGuest();

        LOG.info("BUILD ADULT 1");
        PassengerInfoBuilder infoBuilder = new PassengerInfoBuilder();
        final String firstName = RandomStringGenerator
        final PassengerDetails passenger1 = infoBuilder.buildPassengerInfo()


        LOG.info("BUILD ADULT 2");

        LOG.info("BUILD INFANT");

        LOG.info("ENTER PASSENGER DETAILS");
        this.paymentPage.enterPassengerDetails();


    }
}
