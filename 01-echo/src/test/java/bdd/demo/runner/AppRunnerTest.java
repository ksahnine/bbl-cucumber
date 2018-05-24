package bdd.demo.runner;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( format={"pretty"}, 
                  features="classpath:features", 
                  glue={"bdd.demo.steps", "bdd.demo.hooks"}, 
                  tags={"@gui"} )
public class AppRunnerTest {

}
