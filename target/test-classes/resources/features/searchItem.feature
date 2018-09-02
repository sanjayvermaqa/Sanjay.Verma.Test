Feature: searchItem
  This is the feature file for searcing an item on website

  Scenario: search for an item
    Given Website is loaded successfully
    When Click on item
    Then Item Detail Page should be displayed
    Then Add to Cart
    Then Review Cart