
package io.splitfirex.commons;

import io.splitfirex.commons.model.JwtRequest;
import io.splitfirex.commons.model.JwtResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonsApplicationTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static String token = null;
    private static HttpHeaders headers = null;

    @BeforeAll
    public void obtencionToken() {

    }

    @Test
    public void servicio_prueba_ok() {
        ResponseEntity<JwtResponse> response = this.restTemplate.postForEntity("http://localhost:" + port + "/authenticate",
                new JwtRequest("javainuse", "password"),
                JwtResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getJwttoken()).isNotBlank();

        token = response.getBody().getJwttoken();
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(token);

        assertThat(token).isNotBlank();
    }

}
