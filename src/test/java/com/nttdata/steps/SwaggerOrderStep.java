package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class SwaggerOrderStep {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void CrearOrder(String idOrden, String idMascota) {
        String body="{\n" +
                "  \"id\": "+idOrden+",\n" +
                "  \"petId\": "+idMascota+",\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2024-12-17T05:06:24.876Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void Status(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta", statusCode, response.statusCode());
    }

    public void ConsultarOrder(String idOrden) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                //.log().all()
                .get("/store/order/"+ idOrden)
                .then()
                .log().all()
                .extract().response();
    }
}
