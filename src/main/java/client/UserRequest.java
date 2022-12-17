package client;

import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;

public class UserRequest extends RestClient {
    public static final String USER_REGISTER =  "/api/auth/register";
    public static final String USER_LOGIN =  "/api/auth/login";
    public static final String USER_DELETE = "/api/auth/user";
    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(USER_REGISTER)
                .then();
    }
    public ValidatableResponse login(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .post(USER_LOGIN)
                .then();
    }
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(USER_DELETE)
                .then();
    }
 }