package seleniumBooking.utils;

// passenger POJO holding a passenger details
public class PassengerDetails {

    // name details
    private String firstName;
    private String lastName;
    private Title title;
    // passport
    private String issuingCountry;
    private String dateOfExpiery;
    private String passportNumber;
    //MEAL
    private Meal meal;
    //DOB - in DD MM YYYY format
    private String dateOfBirth;

    public PassengerDetails() {

    }

    public enum Title {
        Mr,
        Ms,
        Mstr,
    }

    public enum Meal {
        // maps to vegetarian hindu meal
        Vegetarian,
        // maps to Baby meal
        Baby,
        // maps to Hindu non-vegetarian meal
        Hindu,
        // maps to Kosher Meal
        Kosher,
        // maps to Moslem Meal
        Moslem,
        // maps to Vegetarian Jain Meal
        Jain,
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(final Title title) {
        this.title = title;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(final String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public String getDateOfExpiery() {
        return dateOfExpiery;
    }

    public void setDateOfExpiery(String dateOfExpiery) {
        this.dateOfExpiery = dateOfExpiery;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(final Meal meal) {
        this.meal = meal;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
