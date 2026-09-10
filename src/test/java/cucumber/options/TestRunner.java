package cucumber.options;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "json:target/jsonReports/cucumber.json",
                "html:target/cucumber-report.html"
        }
)
public class TestRunner {
}
