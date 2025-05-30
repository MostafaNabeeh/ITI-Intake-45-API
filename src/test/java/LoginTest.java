import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.LoginUtils;

public class LoginTest
{
    @Test
    public void Valid_Login() {
        JsonPath jsonPath = LoginUtils.login(Constants.email, Constants.password, 200).jsonPath();
        Assert.assertNotNull(jsonPath.get("token"), "token not null");
    }

    @Test
    public void Invalid_Login_With_Invalid_UserName() {
        JsonPath jsonPath = LoginUtils.login("", Constants.password, 400).jsonPath();
        Assert.assertEquals(jsonPath.getString("error"), "Missing email or username", "Error message mismatch.");
        Assert.assertTrue(jsonPath.getMap("$").containsKey("error"), "Error Key is missing in the response body");
    }

    @Test
    public void Invalid_Login_With_Invalid_Password() {
        JsonPath jsonPath = LoginUtils.login(Constants.email, "", 400).jsonPath();
        Assert.assertEquals(jsonPath.getString("error"), "Missing password", "Error message mismatch.");
    }

}

