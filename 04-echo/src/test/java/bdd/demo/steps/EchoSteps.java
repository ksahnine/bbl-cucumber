package bdd.demo.steps;

import org.junit.Assert;

import bdd.demo.domain.Message;
import bdd.demo.services.EchoService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EchoSteps {
    private EchoService echo;
    private Message message;

    @Given("^The echo service is available$")
    public void the_echo_service_is_available() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this.echo = new EchoService();
    }
    
    @When("^I send the message \"([^\"]*)\"$")
    public void i_send_the_message(String arg1) throws Exception {
        // Write code here that turns the: phrase above into concrete actions
        this.message = echo.strict(arg1);
    }
    
    @Then("^I expect to get the message \"([^\"]*)\"$")
    public void i_expect_to_get_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Erreur", arg1, this.message.getContent());
    }

    @When("^I send the message \"([^\"]*)\" with the \"([^\"]*)\" option$")
    public void i_send_the_message_with_the_option(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        switch(arg2) {
            case "uppercase":
                this.message = echo.uppercase(arg1);
                break;
            case "lowercase":
                this.message = echo.lowercase(arg1);
                break;
            default:
                this.message = echo.strict(arg1);
                break;
        }
    }
}
