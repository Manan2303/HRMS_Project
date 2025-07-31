Feature: Check Login Functionlity.

  Scenario: User Login successfully for valid credential
    Given User navigate the login page of the application
    When user enters username as "Admin" and password as "admin123"
    And the user clicks on the Login button
    Then the user should be redirected to Application Dashboard
