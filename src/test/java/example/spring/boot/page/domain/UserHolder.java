package example.spring.boot.page.domain;

import example.spring.boot.Holder;
import org.springframework.stereotype.Component;

@Component
public class UserHolder implements Holder<User> {

    private User user;

    @Override
    public User get() {
        return user;
    }

    @Override
    public User set(User user) {
        return (this.user = user);
    }
}
