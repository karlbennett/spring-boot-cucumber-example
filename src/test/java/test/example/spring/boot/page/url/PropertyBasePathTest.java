package test.example.spring.boot.page.url;

import example.spring.boot.page.url.PropertyBasePath;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class PropertyBasePathTest {

    private String path;
    private PropertyBasePath basePath;

    @Before
    public void setUp() {
        path = someString();
        basePath = new PropertyBasePath(path);
    }

    @Test
    public void Can_to_string() {

        // When
        final String actual = basePath.toString();

        // Then
        assertThat(actual, equalTo(path));
    }

    @Test
    public void Can_get_length() {

        // Given
        final int expected = path.length();

        // When
        final int actual = basePath.length();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_char_at_index() {

        // Given
        final int index = someIntegerBetween(0, path.length() - 1);
        final char expected = path.charAt(index);

        // When
        final char actual = basePath.charAt(index);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_sub_sequence() {


        // Given
        final int start = someIntegerBetween(0, path.length() - 1);
        final int end = someIntegerBetween(start, path.length());
        final CharSequence expected = path.subSequence(start, end);

        // When
        final CharSequence actual = basePath.subSequence(start, end);

        // Then
        assertThat(actual, equalTo(expected));
    }
}
