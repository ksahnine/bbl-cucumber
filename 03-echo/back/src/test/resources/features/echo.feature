@echo
Feature: Echo feature

    This is a simple description of the echo feature.

    @smoketest @gui
    Scenario: 01 - Simple echo scenario

        The service returns the same message regardless the char case. 

        Given The echo service is available
        When  I send the message "hello"
        Then  I expect to get the case insensitive message "hello"

    @gui
    Scenario: 02 - Uppercase echo scenario

        The uppercase option of the service returns the message in all uppercase. 

        Given The echo service is available
        When  I send the message "hello" with the "uppercase" option
        Then  I expect to get the message "HELLO"

    @gui
    Scenario Outline: Echo

        Echo in many ways.
        
        Given The echo service is available
        When  I send the message <message> with the <option> option
        Then  I expect to get the message <echoed>

        Examples:
          |  message     | option       |  echoed     |
          | "Bienvenue"  | "strict"     | "Bienvenue" |
          | "Bienvenue"  | "uppercase"  | "BIENVENUE" |
          | "Bienvenue"  | "lowercase"  | "bienvenue" |
          | "Bienvenue"  | "uppercase"  | "bienvenue" |
