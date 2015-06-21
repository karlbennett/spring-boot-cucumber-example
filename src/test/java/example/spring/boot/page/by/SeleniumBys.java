package example.spring.boot.page.by;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class SeleniumBys implements Bys {

    @Override
    public By id(String id) {
        return By.id(id);
    }

    @Override
    public By text(String tag, String text) {
        return By.xpath(format("//%s[contains(text(),'%s')]", tag, text));
    }

    @Override
    public By value(String value) {
        return By.xpath(format("//input[@value='%s']", value));
    }
}
