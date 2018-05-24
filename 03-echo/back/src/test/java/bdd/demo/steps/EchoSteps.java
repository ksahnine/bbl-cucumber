package bdd.demo.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bdd.demo.util.WebDriverHelper;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EchoSteps {
    private WebDriver driver;
    private WebElement response;

    @Before
    public void init() {
        driver = WebDriverHelper.getDriver();
    } 

    @Given("^The echo service is available$")
    public void the_echo_service_is_available() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost"); 
    }
    
    @When("^I send the message \"([^\"]*)\"$")
    public void i_send_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        echo(arg1, "strict");
    }
    
    @Then("^I expect to get the message \"([^\"]*)\"$")
    public void i_expect_to_get_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Contenu non identique", 
                            arg1, 
                            this.response.getText());
    }

    @Then("^I expect to get the case insensitive message \"([^\"]*)\"$")
    public void i_expect_to_get_the_case_insensitive_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Contenu non identique", 
                            arg1.toLowerCase(), 
                            this.response.getText());
    }

    @When("^I send the message \"([^\"]*)\" with the \"([^\"]*)\" option$")
    public void i_send_the_message_with_the_option(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        switch(arg2) {
            case "uppercase":
                echo(arg1, arg2);
                break;
            case "lowercase":
                echo(arg1, arg2);
                break;
            default:
                echo(arg1, "strict");
                break;
        }
    }

    private void echo(String msg, String type) {
        driver.findElement(By.name("message")).sendKeys(msg);
        driver.findElement(By.name(type)).click();
        driver.findElement(By.name("sendBtn")).click();
        this.response = new WebDriverWait(driver, 100).until(
            ExpectedConditions.elementToBeClickable(
                By.name("response")
            )
        );
    }
}