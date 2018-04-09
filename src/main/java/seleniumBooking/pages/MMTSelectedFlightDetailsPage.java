package seleniumBooking.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seleniumBooking.drivers.Driver;

public class MMTSelectedFlightDetailsPage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(MMTSelectedFlightDetailsPage.class);

    private static final String EMAIL_ID_FOR_LOGIN_XPATH = "//input[@id='inputEmailIdForLoggin']";
    private static final String GUEST_LINK_TEXT = "Continue as Guest";

    public MMTSelectedFlightDetailsPage(final Driver browserDriver) {
        super(browserDriver);
    }

    public void enterEmail(final String emailAddress) {
        this.getElementUtil().findElement(By.xpath(EMAIL_ID_FOR_LOGIN_XPATH)).sendKeys(emailAddress);
    }

    public void selectContinueAsGuest() {
        this.getElementUtil().findElement(By.linkText(GUEST_LINK_TEXT)).click();
    }
}
