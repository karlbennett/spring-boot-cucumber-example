package example.spring.boot.page.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static shiver.me.timbers.data.random.RandomStrings.buildSomeString;

@Component
public class DefaultUserFactory implements UserFactory {

    private final UserHolder userHolder;

    @Autowired
    public DefaultUserFactory(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Override
    public User randomUser() {
        return userHolder.set(new User(randomString(), randomString()));
    }

    @Override
    public User currentUser() {
        return userHolder.get();
    }

    private String randomString() {
        return buildSomeString().thatContainsAlphanumericCharacters().withLengthBetween(1, 20).build();
    }
}
