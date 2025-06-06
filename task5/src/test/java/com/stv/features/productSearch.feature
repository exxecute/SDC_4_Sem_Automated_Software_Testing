Feature: Product Search and Filter

  Scenario Outline: User searches for a product and applies a filter
    Given the user is on the homepage
    When the user searches for "<searchTerm>" and click search button
    Then the product list should contain relevant items

    Examples:
      | searchTerm |
      | Bike       |