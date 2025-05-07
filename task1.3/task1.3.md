# TASK1.3 Uladzislau Mikhayevich

1. Brute Force Protection

```
Feature: Brute Force Protection on Login Page

  Scenario: User account gets blocked after multiple failed login attempts
    Given the user is on the login page
    When the user enters incorrect credentials several times
    Then the login should be blocked or an additional security measure should be presented
    And a message should indicate the need for further action or verification
```

2. Session Management

```
Feature: Session Timeout Handling

  Scenario: User session expires after a period of inactivity
    Given the user is logged into their account
    When the user remains inactive for a defined period
    Then the session should expire
    And the user should be redirected to the login page upon subsequent interaction
```

3. Cross-Browser Compatibility

```
Feature: Cross-Browser Login Page Compatibility

  Scenario Outline: Login page functions correctly across different browsers
    Given the user opens the login page in a specific browser
    Then the login form should be displayed as expected
    And the login process should function correctly

    Examples:
      | browser   |
      | Chrome    |
      | Firefox   |
      | Safari    |
      | Edge      |
```

4. Password field security

```
Feature: Password Field Masking

  Scenario: Password input is visually masked
    Given the user is on the login page
    When the user types a password into the password field
    Then the entered characters should be obscured
```

5. Correctness of redirects after login

```
Feature: Post-Login Redirection Handling

  Scenario: Successful login from an error page redirects to the intended destination
    Given the user is on an error page
    When the user successfully logs in from that page
    Then the user should be redirected to the main application page
    And should not remain on the error page
```