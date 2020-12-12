package integracao;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class UserControllerTest {

    @Test
    void when_createUser_then_success() {
        useRelaxedHTTPSValidation();
        given()
                .contentType("application/json")
            .with()
                .body("[\"novo@email.com\", \"Abc12345\", \"novo\", \"IGNORE\"]")
            .when()
                .post("https://localhost:5000/api-users/new")
            .then()
                .statusCode(201);
    }

    @Test
    void when_createDuplicateUser_then_conflict() {
        useRelaxedHTTPSValidation();
        criaUsuario("duplicado@email.com");

        given()
                .contentType("application/json")
                .with()
                .body("[\"duplicado@email.com\", \"Abc12345\", \"user\", \"IGNORE\"]")
                .when()
                .post("https://localhost:5000/api-users/new")
                .then()
                .statusCode(409);
    }

    @Test
    void when_createUserWithInvalidPassword_then_badRequest() {
        useRelaxedHTTPSValidation();

        given()
                .contentType("application/json")
                .with()
                .body("[\"senhainvalida@email.com\", \"abc123\", \"user\", \"IGNORE\"]")
                .when()
                .post("https://localhost:5000/api-users/new")
                .then()
                .statusCode(400);
    }

    @Test
    void when_createUserWithInvalidEmail_then_forbidden() {
        useRelaxedHTTPSValidation();

        given()
                .contentType("application/json")
                .with()
                .body("[\"emailinvalido\", \"Abc12345\", \"user\", \"IGNORE\"]")
                .when()
                .post("https://localhost:5000/api-users/new")
                .then()
                .statusCode(403);
    }
/*
    @Test
    void when_createUserWithNoIgnoreCaptcha_then_forbidden() {
        useRelaxedHTTPSValidation();

        given()
                .contentType("application/json")
                .with()
                .body("[\"nocaptcha@email.com\", \"Abc12345\", \"user\"]")
                .when()
                .post("https://localhost:5000/api-users/new")
                .then()
                .statusCode(403);
    }
*/
    private void criaUsuario(String email) {
        given()
                .contentType("application/json")
                .with()
                .body("[\""+email+"\", \"Abc12345\", \"user\", \"IGNORE\"]")
                .when()
                .post("https://localhost:5000/api-users/new");
    }
}
