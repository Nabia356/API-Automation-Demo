package utilities;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class BaseTest {

    protected static String BASE_ENDPOINT = ApplicationConfiguration.getBaseURL();
    public static RequestSpecification reqSpec;
    public static Response response;
    public static int newActivitiesId;
    public static Faker faker = new Faker();

    public static void createRequestSpec() {
        reqSpec = RestAssured.given()
                .baseUri(BASE_ENDPOINT)
                .contentType(ContentType.JSON)
                .accept("*/*")
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
    }

    public static void createResponseSpec() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is not matched :");
        Assert.assertTrue(response.getContentType().contains("application/json"), "Content Type is not Matched :-" + response.getContentType());
        Assert.assertTrue(response.getTime() < 20000L, "Response time is not in the range");
    }

    public static void createDeleteResponseSpec() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is not matched :");
        Assert.assertTrue(response.getTime() < 20000L, "Response time is not in the range");
    }
    public static void createResponseSpecForInvalidData() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Status code is not matched :");
        Assert.assertFalse(response.getContentType().contains("application/json"), "Content Type is not Matched :-" + response.getContentType());
        Assert.assertTrue(response.getTime() < 20000L, "Response time is not in the range");
    }

    public static void createResponseSpecNotFound() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Status code is not matched :");
        Assert.assertFalse(response.getContentType().contains("application/json"), "Content Type is not Matched :-" + response.getContentType());
        Assert.assertTrue(response.getTime() < 20000L, "Response time is not in the range");
    }

}
