package example.spring.boot.page;

import example.spring.boot.page.domain.User;

public interface UserCreationPage {

    UserCreationPage visit();

    String getTitle();

    void create(User user);
}
