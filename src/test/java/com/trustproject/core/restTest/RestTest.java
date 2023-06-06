package com.trustproject.core.restTest;

import com.trustproject.core.dto.CardDTO;
import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.dto.RuWordDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTest {

    @LocalServerPort
    private static int port = 8080;

    @BeforeAll
    static void setUp()  {
        RestAssured.port = port;
    }

    @Test
    void getCardByIdTest() {
        Integer id = given().log().all()
                .auth().preemptive().basic("user", "password")
                .when().contentType(ContentType.JSON).get("http://localhost:8080/cards/1")
                .then().log().all().statusCode(200)
                .extract().body().jsonPath().get("id");

        Assertions.assertEquals(1, id);
    }

    @Test
    void getCardByEnWordTest() {
        Integer id = given().log().all().auth().preemptive().basic("user", "password")
                .when().contentType(ContentType.JSON).get("http://localhost:8080/translate/monkey")
                .then().log().headers().statusCode(200)
                .extract().body().jsonPath().get("id");

        Assertions.assertEquals(1, id);
    }

    @Test
    void saveCardTest() {
        CardDTO cardDTO = new CardDTO(1L, new EnWordDTO(5L, "someWord"), new RuWordDTO(5L,
                "слово"), null, 10L);

        given().log().all().auth().preemptive().basic("user", "password")
                .when().contentType(ContentType.JSON).body(cardDTO).post("http://localhost:8080/cards")
                .then().log().headers().statusCode(201);
    }

    @Test
    void getImageTest() {
        String filename = given().log().all().auth().preemptive().basic("user", "password")
                .when().contentType(ContentType.JSON).get("http://localhost:8080/images/3")
                .then().log().all().statusCode(200)
                .extract().headers().getValue("filename");

        Assertions.assertEquals("monkey.jpg", filename);
    }
}



