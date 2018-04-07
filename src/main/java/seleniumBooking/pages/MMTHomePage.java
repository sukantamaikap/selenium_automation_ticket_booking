package seleniumBooking.pages;

import org.omg.CORBA.FREE_MEM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import seleniumBooking.drivers.Driver;
import seleniumBooking.utils.Months;
import seleniumBooking.utils.SitClass;

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
    private static final String DEPART_DATE_PICKER_XPATH = "//div[@id='js-filterOptins']/child::table";
    private static final String RETURN = "hp-widget__return";

    // pax
    private static final String SELECT_PASSENGER_AND_CLASS = "//input[@id='hp-widget__paxCounter_pot']";
    private static final String SELECT_CLASS = "//ul[@id='pot_ul']/li";
    private static final String SELECT_ADULTS = "//ul[@id='js-adult_counter']/li[%s]";
    private static final String SELECT_CHILDREN = "//ul[@id='js-child_counter']/li[%s]";
    private static final String SELECT_INFANT = "//ul[@id='js-infant_counter']/li[%s]";

    // search
    private static final String SEARCH_BUTTON_ID = "searchBtn";

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

    public void selectDepartDate(final int date, final Months month) {
        if (date < 1 || date > 31) {
            org.testng.Assert.fail("Invalid date !!!");
        }
        this.getElementUtil().findElement(By.id(DEPART)).click();
        final WebElement datePicker = this.getElementUtil().findElement(By.id(DEPART_DATE_PICKER_XPATH));
    }

    public void selectReturnDate() {
        this.getElementUtil().findElement(By.id(RETURN)).click();
    }

    public void enterPassengers(final int adultPassengers,
                                final int kids,
                                final int infant,
                                final SitClass siteClass) {
        LOG.info("CLICK ON \"PASSENGERS | CLASS\"");
        this.getElementUtil().findElement(By.xpath(SELECT_PASSENGER_AND_CLASS)).click();

        if (adultPassengers > 0) {
            LOG.info("SELECT ADULTS");
            if (adultPassengers > 9) {
                Assert.fail("Adult passengers may not be more than 9 !!");
            }
            final String finalXpathAdults = String.format(SELECT_ADULTS, adultPassengers);
            this.getElementUtil().findElement(By.xpath(finalXpathAdults)).click();
        } else {
            LOG.info("NO ADULTS TO SELECT !!");
        }

        if (kids > 0) {
            if (kids > 6) {
                Assert.fail("Can't book tickets for more than 6 kids !!!");
            }
            LOG.info("SELECT CHILDREN");
            final String finalXpathKids = String.format(SELECT_CHILDREN, kids);
            this.getElementUtil().findElement(By.xpath(finalXpathKids)).click();
        } else {
            LOG.info("NO CHILD TO SELECT!!!");
        }

        if (infant > 0) {
            if (infant > 6) {
                Assert.fail("Can't book ticket for more than 6 infants!!!");
            }
            LOG.info("SELECT INFANTS");
            final String finalXpathInfants = String.format(SELECT_INFANT, infant);
            this.getElementUtil().findElement(By.xpath(finalXpathInfants)).click();

        } else {
            LOG.info("NO INFANTS TO SELECT!!!");
        }

        if (siteClass != null) {
            LOG.info("SELECT CLASS");
            final List<WebElement> classOptions = this.getElementUtil().findElements(By.xpath(SELECT_CLASS));
            if (classOptions.size() >= 3) {
                for (WebElement option : classOptions) {
                    if (option.getText().equalsIgnoreCase(siteClass.name())) {
                        option.click();
                        break;
                    }
                }
            }

        } else {
            LOG.info("CLASS NOT SPECIFIED, BY DEFAULT ECONOMY IS SELECTED");
        }
    }

    public void search() {
        this.getElementUtil().findElement(By.id(SEARCH_BUTTON_ID)).click();
    }
}
