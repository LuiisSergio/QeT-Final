package integracao;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class IntegracaoUtils {
    public static void criaUsuario(String email, String senha) {
        given()
                .contentType("application/json")
                .with()
                .body("[\""+email+"\", \""+senha+"\", \"user\", \"IGNORE\"]")
                .when()
                .post("https://localhost:5000/api-users/new");
    }

    public static void login(String usuarioSenha) {
        useRelaxedHTTPSValidation();
        String response = given()
                .header("Authorization","Basic " + usuarioSenha)
                .when()
                .get("https://localhost:5000/api-logIn")
                .asString();

        System.out.println(response);
    }

    public static String transformaBase64(String login, String senha) {
        String usuarioSenha = login + ":" + senha;
        return Base64.getEncoder().encodeToString(usuarioSenha.getBytes(StandardCharsets.UTF_8));
    }
}
