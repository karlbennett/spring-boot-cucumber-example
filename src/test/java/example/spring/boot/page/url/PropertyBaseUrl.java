package example.spring.boot.page.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class PropertyBaseUrl implements BaseUrl {

    private final CharSequence url;
    private final BasePort basePort;
    private final BasePath basePath;

    @Autowired
    public PropertyBaseUrl(@Value("${base.url}") CharSequence url, BasePort basePort, BasePath basePath) {
        this.url = url;
        this.basePort = basePort;
        this.basePath = basePath;
    }

    private String baseUrl() {

        if ("".equals(basePort.toString())) {
            return format("%s%s", url, basePath);
        }

        return format("%s:%s%s", url, basePort, basePath);
    }

    @Override
    public int length() {
        return baseUrl().length();
    }

    @Override
    public char charAt(int index) {
        return baseUrl().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return baseUrl().subSequence(start, end);
    }

    @Override
    public String toString() {
        return baseUrl();
    }
}
