package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginUtils {

    public static Response login(String userName, String password) {
        return RestAssured.given().log().all().when().contentType(ContentType.JSON).body("{\n" +
                "    \"email\": \"" + userName + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}").post(Constants.baseURL + Constants.loginEndPoint).then().extract().response();
    }
}
