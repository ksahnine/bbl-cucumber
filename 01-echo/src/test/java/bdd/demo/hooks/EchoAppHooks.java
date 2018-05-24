package bdd.demo.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class EchoAppHooks {
    @Before()
    public void beforeTheScenarioCleanDataSet() {
        System.out.println("***** Clean data set ******");
    }

    @After("@gui")
    public void afterTheScenarioDoScreenshot(Scenario scenario) {
        System.out.printf("***** Screenshot. Name [%s] *****\n",
                          scenario.getName());
    }

}