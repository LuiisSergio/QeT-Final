package integracao;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static integracao.IntegracaoUtils.criaUsuario;
import static integracao.IntegracaoUtils.transformaBase64;
import static io.restassured.RestAssured.*;

public class LoginControllerTest {

    String login = "login@email.com";
    String senha = "Abc12345";

    @Test
    void when_logged_then_OK() {
        useRelaxedHTTPSValidation();

        criaUsuario(login, senha);
        String usuarioSenha = transformaBase64(login, senha);

        given()
                .header("Authorization","Basic " + usuarioSenha)
        .when()
                .get("https://localhost:5000/api-logIn")
                .then()
                .statusCode(200);
    }

    @Test
    void when_logOut_then_OK() {
        useRelaxedHTTPSValidation();

        criaUsuario(login, senha);
        String usuarioSenha = transformaBase64(login, senha);

        given()
                .header("Authorization","Basic " + usuarioSenha)
        .when()
                .get("https://localhost:5000/api-logOut")
                .then()
                .statusCode(200);
    }

}
