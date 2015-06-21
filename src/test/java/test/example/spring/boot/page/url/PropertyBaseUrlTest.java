package test.example.spring.boot.page.url;

import example.spring.boot.page.url.BasePath;
import example.spring.boot.page.url.BasePort;
import example.spring.boot.page.url.PropertyBaseUrl;
import org.junit.Before;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class PropertyBaseUrlTest {

    private CharSequence url;
    private MockBasePort basePort;
    private MockBasePath basePath;

    private PropertyBaseUrl baseUrl;

    private String baseUrlString;

    @Before
    public void setUp() {
        url = someString();
        basePort = new MockBasePort(someString());
        basePath = new MockBasePath(someString());

        baseUrl = new PropertyBaseUrl(url, basePort, basePath);

        baseUrlString = format("%s:%s%s", url, basePort, basePath);
    }

    @Test
    public void Can_to_string() {

        // Given
        final MockBasePort basePort = new MockBasePort("");

        final String expected = format("%s%s", url, basePath);

        // When
        final String actual = new PropertyBaseUrl(url, basePort, basePath).toString();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_to_string_with_no_port() {

        // When
        final String actual = baseUrl.toString();

        // Then
        assertThat(actual, equalTo(baseUrlString));
    }

    @Test
    public void Can_get_length() {

        // Given
        final int expected = baseUrlString.length();

        // When
        final int actual = baseUrl.length();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_char_at_index() {

        final int length = baseUrlString.length();
        final int index = someIntegerBetween(0, length - 1);

        final char expected = baseUrlString.charAt(index);

        // Given

        // When
        final char actual = baseUrl.charAt(index);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_sub_sequence() {

        final int length = baseUrlString.length();
        final int start = someIntegerBetween(0, length - 1);
        final int end = someIntegerBetween(start, length);

        final CharSequence expected = baseUrlString.subSequence(start, end);

        // Given

        // When
        final CharSequence actual = baseUrl.subSequence(start, end);

        // Then
        assertThat(actual, equalTo(expected));
    }

    private static class MockBasePort extends MockCharSequence implements BasePort {

        private final String port;

        private MockBasePort(String port) {
            super(port);
            this.port = port;
        }

        @Override
        public String toString() {
            return port;
        }
    }

    private static class MockBasePath extends MockCharSequence implements BasePath {

        private final String path;

        private MockBasePath(String path) {
            super(path);
            this.path = path;
        }

        @Override
        public String toString() {
            return path;
        }
    }

    private static class MockCharSequence implements CharSequence {

        private final CharSequence charSequence;

        MockCharSequence(CharSequence charSequence) {
            this.charSequence = charSequence;
        }

        @Override
        public int length() {
            return charSequence.length();
        }

        @Override
        public char charAt(int index) {
            return charSequence.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return charSequence.subSequence(start, end);
        }
    }
}
