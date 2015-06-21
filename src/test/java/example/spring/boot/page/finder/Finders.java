package example.spring.boot.page.finder;

import org.openqa.selenium.WebElement;

public interface Finders {

    WebElement findByLabel(String label);

    WebElement findByText(String tag, String text);

    WebElement findByValue(String value);
}
