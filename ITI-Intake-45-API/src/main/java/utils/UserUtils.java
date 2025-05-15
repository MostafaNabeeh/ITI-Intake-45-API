package utils;

import RequestModels.CreateUserRequestModel;
import ResponseModels.SingleUserResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserUtils {

    public static SingleUserResponseModel getSingleUser(int expectedId, int expectedStatusCode){
        return RestAssured.given().when().headers(ProjectHeaders.generalHeaders()).get(Constants.baseURL+Constants.userEndPoint+"/"+expectedId).then().statusCode(expectedStatusCode).extract().as(SingleUserResponseModel.class);
    }

    public static Response listUsers(String pageNo){
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page",pageNo);
        return RestAssured.given().when().headers(ProjectHeaders.generalHeaders()).queryParams(queryParams).get(Constants.baseURL+Constants.userEndPoint).then().extract().response();
    }

    public static Response createUser(String name, String job){
        CreateUserRequestModel body = new CreateUserRequestModel();
        body.name = name;
        body.job = job;
        return RestAssured.given().when().headers(ProjectHeaders.generalHeaders()).
                body(GeneralUtils.getObject(body)).post(Constants.baseURL+Constants.userEndPoint).then().extract().response();
    }

}
