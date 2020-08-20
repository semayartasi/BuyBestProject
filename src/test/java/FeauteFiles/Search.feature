Feature: Search in the website
  Scenario: Search Product
    Given Navigate to website
    When Open the website close popup
    When I search for products I expect number of results to be:
      |product|results|
      |imac 27"|7|
      |ipad air 256gb|6|
      |apple watch 5 protector|16|
      |pastel case apple ipod|1|


