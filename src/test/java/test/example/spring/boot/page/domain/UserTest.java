package test.example.spring.boot.page.domain;

import example.spring.boot.page.domain.User;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserTest {

    @Test
    public void Users_with_the_same_values_are_equal() {

        // Given
        final String username = someString();
        final String password = someString();

        final User expected = new User(username, password);

        // When
        final User actual = new User(username, password);

        // Then
        assertThat(actual, equalTo(actual));
        assertThat(actual, equalTo(expected));
        assertThat(new User(username, password), equalTo(new User(username, password)));
        assertThat(new User(null, password), equalTo(new User(null, password)));
        assertThat(new User(username, null), equalTo(new User(username, null)));
        assertThat(new User(null, null), equalTo(new User(null, null)));
    }

    @Test
    public void Users_with_different_user_names_are_not_equal() {

        // Given
        final String password = someString();

        final User expected = new User(someString(), password);

        // When
        final User actual = new User(someString(), password);

        // Then
        assertThat(actual, not(equalTo(expected)));
        assertThat(actual, not(equalTo(new User(null, password))));
        assertThat(new User(null, password), not(equalTo(expected)));
    }

    @Test
    public void Users_with_different_passwords_are_not_equal() {

        // Given
        final String username = someString();

        final User expected = new User(username, someString());

        // When
        final User actual = new User(username, someString());

        // Then
        assertThat(actual, not(equalTo(expected)));
        assertThat(actual, not(equalTo(new User(username, null))));
        assertThat(new User(username, null), not(equalTo(expected)));
    }

    @Test
    public void User_is_not_equal_to_a_different_object() {

        // When
        final User actual = new User(someString(), someString());

        // Then
        assertThat(actual, not(equalTo(new Object())));
    }
}
