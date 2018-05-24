package bdd.demo.steps;

import org.junit.Assert;

import bdd.demo.domain.Message;
import bdd.demo.services.EchoService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class EchoSteps {
    private Message message = null;
    private RequestSpecification echo = null;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/echo";
    }

    @Given("^The echo service is available$")
    public void the_echo_service_is_available() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this.echo = RestAssured.given().log().all();
        this.echo.get("ping").then().statusCode(200);
    }
    
    @When("^I send the message \"([^\"]*)\"$")
    public void i_send_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        message = echo.get("strict/"+arg1).as(Message.class);
    }
    
    @Then("^I expect to get the message \"([^\"]*)\"$")
    public void i_expect_to_get_the_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Contenu non identique", arg1, this.message.getContent());
    }

    @Then("^I expect to get the case insensitive message \"([^\"]*)\"$")
    public void i_expect_to_get_the_case_insensitive_message(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Contenu non identique", arg1.toLowerCase(), this.message.getContent().toLowerCase());
    }

    @When("^I send the message \"([^\"]*)\" with the \"([^\"]*)\" option$")
    public void i_send_the_message_with_the_option(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        switch(arg2) {
            case "uppercase":
                this.message = echo.get("uppercase/"+arg1).as(Message.class);
                break;
            case "lowercase":
                this.message = echo.get("lowercase/"+arg1).as(Message.class);
                break;
            default:
                this.message = echo.get("strict/"+arg1).as(Message.class);
                break;
        }
    }

}