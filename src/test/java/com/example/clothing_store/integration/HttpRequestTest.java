package com.example.clothing_store.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.clothing_store.entities.TypeProduct;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

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
    void typesIncludesEnumValues() throws Exception {
        String[] response = this.testRestTemplate.getForObject("http://localhost:" + port + "/types", String[].class);
        List<String> listOfEnums = Arrays.stream(TypeProduct.values())
                .map(TypeProduct::toString)
                .toList();

        assertThat(response)
                .isNotNull()
                .containsExactlyInAnyOrderElementsOf(listOfEnums);
    }

}
