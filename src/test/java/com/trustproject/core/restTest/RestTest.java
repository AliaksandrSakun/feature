package com.trustproject.core.restTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestTest {


    @Test
    void getImageTest() {

        String filename = given()
                .log().all()
                .auth()
                .preemptive()
                .basic("user", "password")
                .when()
                .contentType(ContentType.JSON)
                .get("http://localhost:8080/images/3")
                .then()
                .log().headers()
                .statusCode(200)
                .extract().headers().getValue("filename");

        Assertions.assertEquals("monkey.jpg", filename);
    }

    @Test
    void saveImageTest() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Study\\core\\src\\test\\java\\com\\trustproject\\core\\My_foto.jpg");
        MockMultipartFile file = new MockMultipartFile("my_foto", fis);

        given()
                .log().all()
                .auth()
                .preemptive()
                .basic("user", "password")
                .when()
//                .contentType(ContentType.JSON)
                .body(file)
                .post("http://localhost:8080/images")
                .then()
                .log().headers()
                .statusCode(200)
                .extract().headers().getValue("filename");

    }
}



