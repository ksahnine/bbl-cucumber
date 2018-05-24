package bdd.demo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( format={"pretty"}, features="classpath:features", glue={"bdd.demo.steps"})
public class AppRunnerTest {

}
