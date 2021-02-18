package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessageProvider {

    @DataProvider(name = "mandatoryErrors")
    public List<String>[] getErrors() {
        List<String>[] listStorage = new ArrayList[1];
        listStorage[0] = new ArrayList<String>() {
            {
                add("You must register at least one phone number.");
                add("lastname is required.");
                add("firstname is required.");
                add("passwd is required.");
                add("address1 is required.");
                add("city is required.");
                add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
                add("This country requires you to choose a State.");
            }
        };
        return listStorage;
    }
}
