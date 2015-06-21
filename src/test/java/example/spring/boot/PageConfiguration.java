package example.spring.boot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;

@Configuration
@ComponentScan
public class PageConfiguration {

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(@Value("${web.driver:htmlunit}") String webDriver) {

        if ("htmlunit".equals(webDriver)) {
            return new HtmlUnitDriver();
        }

        if ("chrome".equals(webDriver)) {
            return new ChromeDriver();
        }

        if ("firefox".equals(webDriver)) {
            return new FirefoxDriver();
        }

        if ("ie".equals(webDriver)) {
            return new InternetExplorerDriver();
        }

        if ("safari".equals(webDriver)) {
            return new SafariDriver();
        }

        if ("opera".equals(webDriver)) {
            return new OperaDriver();
        }

        throw new IllegalArgumentException(format("Web driver %s not supported.", webDriver));
    }
}
