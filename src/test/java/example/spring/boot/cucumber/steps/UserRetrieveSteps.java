package example.spring.boot.cucumber.steps;

import cucumber.api.java.en.Then;
import example.spring.boot.page.UserRetrievePage;
import example.spring.boot.page.domain.User;
import example.spring.boot.page.domain.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserRetrieveSteps extends SpringBootTestStep {

    private final UserFactory userFactory;
    private final UserRetrievePage userRetrievePage;

    @Autowired
    public UserRetrieveSteps(UserFactory userFactory, UserRetrievePage userRetrievePage) {
        this.userFactory = userFactory;
        this.userRetrievePage = userRetrievePage;
    }

    @Then("^I should see the users details$")
    public void I_should_see_the_users_details() {

        final User user = userFactory.currentUser();

        assertThat(userRetrievePage.getUsername(), equalTo(user.getUsername()));
        assertThat(userRetrievePage.getPassword(), equalTo(user.getPassword()));
    }
}
