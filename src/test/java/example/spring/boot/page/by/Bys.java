package example.spring.boot.page.by;

import org.openqa.selenium.By;

public interface Bys {

    By id(String id);

    By text(String tag, String text);

    By value(String value);
}
