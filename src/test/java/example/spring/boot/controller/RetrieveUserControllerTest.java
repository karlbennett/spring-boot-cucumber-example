package example.spring.boot.controller;

import example.spring.boot.data.UserRepository;
import example.spring.boot.domain.User;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class RetrieveUserControllerTest {

    @Test
    public void Can_retrieve_a_user() {

        final UserRepository userRepository = mock(UserRepository.class);

        final Long id = someLong();
        final User user = mock(User.class);

        // Given
        given(userRepository.findOne(id)).willReturn(user);

        // When
        final ModelAndView actual = new RetrieveUserController(userRepository).retrieve(id);

        // Then
        assertThat(actual.getViewName(), equalTo("retrieveUser"));
        assertThat((User) actual.getModel().get("user"), equalTo(user));
    }
}
