Feature: Search in the website
  Scenario Outline: Search Product
    Given Navigate to website
    When Open the website close popup
    Then Search "<product>" and click search

    Examples:
    |product|
    |ipad|
    |imac|
    |airpod|

