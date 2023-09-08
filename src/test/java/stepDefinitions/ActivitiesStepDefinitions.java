package stepDefinitions;

import com.model.Activities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.BaseTest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ActivitiesStepDefinitions extends BaseTest {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    String currentDateTime = dateFormat.format(new Date());
    @Given("Request payload is created for activities")
    public void request_payload_is_created_for_activities() {
        Activities activities = Activities.builder()
                .id((faker.number().numberBetween(31, 60)))
                .title(faker.name().title())
                .dueDate(currentDateTime)
                .completed(faker.bool().bool())
                .build();
        reqSpec.body(activities);
    }

    @Given("Update newly created activities record")
    public void update_newly_created_activities_record() {
        Activities activities = Activities.builder()
                .id((faker.number().numberBetween(31, 60)))
                .title("Updated " + faker.name().title())
                .dueDate(currentDateTime)
                .completed(faker.bool().bool())
                .build();
        reqSpec.body(activities);
    }
    @And("Request payload is created for invalid data for activities")
    public void requestPayloadIsCreatedForInvalidDataForActivities() {
        Activities activities = Activities.builder()

                .build();
        reqSpec.body(activities);
    }

    @And("Update newly created with invalid activities record")
    public void updateNewlyCreatedWithInvalidActivitiesRecord() {
        Activities activities = Activities.builder()
                .id((faker.number().numberBetween(31, 60)))
                .title("Updated " + faker.name().title())
                .completed(faker.bool().bool())
                .build();
        reqSpec.body(activities);
    }


}
