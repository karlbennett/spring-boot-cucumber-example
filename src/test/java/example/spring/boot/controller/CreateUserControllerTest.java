package example.spring.boot.controller;

import example.spring.boot.data.UserRepository;
import example.spring.boot.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class CreateUserControllerTest {

    private UserRepository userRepository;
    private CreateUserController controller;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        controller = new CreateUserController(userRepository);
    }

    @Test
    public void Can_request_the_create_user_page() {

        // When
        final String actual = controller.view();

        // Then
        assertThat(actual, equalTo("createUser"));
    }

    @Test
    public void Can_create_a_user() {

        final User user = mock(User.class);
        final User savedUser = mock(User.class);
        final Long id = someLong();

        // Given
        given(userRepository.save(user)).willReturn(savedUser);
        given(savedUser.getId()).willReturn(id);

        // When
        final String actual = controller.create(user);

        // Then
        assertThat(actual, equalTo("redirect:/user/" + id));
    }
}
