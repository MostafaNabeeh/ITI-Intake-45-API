import ResponseModels.SingleUserResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.LoginUtils;
import utils.UserUtils;


public class UserTests {

    @Test
    public void getSingleUserSuccessfully(){
        SoftAssert softAssert = new SoftAssert();
        int expectedId = 2;
        SingleUserResponseModel response = UserUtils.getSingleUser(expectedId,200);
        int actualId = response.data.id;
        softAssert.assertEquals(actualId,expectedId, "id is not the same");
        softAssert.assertNotNull(response.data.email, "email is null");
        softAssert.assertNotNull(response.data.firstName, "name is null");
        softAssert.assertAll();
    }

    @Test
    public void getListOfUsersSuccessfully(){
        Response response = UserUtils.listUsers("2");
        Assert.assertEquals(response.statusCode(),200,"Status code is not correct");
    }

    @Test
    public void getListOfUsersEmptyPage(){
        Response response = UserUtils.listUsers("");
        Assert.assertEquals(response.statusCode(),400,"Status code is not correct");
    }

    @Test
    public void createUserSuccessfully(){
        SoftAssert softAssert = new SoftAssert();
        String name = "Ahmed";
        String job = "tester";
        Response response = UserUtils.createUser(name,job);
        Assert.assertEquals(response.statusCode(),201);
        softAssert.assertEquals(response.jsonPath().getString("name"), name);
        softAssert.assertEquals(response.jsonPath().getString("job"), job);
        softAssert.assertAll();
    }

    @Test
    public void createUserWithEmptyName(){
        Response response = UserUtils.createUser("","tester");
        Assert.assertEquals(response.statusCode(),400);
    }

    @Test
    public void createUserWithEmptyJob(){
        Response response = UserUtils.createUser("name","");
        Assert.assertEquals(response.statusCode(),400);
    }




}
