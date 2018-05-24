package bdd.demo.steps;

import org.junit.Assert;

import bdd.demo.domain.Message;
import bdd.demo.services.EchoService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EchoSteps {
    private EchoService service;
    private Message message;

    @Given("^The echo service is available$")
    public void the_echo_service_is_available() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this.service = new EchoService();
    }
    
    @When("^I send the message \"([^\"]*)\"$")
    public void i_send_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this.message = service.strict(arg1);
    }
    
    @Then("^I expect to get the message \"([^\"]*)\"$")
    public void i_expect_to_get_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Erreur", arg1.toLowerCase(), this.message.getContent().toLowerCase());
    }

    @When("^I send the message \"([^\"]*)\" with the uppercase option$")
    public void i_send_the_message_with_the_uppercase_option(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this.message = service.uppercase(arg1);
    }
    
}