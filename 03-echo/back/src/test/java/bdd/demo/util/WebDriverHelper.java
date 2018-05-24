package bdd.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if ( driver == null ) { 
            System.setProperty("webdriver.chrome.driver", 
                               "/home/ksahnine/tools/selenium/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void close() {
        driver.close();
        driver = null;
    }

}
