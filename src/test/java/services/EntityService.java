package services;

import helpers.Specifications;
import io.qameta.allure.Step;
import pojo.EntityRequest;
import helpers.PropertyProvider;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class EntityService extends Specifications{

    @Step("Создание запроса сущности")
    public static EntityRequest createEntity() {

        return EntityRequest.builder()
                .addition(EntityRequest.Addition.builder()
                        .additional_number(PropertyProvider.getAdditionalNumber())
                        .build())
                .important_numbers(PropertyProvider.getImportantNumbers())
                .build();
    }

    @Step("Создание сущности и возврат её ID /api/create")
    public static String createEntityId(EntityRequest request) {
        return given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .post(PropertyProvider.getProperty("endpoint.create"))
                .then()
                .statusCode(200)
                .extract().asString();
    }

    @Step("Обновление сущности /api/patch/{id}")
    public static EntityRequest updateEntity() {

        var newTitle = "Обновленный заголовок";
        var newVerified = false;
        var newAdditionalInfo = "Обновленные сведения";
        List<Integer> newImportantNumbers = Arrays.asList(100, 200, 300);
        var newAdditional_number = 321;

        return EntityRequest.builder()
                .addition(EntityRequest.Addition.builder()
                        .additional_info(newAdditionalInfo)
                        .additional_number(newAdditional_number)
                        .build())
                .important_numbers(newImportantNumbers)
                .title(newTitle)
                .verified(newVerified)
                .build();
    }

    @Step("Запрос на удаление сущности и ее дополнений /api/delete/{id}")
    public static void deleteEntity(String createEntityId) {
        given()
                .spec(requestSpecification)
                .when()
                .delete(PropertyProvider.getProperty("endpoint.delete") + createEntityId)
                .then()
                .statusCode(204);
    }
}
