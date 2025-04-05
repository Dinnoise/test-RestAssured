package tests;

import helpers.Specifications;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import services.EntityService;

import java.io.IOException;

public class BaseTest {

    protected static RequestSpecification requestSpecification;
    protected String createEntityId;

    @BeforeClass
    public void setup() throws IOException {
        requestSpecification = Specifications.initRequestSpecification();
    }
    @AfterMethod
    public void tearDown() {
        EntityService.deleteEntity(createEntityId);
    }
}
