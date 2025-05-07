# TASK1.1 Uladzislau Mikhayevich

1. Brute Force Protection
  - Check to see if the account is locked out after several failed login attempts.
  - Verify that a CAPTCHA or other security mechanism appears after several failed attempts.

2. Session Management
  - Check whether the user session is terminated after a certain period of inactivity (e.g. 15-30 minutes).

3. Cross-Browser Compatibility
  - Test that the login works in different browsers (Chrome, Firefox, Safari, Edge).
  - Make sure that the page works correctly on mobile devices and different screen sizes.

4. Password field security
  - Ensure that the password entry is hidden (replaced by characters).

5. Correctness of redirects after login
  - Make sure that after logging in from an error page (e.g., 403 or 404), the user is redirected to the main page and does not stay on the error page.