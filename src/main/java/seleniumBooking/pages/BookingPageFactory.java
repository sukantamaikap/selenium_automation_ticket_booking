package seleniumBooking.pages;

import seleniumBooking.drivers.Driver;

public class BookingPageFactory {
    private Driver browserDriver;

    public BookingPageFactory(final Driver browserDriver) {
        this.browserDriver = browserDriver;
    }

    public MMTHomePage getMMTHomePage() {
        return new MMTHomePage(this.browserDriver);
    }
}
