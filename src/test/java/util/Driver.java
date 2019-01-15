package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver
{
    Wait wait = new Wait();
    Config config = new Config();

    String browser = System.getProperty("browser", config.properties("browser"));

    private WebDriver driver;

    private static final Driver instance = new Driver();

    private Driver() {this.driver = setDriver();}

    public static Driver getInstance() {return instance;}

    WebDriver setDriver()
    {
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized", "--disable-extensions");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(wait.implicitWaitTime, TimeUnit.SECONDS);
            return driver;
        }
        else
        {
            return null;
        }
    }

    public WebDriver getDriver() {return this.driver;}
}
