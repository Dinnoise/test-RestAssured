package tests;

import helpers.PropertyProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import services.EntityService;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;

@Epic("Управление сценариями GET")
public class GetAllEntityTest extends BaseTest{

    @Feature("Сценарий GetAll (создать - получить все сущности)")
    @Test(description = "Проверить создание сущности и получить всех сущностей")
    public void testCreateAndGetAllEntity()
    {
        var request = EntityService
                .createEntity();

        createEntityId = EntityService
                .createEntityId(request);

        given()
                .spec(requestSpecification)
                .when()
                .get(PropertyProvider.getProperty("endpoint.getAll"))
                .then()
                .statusCode(200)
                .body("entity.size()", greaterThan(0))
                .body("entity.id", hasItem(Integer.parseInt(createEntityId)));
    }
}
