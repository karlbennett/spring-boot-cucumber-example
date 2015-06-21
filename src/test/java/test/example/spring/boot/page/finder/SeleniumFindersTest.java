package test.example.spring.boot.page.finder;

import example.spring.boot.page.by.Bys;
import example.spring.boot.page.finder.SeleniumFinders;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class SeleniumFindersTest {

    private WebDriver driver;
    private Bys by;
    private SeleniumFinders finders;

    @Before
    public void setUp() {
        driver = mock(WebDriver.class);
        by = mock(Bys.class);

        finders = new SeleniumFinders(driver, by);
    }

    @Test
    public void Can_find_an_element_by_its_tag_and_text() {

        final String tag = someString();
        final String text = someString();
        final By byTagAndText = mock(By.class);

        final WebElement expected = mock(WebElement.class);

        // Given
        given(by.text(tag, text)).willReturn(byTagAndText);
        given(driver.findElement(byTagAndText)).willReturn(expected);

        // When
        final WebElement actual = finders.findByText(tag, text);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_find_an_element_by_its_label() {

        final String labelName = someString();
        final By byText = mock(By.class);
        final WebElement label = mock(WebElement.class);
        final String id = someString();
        final By byId = mock(By.class);

        final WebElement expected = mock(WebElement.class);

        // Given
        given(by.text("label", labelName)).willReturn(byText);
        given(driver.findElement(byText)).willReturn(label);
        given(label.getAttribute("for")).willReturn(id);
        given(by.id(id)).willReturn(byId);
        given(driver.findElement(byId)).willReturn(expected);

        // When
        final WebElement actual = finders.findByLabel(labelName);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_find_an_element_by_its_value() {

        final String value = someString();
        final By byValue = mock(By.class);

        final WebElement expected = mock(WebElement.class);

        // Given
        given(by.value(value)).willReturn(byValue);
        given(driver.findElement(byValue)).willReturn(expected);

        // When
        final WebElement actual = finders.findByValue(value);

        // Then
        assertThat(actual, equalTo(expected));
    }
}
