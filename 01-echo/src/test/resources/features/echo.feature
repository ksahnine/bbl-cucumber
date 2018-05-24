Feature: Echo feature

    This is a simple description of the echo feature.

    Scenario: 01 - Simple echo scenario

        The service aims to echo a given message

        Given The echo service is available
        When  I send the message "Hello"
        Then  I expect to get the message "hello"
    
    @gui
    Scenario: 02 - Uppercase echo scenario

        The service aims to echo a given message

        Given The echo service is available
        When  I send the message "Hello" with the uppercase option
        Then  I expect to get the message "HELLO"
