package example.spring.boot.page;

import example.spring.boot.page.finder.Finders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumUserRetrievePage implements UserRetrievePage {

    private final Finders finders;

    @Autowired
    public SeleniumUserRetrievePage(Finders finders) {
        this.finders = finders;
    }

    @Override
    public String getUsername() {
        return getTextByLabel("User Name");
    }

    @Override
    public String getPassword() {
        return getTextByLabel("Password");
    }

    private String getTextByLabel(String label) {
        return finders.findByLabel(label).getText();
    }
}
