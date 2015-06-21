package test.example.spring.boot.cucumber.steps;

import example.spring.boot.cucumber.steps.UserRetrieveSteps;
import example.spring.boot.page.UserRetrievePage;
import example.spring.boot.page.domain.User;
import example.spring.boot.page.domain.UserFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserRetrieveStepsTest {

    private UserRetrievePage userRetrievePage;
    private UserFactory userFactory;
    private UserRetrieveSteps steps;

    @Before
    public void setUp() {
        userRetrievePage = mock(UserRetrievePage.class);
        userFactory = mock(UserFactory.class);
        steps = new UserRetrieveSteps(userFactory, userRetrievePage);
    }

    @Test
    public void Can_verify_that_the_users_details_are_correct() {

        final User user = mock(User.class);
        final String username = someString();
        final String password = someString();

        // Given
        given(userFactory.currentUser()).willReturn(user);
        given(user.getUsername()).willReturn(username);
        given(user.getPassword()).willReturn(password);
        given(userRetrievePage.getUsername()).willReturn(username);
        given(userRetrievePage.getPassword()).willReturn(password);

        // When
        steps.I_should_see_the_users_details();

        // Then
        final InOrder order = inOrder(userFactory, user, userRetrievePage);
        order.verify(userFactory).currentUser();
        order.verify(userRetrievePage).getUsername();
        order.verify(user).getUsername();
        order.verify(userRetrievePage).getPassword();
        order.verify(user).getPassword();
    }

    @Test(expected = AssertionError.class)
    public void Can_verify_that_the_users_username_is_incorrect() {

        final User user = mock(User.class);
        final String password = someString();

        // Given
        given(userFactory.currentUser()).willReturn(user);
        given(user.getUsername()).willReturn(someString());
        given(user.getPassword()).willReturn(password);
        given(userRetrievePage.getUsername()).willReturn(someString());
        given(userRetrievePage.getPassword()).willReturn(password);

        // When
        steps.I_should_see_the_users_details();
    }

    @Test(expected = AssertionError.class)
    public void Can_verify_that_the_users_password_is_incorrect() {

        final User user = mock(User.class);
        final String username = someString();

        // Given
        given(userFactory.currentUser()).willReturn(user);
        given(user.getUsername()).willReturn(username);
        given(user.getPassword()).willReturn(someString());
        given(userRetrievePage.getUsername()).willReturn(username);
        given(userRetrievePage.getPassword()).willReturn(someString());

        // When
        steps.I_should_see_the_users_details();
    }
}
