package tests;

import helpers.PropertyProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import services.EntityService;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

@Epic("Управление сценариями POST")
public class CreateAndDeleteEntityTest extends BaseTest {

    @Feature("Сценарий POST (создать - удалить)")
    @Test(description = "Проверить создание сущности и ее удаление")
    public void testCreateEntityWithSerialization() {

        var request = EntityService
                .createEntity();

        var response = given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .post(PropertyProvider.getProperty("endpoint.create"))
                .then()
                .statusCode(200)
                .body(not(emptyString()))
                .extract().response();
        createEntityId = response.asString();
    }
}
