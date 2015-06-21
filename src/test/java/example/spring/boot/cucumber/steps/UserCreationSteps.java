package example.spring.boot.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.spring.boot.data.UserRepository;
import example.spring.boot.page.UserCreationPage;
import example.spring.boot.page.domain.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserCreationSteps extends SpringBootTestStep {

    private final UserCreationPage userCreationPage;
    private final UserFactory userFactory;
    private final UserRepository userRepository;

    @Autowired
    public UserCreationSteps(UserCreationPage userCreationPage, UserFactory userFactory, UserRepository userRepository) {
        this.userCreationPage = userCreationPage;
        this.userFactory = userFactory;
        this.userRepository = userRepository;
    }

    @Given("^I am on the user creation page$")
    public void I_am_on_the_user_creation_page() {
        assertThat(userCreationPage.visit().getTitle(), equalTo("Create User"));
    }

    @When("^I create a new user$")
    public void I_create_a_new_user() {
        userCreationPage.create(userFactory.randomUser());
    }

    @Then("^the user should have been created$")
    public void the_user_should_have_been_created() {
        assertThat(userRepository.findByUsername(userFactory.currentUser().getUsername()), not(nullValue()));
    }
}
