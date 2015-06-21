package test.example.spring.boot.page.domain;

import example.spring.boot.page.domain.DefaultUserFactory;
import example.spring.boot.page.domain.User;
import example.spring.boot.page.domain.UserHolder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DefaultUserFactoryTest {

    private UserHolder userHolder;
    private DefaultUserFactory factory;

    @Before
    public void setUp() {
        userHolder = mock(UserHolder.class);
        factory = new DefaultUserFactory(userHolder);
    }

    @Test
    public void Can_create_a_random_user() {

        // Given
        given(userHolder.set(any(User.class))).willAnswer(new ReturnsArgumentAt(0));
        final User expected = factory.randomUser();

        // When
        final User actual = factory.randomUser();

        // Then
        assertThat(actual, not(equalTo(expected)));
        verify(userHolder).set(expected);
        verify(userHolder).set(actual);
    }

    @Test
    public void Can_get_the_current_test_user() {

        final User expected = mock(User.class);

        // Given
        given(userHolder.get()).willReturn(expected);

        // When
        final User actual = factory.currentUser();

        // Then
        assertThat(actual, equalTo(expected));
    }
}
