@smoketest
Feature: Echo feature

    This is a simple description of the *Echo* feature.

    @basic
    Scenario: 01 - Simple echo scenario

        Here is a brand new echo service

        Given The echo service is available
        When  I send the message "hello"
        Then  I expect to get the message "hello"

    @premium
    Scenario: 02 - Uppercase echo scenario

        The service returns an uppercase message

        Given The echo service is available
        When  I send the message "hello" with the "uppercase" option
        Then  I expect to get the message "HELLO"

    @basic
    Scenario: 03 - Lowercase echo scenario

        The service returns a lowercase message

        Given The echo service is available
        When  I send the message "hello" with the "lowercase" option
        Then  I expect to get the message "hello"

    @premium
    Scenario: 04 - Malformed scenario

        How does Cucumber react when a scenario is malformed ?

        Given The echo service is available
        When  I send the message "Hello" with the "uppercase" option
        Then  I expect to get the message "HELLo"

    @premium
    Scenario: 05 - Unknown echo scenario

        This scenario isn't fully implemented

        Given The echo service is available
        When  I send the message "Hello" with the upcoming option
        Then  I expect to get the message "HELLo"
