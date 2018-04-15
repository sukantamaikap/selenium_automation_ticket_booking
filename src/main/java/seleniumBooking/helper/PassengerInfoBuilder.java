package seleniumBooking.helper;

import seleniumBooking.utils.PassengerDetails;

import java.util.Date;

public class PassengerInfoBuilder {
    public PassengerInfoBuilder() {

    }

    public PassengerDetails buildPassengerInfo(final String firstName,
                                               final String lastName,
                                               final PassengerDetails.Title title,
                                               final Date dateOfBirth,
                                               final PassengerDetails.Meal meal,
                                               final String passportNumber,
                                               final String issueingCountry,
                                               final Date expieryDate) {
        final PassengerDetails details = new PassengerDetails();
        details.setFirstName(firstName);
        details.setLastName(lastName);
        details.setTitle(title);
        details.setDateOfBirth(dateOfBirth.toString());
        // meal
        details.setMeal(meal);
        // passport
        details.setPassportNumber(passportNumber);
        details.setIssuingCountry(issueingCountry);
        details.setDateOfExpiery(expieryDate.toString());
        return details;
    }

}
