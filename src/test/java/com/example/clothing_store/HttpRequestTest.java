package com.example.clothing_store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void homepageShouldIncludeWelcomeMessage() throws Exception {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Welcome to our clothing store");
    }

    @Test
    void testParaFallo() throws Exception {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("to our clothing store");
    }

}
