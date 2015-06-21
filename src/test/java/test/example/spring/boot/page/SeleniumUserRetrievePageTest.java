package test.example.spring.boot.page;

import example.spring.boot.page.SeleniumUserRetrievePage;
import example.spring.boot.page.finder.Finders;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class SeleniumUserRetrievePageTest {

    private Finders finders;
    private SeleniumUserRetrievePage retrievePage;

    @Before
    public void setUp() {
        finders = mock(Finders.class);
        retrievePage = new SeleniumUserRetrievePage(finders);
    }

    @Test
    public void Can_get_the_username() {

        final WebElement usernameSpan = mock(WebElement.class);

        final String expected = someString();

        // Given
        given(finders.findByLabel("User Name")).willReturn(usernameSpan);
        given(usernameSpan.getText()).willReturn(expected);

        // When
        final String actual = retrievePage.getUsername();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_get_the_password() {

        final WebElement passwordSpan = mock(WebElement.class);

        final String expected = someString();

        // Given
        given(finders.findByLabel("Password")).willReturn(passwordSpan);
        given(passwordSpan.getText()).willReturn(expected);

        // When
        final String actual = retrievePage.getPassword();

        // Then
        assertThat(actual, equalTo(expected));
    }
}
