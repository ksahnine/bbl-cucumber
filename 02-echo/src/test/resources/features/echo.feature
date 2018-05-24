@echo
Feature: Echo feature

    This is a simple description of the echo feature.

    @smoketest
    Scenario: 01 - Echo scenario

        This is a simple description of the echo scenario. 

        Given The echo service is available
        When  I send the message "hello"
        Then  I expect to get the case insensitive message "hello"

    @gui
    Scenario: 02 - Uppercase echo scenario

        This is a simple description of the echo scenario. 

        Given The echo service is available
        When  I send the message "hello" with the "uppercase" option
        Then  I expect to get the message "HELLO"

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
