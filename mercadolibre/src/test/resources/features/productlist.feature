Feature: Search and filter products on the website

  Scenario: Search for Product and apply filters
    Given the user opens the website
    And selects "México" as the country
    When the user searches for "playstation 5"
    And filters by condition "Nuevo"
    And filters by location "Local"
    And orders results from "mayor a menor precio"
    Then the user gets the name and price of the first 5 products
    And prints the product details in the console