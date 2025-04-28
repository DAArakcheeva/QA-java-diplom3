package handlers;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StellarBurgersClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final String INVALID_INGREDIENT_ID = "{\n \"ingredients\": [\"1234543254\"]\n" +
            "}";

    @Step("Регистрация нового пользователя")
    public static ValidatableResponse createUser(User user) {
        return given()
                .log()
                .all()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/register")
                .then()
                .log()
                .all();
    }
    private RequestSpecification baseRequest() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setRelaxedHTTPSValidation()
                .build();
    }
    private RequestSpecification baseRequest(String contentType) {
        return new RequestSpecBuilder()
                .addHeader("Content-type", contentType)
                .addFilter(new AllureRestAssured())
                .setRelaxedHTTPSValidation()
                .build();
    }
    private Response loginUser(String email, String password) {
        return given(this.baseRequest("application/json"))
                .body(new User(email, password))
                .when()
                .post(StellarBurgersEndpoints.AUTH_LOGIN_ENDPOINT);

    }
    private Response deleteUser(String token) {
        return given(this.baseRequest())
                .auth().oauth2(token)
                .delete(StellarBurgersEndpoints.DELETE_USER_ENDPOINT);
    }
    @Step("Удаление тестового пользователя")
    public void deleteTestUser(String email, String password) {
        Response response = loginUser(email, password);

        if (response.getStatusCode() != 200) {
            return; // Выход, если вход не удался
        }

        // Извлекаем токен из тела ответа после удачного входа
        JsonPath jsonPathEvaluator = response.jsonPath();
        String accessToken = jsonPathEvaluator.getString("accessToken");

        // Удаляем пользователя, используя полученный токен
        deleteUser(accessToken);
    }
    @Step("Изменение пользователя")
    public ValidatableResponse updateUser(UserCredentials originalUser, UserCredentials updatedUser, String token) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .body(updatedUser)
                .patch("/api/auth/user")
                .then()
                .log().all();
    }
    @Step("Оформление заказа")
    public ValidatableResponse createOrder(Order order, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .baseUri(BASE_URL)
                .body(order)
                .when()
                .post("/api/orders")
                .then()
                .log().all();
    }
    @Step("Отправка заказа с некорректными компонентами")
    public ValidatableResponse createOrderWithNoIngredients(String ingredient) {
        if (ingredient == " ") {
            return given()
                    .log().all()
                    .baseUri(BASE_URL)
                    .header("Content-type", "application/json")
                    .body("{ }")
                    .post("/api/orders")
                    .then().log().all();
        } else {
            return given()
                    .log().all()
                    .baseUri(BASE_URL)
                    .header("Content-type", "application/json")
                    .body(INVALID_INGREDIENT_ID)
                    .post("/api/orders")
                    .then().log().all();
        }
    }
    @Step("Просмотр истории заказов пользователя")
    public ValidatableResponse getUserOrders(String token){
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .get("/api/orders")
                .then().log().all();
    }

}