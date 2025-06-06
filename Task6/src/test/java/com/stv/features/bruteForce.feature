Feature: Brute Force Protection on Login Page

  Scenario: User account gets blocked after multiple failed login attempts
    Given the user is on the login page
    When the user enters new emails several times
    Then the login should be blocked or an additional security measure should be presented