package seleniumBooking.pages;

import org.junit.Assert;
import org.omg.CORBA.FREE_MEM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seleniumBooking.drivers.Driver;

import java.util.List;

public class MMTHomePage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(MMTHomePage.class);
    // page element identifiers
    private static final String ONE_WAY_ID = "switch__input_1";
    private static final String ROUND_TRIP_ID = "switch__input_2";
    private static final String MULTI_CITY_ID = "switch__input_3";
    private static final String TRIP_OPTIONS_ID = "js-switch__option";

    // place
    private static final String FROM = "hp-widget__sfrom";
    private static final String FROM_SEARCH_RESULT_ID = "ui-id-1";
    private static final String TO = "hp-widget__sTo";
    private static final String TO_SEARCH_RESULT_ID = "ui-id-2";

    //date
    private static final String DEPART = "hp-widget__depart";
    private static final String RETURN = "hp-widget__return";

    public MMTHomePage(final Driver browserDriver) {
        super(browserDriver);
    }

    /**
     * Enter "from" in the home page
     * @param fromCity
     */
    public void enterFrom(final String fromCity) {
        LOG.info("FROM: TO BE SELECTED AS : ", fromCity);
        final WebElement fromElement = this.getElementUtil().findElement(By.id(FROM));
        fromElement.clear();
        fromElement.sendKeys(fromCity);
        this.selectFromDropDown(FROM_SEARCH_RESULT_ID);
    }

    public void enterTo(final String to) {
        LOG.info("TO: TO BE SELECTED AS : ", to);
        final WebElement fromElement = this.getElementUtil().findElement(By.id(TO));
        fromElement.clear();
        fromElement.sendKeys(to);
        this.selectFromDropDown(TO_SEARCH_RESULT_ID);
    }

    // Use this for selecting destination from the drop down, selects the first search result.
    private void selectFromDropDown(final String elementId) {
        final List<WebElement> searchResult = this.getElementUtil().findElement(By.id(elementId)).findElements(By.tagName("li"));
        searchResult.get(1).click();
    }

    public void selectRoundTrip() {
        // this is a radio button
        final List<WebElement> tripOptions = this.getElementUtil().findElement(By.id(TRIP_OPTIONS_ID)).findElements(By.tagName("div"));
        if (tripOptions.size() != 3) {
            Assert.fail("Page design must have changed!!!");
        }
        tripOptions.get(1).click();
    }

    public void selectDepartDate() {
        final WebElement datePicker = this.getElementUtil().findElement(By.id(DEPART));

    }

    public void selectReturnDate() {
        final WebElement datePicker = this.getElementUtil().findElement(By.id(RETURN));
    }
 }
