package example.spring.boot.cucumber.steps;

import example.spring.boot.CucumberConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CucumberConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public abstract class SpringBootTestStep {
}
