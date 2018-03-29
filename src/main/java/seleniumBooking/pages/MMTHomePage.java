package seleniumBooking.pages;

import org.omg.CORBA.FREE_MEM;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seleniumBooking.drivers.Driver;

public class MMTHomePage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(MMTHomePage.class);

    public MMTHomePage(final Driver browserDriver) {
        super(browserDriver);
    }

    /**
     * Enter "from" in the home page
     * @param from
     */
    public void enterFrom(final String from) {
        LOG.info("FROM TO BE SELECTED AS : ", from);
        this.getElementUtil().findElement(By.xpath(""));

    }
}
