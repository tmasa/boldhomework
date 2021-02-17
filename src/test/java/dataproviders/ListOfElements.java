package dataproviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple helper class to return a list of items by a DataProvider
 */
public class ListOfElements {

    List<String> listOfElements = new ArrayList<>();

    public ListOfElements(String... strings) {
        Collections.addAll(listOfElements, strings);
    }

    public List<String> getListOfStrings() {
        return listOfElements;
    }
}
