import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import util.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/feature",
        glue = "stepDefinition",
        plugin = {"pretty", "json:target/cucumber.json"},
        monochrome = true
)

public class TestRunner
{
    static Driver driverInstance = Driver.getInstance();
    static WebDriver driver = driverInstance.getDriver();

    @BeforeClass
    public static void setup(){driver.get("https://www.google.com/");}

    @AfterClass
    public static void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
