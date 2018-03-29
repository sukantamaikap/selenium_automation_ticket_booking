package seleniumBooking.pages;

import seleniumBooking.drivers.Driver;
import seleniumBooking.utils.PageElementUtil;

public class AbstractPage {
    private Driver browserDriver;
    private PageElementUtil elementUtil;

    public AbstractPage(final Driver browserDriver) {
        this.browserDriver = browserDriver;
        this.elementUtil = new PageElementUtil(this.browserDriver);
    }

    public PageElementUtil getElementUtil() {
        return this.elementUtil;
    }
}
