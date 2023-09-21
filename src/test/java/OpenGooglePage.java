import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OpenGooglePage {
      private static  WebDriver driver;
      private static  String nodeUrl;



    @Parameters({"browserName","Url"})
    @BeforeTest
    public void setDriver(@Optional String browserName ,@Optional String Url) throws MalformedURLException {
        nodeUrl=Url;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserName.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
        }else if (browserName.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.WIN10);
        }

        driver = new RemoteWebDriver(new URL(nodeUrl),capabilities);
        System.out.println("thread: "+ Thread.currentThread().getId());


    }

    @Test
    public void  Homepagecheck() {

        driver.manage().deleteAllCookies();
        driver.manage().window().minimize();
        driver.get("https://rahulshettyacademy.com/");
    }


    @AfterTest
    public void close(){

        driver.close();
    }


    }
