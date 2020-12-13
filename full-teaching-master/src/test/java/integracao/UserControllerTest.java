package integracao;

import org.junit.jupiter.api.Test;

import static integracao.IntegracaoUtils.*;
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
        criaUsuario("duplicado@email.com", "Abc12345");

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

    @Test
    void when_changePassword_then_success() {
        useRelaxedHTTPSValidation();
        String login = "setpassword@email.com";
        String senha = "Abc12345";
        String novaSenha = "Def67890";
        criaUsuario(login, senha);
        String loginSenha = transformaBase64(login,senha);
        login(loginSenha);

        given()
                .header("Authorization","Basic " + loginSenha)
            .with()
                .body("[\"" + senha + "\", \"" + novaSenha + "\"]")
            .when()
                .put("https://localhost:5000/changePassword")
            .then()
                .statusCode(200);
    }

}
