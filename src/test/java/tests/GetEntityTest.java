package tests;

import helpers.PropertyProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import services.EntityService;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Управление сценариями GET")
public class GetEntityTest extends BaseTest
{
    @Feature("Сценарий Get (создать - получить сущность)")
    @Test(description = "Проверить создание сущности и получение её по ID")
    public void testCreateAndGetEntity() {

        var request = EntityService
                .createEntity();

        createEntityId = EntityService
                .createEntityId(request);

        given()
                .spec(requestSpecification)
                .when()
                .get(PropertyProvider.getProperty("endpoint.get") + createEntityId)
                .then()
                .statusCode(200)
                .body("title", equalTo("Заголовок сущности"))
                .body("verified", is(true))
                .body("addition.additional_info", equalTo("Дополнительные сведения"))
                .body("important_numbers", hasItems(42, 87, 15));
    }
}
