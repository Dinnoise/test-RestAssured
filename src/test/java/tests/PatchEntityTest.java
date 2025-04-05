package tests;

import helpers.PropertyProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;
import services.EntityService;
import static io.restassured.RestAssured.given;

@Epic("Управление сценариями PATCH")
public class PatchEntityTest extends BaseTest{

    @Feature("Сценарий PATCH (создать - обновить данные)")
    @Test(description = "Проверить создание сущности, обновление сущности и ее дополнений")
    public void testCreateAndPatchEntity()
    {
        var request = EntityService
                .createEntity();

        createEntityId = EntityService
                .createEntityId(request);

        var updateRequest = EntityService
                .updateEntity();

        given()
                .filter(new AllureRestAssured())
                .spec(requestSpecification)
                .body(updateRequest)
                .when()
                .patch(PropertyProvider.getProperty("endpoint.patch") + createEntityId)
                .then()
                .statusCode(204);
    }
}
