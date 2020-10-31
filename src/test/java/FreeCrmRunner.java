import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features1",glue= {"com.bdd.steps"}
//,dryRun=true
//,tags="~@tag1"
)
public class FreeCrmRunner {

	
}
