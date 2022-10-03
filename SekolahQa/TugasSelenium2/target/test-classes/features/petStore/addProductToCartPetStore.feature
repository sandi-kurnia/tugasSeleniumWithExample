Feature: Add Product to Cart

  Scenario Outline: Add product to cart without sign in
    Given User at catalog page jPetStore
      And User click fish product menu
    Then Direct user to product of fish page
      And User can view some of product fish by species
      And User click fish products By Id
    Then Direct user to species of fish page by id
      And User click add to cart button
    Then Direct user to shopping cart page
      And user view shopping cart page
      And user input fish quantity "<qty>"
      And user click update cart button
      And user click cart button
    Then User can see product that have been added

    Examples:
    |qty|
    |10|



