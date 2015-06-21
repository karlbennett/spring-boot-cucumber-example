package example.spring.boot.page.by;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class SeleniumBys implements Bys {

    @Override
    public By id(String id) {
        return By.id(id);
    }

    @Override
    public By text(String tag, String text) {
        return By.xpath(String.format("//%s[contains(text(),'%s')]", tag, text));
    }
}
