package example.spring.boot.page.url;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextAwareBasePort implements BasePort, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {

        final String port = applicationContext.getEnvironment().getProperty("local.server.port");

        if (port != null) {
            return port;
        }

        return "";
    }
}
