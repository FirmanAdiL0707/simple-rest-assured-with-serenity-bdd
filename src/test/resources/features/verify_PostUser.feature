@regressionTest
Feature: Create User

Scenario: success create user
    When user send request for post user api
    Then the response status code is 201