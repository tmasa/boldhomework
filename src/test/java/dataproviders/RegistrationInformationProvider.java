package dataproviders;

import org.testng.annotations.DataProvider;
import support.enums.State;
import support.enums.Title;
import support.pojos.AddressInformation;
import support.pojos.PersonalInformation;
import support.pojos.RegistrationForm;

import java.util.Random;

public class RegistrationInformationProvider {

    @DataProvider(name = "registrationData")
    public RegistrationForm[] getRegistrationInformation() {
        RegistrationForm[] testData = new RegistrationForm[1];

        testData[0] = new RegistrationForm();
        PersonalInformation p = new PersonalInformation();
        p.setTitle(Title.MR);
        p.setFirstName("Home");
        p.setLastName("Work");
        p.setDayOfBirth("3");
        p.setMonthOfBirth("6");
        p.setYearOfBirth("1985");
        p.setEmail(String.format("random%s@random.com", new Random().nextInt()));
        p.setPassword("hello");
        p.setPartnerOfferRequested(true);
        p.setNewsletterRequested(false);

        AddressInformation a = new AddressInformation();
        a.setFirstName("Home");
        a.setLastName("Work");
        a.setAddressLine1("MyAddress");
        a.setCity("Denver");
        a.setState(State.COLORADO);
        a.setZip("80014");
        a.setMobilePhone("3035559066");

        testData[0].setPersonalInformation(p);
        testData[0].setAddressInformation(a);
        return testData;
    }

}
