package example.spring.boot.page.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static shiver.me.timbers.data.random.RandomStrings.someString;

@Component
public class DefaultUserFactory implements UserFactory {

    private final UserHolder userHolder;

    @Autowired
    public DefaultUserFactory(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Override
    public User randomUser() {
        return userHolder.set(new User(someString(), someString()));
    }

    @Override
    public User currentUser() {
        return userHolder.get();
    }
}
