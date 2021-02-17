package dataproviders;

import org.testng.annotations.DataProvider;

public class ErrorMessageProvider {

    @DataProvider(name = "mandatoryErrors")
    public ListOfElements[] getErrors() {
        ListOfElements[] listStorage = new ListOfElements[1];
        listStorage[0] = new ListOfElements(
                "You must register at least one phone number.",
                "lastname is required.",
                "firstname is required.",
                "passwd is required.",
                "address1 is required.",
                "city is required.",
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
                "This country requires you to choose a State."
                );
        return listStorage;
    }
}
