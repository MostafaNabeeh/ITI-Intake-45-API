package utilities;

import Models.RequestModels_Serialization.CreateUserRequestModel;
import Models.ResponseModel_DESerialization.CreateUserSuccessfullyModel;
import Models.ResponseModel_DESerialization.GetSingleUserModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public  class UserUtils  {

    /* De_Serialization GET Request as(GetSingleUserModel.class) */
    public static GetSingleUserModel getSingleUser(int id, int statusCode) {
        return RestAssured.given().log().all()
                .headers(Headers.generalHeaders())
                .get(Constants.baseUrl + Constants.UserEndPoint + "/" + id)
                .then().log().all()
                .statusCode(statusCode).extract().response()
                .as(GetSingleUserModel.class);
    }

    public static CreateUserSuccessfullyModel CreateUserSuccessfully(String name, String job ,int statusCode) {
         Response response = CreateUser( name,job ,statusCode);
         return response.as(CreateUserSuccessfullyModel.class);
    }

    /***********************************************************************************
    /* Serialization Post & Put Requests ObjectMapper in body request */
    public static Response CreateUser(String name, String job , int statusCode) {
        CreateUserRequestModel createUserRequestModel = new CreateUserRequestModel();
        createUserRequestModel.name = name;
        createUserRequestModel.job = job;

        return RestAssured.given().log().all().when()
                .headers(Headers.generalHeaders())
                .body(GeneralUtils.getObject(createUserRequestModel))
                .post(Constants.baseUrl + Constants.UserEndPoint)
                .then().log().all().statusCode(statusCode).extract().response();
    }





}
