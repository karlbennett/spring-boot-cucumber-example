package example.spring.boot.page.finder;

import example.spring.boot.page.by.Bys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumFinders implements Finders {

    private final WebDriver driver;
    private final Bys by;

    @Autowired
    public SeleniumFinders(WebDriver driver, Bys by) {
        this.driver = driver;
        this.by = by;
    }

    @Override
    public WebElement findByLabel(String label) {

        final String id = findByText("label", label).getAttribute("for");

        return driver.findElement(by.id(id));
    }

    @Override
    public WebElement findByText(String tag, String text) {
        return driver.findElement(by.text(tag, text));
    }

    @Override
    public WebElement findByValue(String value) {
        return driver.findElement(by.value(value));
    }
}
