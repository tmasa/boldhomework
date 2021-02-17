package testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.pojos.backend.UserInformation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BackendTests {

    OkHttpClient client;
    final String usersEndpointUrl = "https://jsonplaceholder.typicode.com/users";

    @BeforeClass
    public void setUp() {
        client = new OkHttpClient();
    }

    private Response sendGetRequestToUrl(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        return call.execute();
    }

    @Test()
    public void testRestCallWithObjectMappingViaJackson() throws IOException {

        Response response = sendGetRequestToUrl(usersEndpointUrl);

        //Map JSON to POJO using Jackson - POJO generated via JSON2POJO IntelliJ plugin -> https://plugins.jetbrains.com/plugin/8533-json2pojo
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody body = response.body();
        Assert.assertNotNull(body);
        List<UserInformation> userInformationList = Arrays.asList(objectMapper.readValue(body.string(),UserInformation[].class));

        //Log only name and email - TODO: Where to log?
        userInformationList.stream()
                .map(act -> String.format("%s | %s", act.getName(), act.getEmail())).forEach(System.out::println);

        //verify first email contains @
        Assert.assertTrue(userInformationList.stream().findFirst().get().getEmail().contains("@"));
    }

    @Test(enabled = false)
    public void testRestCallWithoutObjectMappingViaJsonArray() throws IOException {

        Response response = sendGetRequestToUrl(usersEndpointUrl);

        ResponseBody body = response.body();
        Assert.assertNotNull(body);
        JSONArray jsonArray = new JSONArray(body.string());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.get("name").toString();
            String email = jsonObject.get("email").toString();
            System.out.printf("%s | %s%n", name, email);
            if (i == 0) {
                Assert.assertTrue(email.contains("@"));
            }
        }
    }
}

