package test.example.spring.boot.cucumber.steps;

import example.spring.boot.cucumber.steps.UserCreationSteps;
import example.spring.boot.data.UserRepository;
import example.spring.boot.page.UserCreationPage;
import example.spring.boot.page.domain.User;
import example.spring.boot.page.domain.UserFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserCreationStepsTest {

    private UserCreationPage userCreationPage;
    private UserFactory userFactory;
    private UserRepository userRepository;

    private UserCreationSteps steps;

    @Before
    public void setUp() {
        userCreationPage = mock(UserCreationPage.class);
        userFactory = mock(UserFactory.class);
        userRepository = mock(UserRepository.class);

        steps = new UserCreationSteps(userCreationPage, userFactory, userRepository);
    }

    @Test
    public void Can_go_to_the_user_creation_page() {

        final UserCreationPage visitedUserCreationPage = mock(UserCreationPage.class);

        // Given
        given(userCreationPage.visit()).willReturn(visitedUserCreationPage);
        given(visitedUserCreationPage.getTitle()).willReturn("Create User");

        // When
        steps.I_am_on_the_user_creation_page();

        // Then
        verify(userCreationPage).visit();
    }

    @Test(expected = AssertionError.class)
    public void Can_see_when_attempting_to_go_to_the_user_creation_page_fails() {

        final UserCreationPage visitedUserCreationPage = mock(UserCreationPage.class);

        // Given
        given(userCreationPage.visit()).willReturn(visitedUserCreationPage);
        given(visitedUserCreationPage.getTitle()).willReturn(someString());

        // When
        steps.I_am_on_the_user_creation_page();
    }

    @Test
    public void Can_create_a_user() {

        final User user = mock(User.class);

        // Given
        given(userFactory.randomUser()).willReturn(user);

        // When
        steps.I_create_a_new_user();

        // Then
        verify(userCreationPage).create(user);
    }

    @Test
    public void Can_check_that_a_user_has_been_created() {

        final User user = mock(User.class);
        final example.spring.boot.domain.User persistedUser = mock(example.spring.boot.domain.User.class);
        final String username = someString();

        // Given
        given(userFactory.currentUser()).willReturn(user);
        given(user.getUsername()).willReturn(username);
        given(userRepository.findByUsername(username)).willReturn(persistedUser);

        // When
        steps.the_user_should_have_been_created();

        // Given
        verify(userRepository).findByUsername(username);
    }

    @Test(expected = AssertionError.class)
    public void Can_see_when_a_user_has_failed_to_be_created() {

        final User user = mock(User.class);
        final String username = someString();

        // Given
        given(userFactory.currentUser()).willReturn(user);
        given(user.getUsername()).willReturn(username);
        given(userRepository.findByUsername(username)).willReturn(null);

        // When
        steps.the_user_should_have_been_created();
    }
}
