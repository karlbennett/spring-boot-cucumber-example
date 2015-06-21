package example.spring.boot.page.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyBasePath implements BasePath {

    private final CharSequence path;

    @Autowired
    public PropertyBasePath(@Value("${base.path}") CharSequence path) {
        this.path = path;
    }

    @Override
    public int length() {
        return path.length();
    }

    @Override
    public char charAt(int index) {
        return path.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return path.subSequence(start, end);
    }

    @Override
    public String toString() {
        return path.toString();
    }
}

