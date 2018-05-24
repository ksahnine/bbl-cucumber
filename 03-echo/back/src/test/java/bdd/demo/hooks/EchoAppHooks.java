package bdd.demo.hooks;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import bdd.demo.util.WebDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class EchoAppHooks {
    @Before()
    public void beforeTheScenarioCleanDataSet() {
        System.out.println("***** Clean data set ******");
    }

    @Before()
    public void beforeTheScenarioInitData() {
        System.out.println("***** Init data ******");
    }

    @After("@gui")
    public void afterTheScenario(Scenario scenario) throws Exception {
        // If a scenario fails :
        //  - take a screenshot
        if ( scenario.isFailed() ) { 
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-ss").format(new Date());
            String screenFileName = "/tmp/screenshot_" + timestamp + ".png"; 
            final byte[] screenshot = ((TakesScreenshot) WebDriverHelper.getDriver()).getScreenshotAs(OutputType.BYTES);

            Files.write(
                Paths.get(screenFileName), 
                screenshot
            );
            System.out.println("**** Check out the screenshot *** " + screenFileName);
        }
        
        // Close the browser
        WebDriverHelper.close();
    }

}