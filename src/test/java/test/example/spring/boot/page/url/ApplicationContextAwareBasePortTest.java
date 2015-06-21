package test.example.spring.boot.page.url;

import example.spring.boot.page.url.ApplicationContextAwareBasePort;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class ApplicationContextAwareBasePortTest {

    private ApplicationContext applicationContext;
    private ApplicationContextAwareBasePort basePort;

    @Before
    public void setUp() {
        applicationContext = mock(ApplicationContext.class);
        basePort = new ApplicationContextAwareBasePort();
        basePort.setApplicationContext(applicationContext);

    }

    @Test
    public void Can_to_string() {

        final Environment environment = mock(Environment.class);

        final String expected = someString();

        // Given
        given(applicationContext.getEnvironment()).willReturn(environment);
        given(environment.getProperty("local.server.port")).willReturn(expected);

        // When
        final String actual = basePort.toString();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_to_string_to_empty_string_if_local_server_port_is_not_set() {

        final Environment environment = mock(Environment.class);

        // Given
        given(applicationContext.getEnvironment()).willReturn(environment);
        given(environment.getProperty("local.server.port")).willReturn(null);

        // When
        final String actual = basePort.toString();

        // Then
        assertThat(actual, isEmptyString());
    }

    @Test
    public void Can_get_length() {

        final Environment environment = mock(Environment.class);
        final String port = someString();

        final int expected = port.length();

        // Given
        given(applicationContext.getEnvironment()).willReturn(environment);
        given(environment.getProperty("local.server.port")).willReturn(port);

        // When
        final int actual = basePort.length();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_char_at_index() {

        final Environment environment = mock(Environment.class);
        final String port = someString();
        final int index = someIntegerBetween(0, port.length() - 1);

        final char expected = port.charAt(index);

        // Given
        given(applicationContext.getEnvironment()).willReturn(environment);
        given(environment.getProperty("local.server.port")).willReturn(port);

        // When
        final char actual = basePort.charAt(index);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_sub_sequence() {

        final Environment environment = mock(Environment.class);
        final String port = someString();
        final int start = someIntegerBetween(0, port.length() - 1);
        final int end = someIntegerBetween(start, port.length());

        final CharSequence expected = port.subSequence(start, end);

        // Given
        given(applicationContext.getEnvironment()).willReturn(environment);
        given(environment.getProperty("local.server.port")).willReturn(port);

        // When
        final CharSequence actual = basePort.subSequence(start, end);

        // Then
        assertThat(actual, equalTo(expected));
    }
}
