package dataproviders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import support.pojos.RegistrationForm;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RegistrationInformationJsonProvider {

    @DataProvider(name = "registrationData")
    public RegistrationForm[] getRegistrationData() {
        RegistrationForm[] testData = new RegistrationForm[1];

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testData[0] = objectMapper.readValue(new File("src/test/resources/RegData.json"), RegistrationForm.class);
            String currentEmail = testData[0].getPersonalInformation().getEmail();
            testData[0].getPersonalInformation().setEmail(randomizeEmail(currentEmail));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }

    private String randomizeEmail(String currentEmail) {
        String[] emailParts = currentEmail.split("@");
        return emailParts[0] + new Random().nextInt() + "@" + emailParts[1];
    }

}
