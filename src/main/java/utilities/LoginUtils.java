package utilities;

import Models.RequestModels_Serialization.LoginRequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginUtils {
    public static Response login(String email, String password, int StatusCode) {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.email = email;
        loginRequestModel.password = password;

        return RestAssured.given().when().log().all()
                .headers(Headers.generalHeaders())
                .body(GeneralUtils.getObject(loginRequestModel))
                .post(Constants.baseUrl + Constants.LoginEndPoint)
                .then().log().all().statusCode(StatusCode).extract().response();
    }
}
