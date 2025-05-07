# TASK1.3 Uladzislau Mikhayevich

1. Brute Force Protection

```
Feature: Brute Force Protection on Login Page

  Scenario: User account gets blocked after multiple failed login attempts
    Given the user is on the login page
    When the user enters incorrect credentials 5 times
    Then the login should be blocked or an additional security measure should be shown
    And a message should indicate suspicious activity or need for CAPTCHA
```

2. Session Management

```
Feature: Session Timeout Handling

  Scenario: User session expires after inactivity
    Given the user is logged into their account
    When the user remains inactive for 30 minutes
    Then the session should expire
    And the user should be redirected to the login page when trying to interact
```

3. Cross-Browser Compatibility

```
Feature: Cross-Browser Login Page Compatibility

  Scenario Outline: Login page functions across different browsers
    Given the user opens the login page in <browser>
    Then the login form should be displayed correctly
    And the login process should work without errors

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

  Scenario: Password input is masked
    Given the user is on the login page
    When the user types a password into the password field
    Then the characters should be hidden and shown as dots or asterisks
```

5. Correctness of redirects after login

```
Feature: Post-Login Redirection Handling

  Scenario: Login from an error page redirects to homepage
    Given the user is redirected to a 403 or 404 error page
    When the user logs in from that page
    Then the user should be redirected to the homepage
    And should not remain on the error page
```