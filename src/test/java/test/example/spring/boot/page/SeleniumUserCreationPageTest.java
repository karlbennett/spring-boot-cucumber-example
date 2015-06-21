package test.example.spring.boot.page;

import example.spring.boot.page.SeleniumUserCreationPage;
import example.spring.boot.page.domain.User;
import example.spring.boot.page.finder.Finders;
import example.spring.boot.page.url.BaseUrl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class SeleniumUserCreationPageTest {

    private BaseUrl baseUrl;
    private WebDriver driver;

    private SeleniumUserCreationPage page;
    private Finders finders;

    @Before
    public void setUp() {
        baseUrl = mock(BaseUrl.class);
        driver = mock(WebDriver.class);
        finders = mock(Finders.class);

        page = new SeleniumUserCreationPage(baseUrl, driver, finders);
    }

    @Test
    public void Can_visit_the_user_creation_page() {

        final String baseUrlString = someString();

        // Given
        given(baseUrl.toString()).willReturn(baseUrlString);

        // When
        page.visit();

        // Then
        verify(driver).get(baseUrlString + "/user/create");
    }

    @Test
    public void Can_get_the_pages_title() {

        final String expected = someString();

        // Given
        given(driver.getTitle()).willReturn(expected);

        // When
        final String actual = page.getTitle();

        // Then
        assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void Can_create_a_user() {

        final User user = mock(User.class);

        final WebElement usernameInput = mock(WebElement.class);
        final WebElement passwordInput = mock(WebElement.class);
        final String username = someString();
        final String password = someString();

        // Given
        given(finders.findByLabel("User Name")).willReturn(usernameInput);
        given(finders.findByLabel("Password")).willReturn(passwordInput);
        given(user.getUsername()).willReturn(username);
        given(user.getPassword()).willReturn(password);

        // When
        page.create(user);

        // Then
        verify(usernameInput).sendKeys(username);
        verify(passwordInput).sendKeys(password);
    }
}
