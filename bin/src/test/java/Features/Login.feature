Feature: LoginFeature
  This feature is responsible for testing all the scenarios
  Scenario: Check Login with  correct username and password
    And I ensure application opened
    Then I click login link
    When I enter Username and Password
    | UserName | Password |
    | Biswajit | Biswa@789|
    Then I click login button
    Then I should see username with hello

  Scenario: Check registration
    And I ensure logged off
    Then I click Registration Link
    When enter details
    Then I click RegisterButton
    Then I should get username with hello

