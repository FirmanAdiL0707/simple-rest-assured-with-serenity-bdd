@regressionTest
Feature: Get User

Scenario: success get user
    When user send request for get user api
    Then the response status code is 200