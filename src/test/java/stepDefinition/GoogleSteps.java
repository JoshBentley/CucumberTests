package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Driver;
import util.Wait;


public class GoogleSteps
{
    Driver instance = Driver.getInstance();
    WebDriver driver = instance.getDriver();
    Wait wait = new Wait();

    @Given("^a user is on the google home page$")
    public void aUserIsOnTheGoogleHomePage() {
        assert driver.getTitle().equals("Google");
    }

    @When("^a user searches for \"([^\"]*)\"$")
    public void aUserSearchesFor(String query) {
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchBar.sendKeys(query + Keys.ENTER);
    }

    @Then("^a user should see pictures of dogs$")
    public void aUserShouldSeePicturesOfDogs() {
        WebElement searchResultText = driver.findElement(By.xpath("//*[@id=\"imagebox_bigimages\"]/g-section-with-header/div[1]/h3/a"));
        assert searchResultText.getText().equals("Images for comrade doggo");
        wait.waitFor(5); // sleep so you can bask in supreme glory
    }
}
