import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@Carrito",
        glue = "step",
        //plugin = {""},
        monochrome = true


)



public class TestRunner {
}
