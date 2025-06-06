Feature: Navigation and page interaction on Wiggle main page

  Scenario: User navigates through pages and verifies content and state
    Given the user is on the main page
    When the user clicks on Available Now
    Then a different page should open
    And the page should contain the dhb section
    And pagination controls should be visible

    When the user clicks the next page arrow
    Then the page should scroll to the top

    When the user returns to the main page
    Then the main page should be at the bottom

    When the user clicks on Carriers
    Then a new page should open

    When the user clicks the browser's back button
    Then the main page should be displayed
    And the Carriers section should be in focus

    When the user clicks the Wiggle logo at the bottom
    Then the main page should be displayed at header