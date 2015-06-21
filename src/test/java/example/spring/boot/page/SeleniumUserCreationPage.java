package example.spring.boot.page;

import example.spring.boot.page.domain.User;
import example.spring.boot.page.finder.Finders;
import example.spring.boot.page.url.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumUserCreationPage implements UserCreationPage {

    private final BaseUrl baseUrl;
    private final WebDriver driver;
    private final Finders finders;

    @Autowired
    public SeleniumUserCreationPage(BaseUrl baseUrl, WebDriver driver, Finders finders) {
        this.baseUrl = baseUrl;
        this.driver = driver;
        this.finders = finders;
    }

    @Override
    public SeleniumUserCreationPage visit() {
        driver.get(baseUrl + "/user/create");
        return this;
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public void create(User user) {
        finders.findByLabel("User Name").sendKeys(user.getUsername());
        finders.findByLabel("Password").sendKeys(user.getPassword());
        finders.findByValue("Create").click();
    }
}
