@add-product
Feature: Add Product

  Background:
    Given User open Webview

  @product-01
  Scenario: Add product
    When user click by text "Allow"
    And user click "locationOpen" button in "Home" page
    When user click "dropdownLocation" button in "Home" page
    And user click "chooseLocation" button in "Home" page
    And User scroll by element "scrollProduct" in "Home" page
    And user click "addProduct" button in "Home" page
    And user get value price quantity from fill "priceProduct" in "Home" page
    And user click "addQuantity" button in "Home" page
    Then user verify value price quantity from fill "totalPrice" in "Home" page
    And user click "addToCart" button in "Home" page
    And User can wait loading application for "3" seconds
    And user get value price quantity from fill "priceDetail" in "Cart" page
    And user click "removeQty" button in "Cart" page
    Then user verify value price quantity after remove from fill "totalPrice" in "Home" page
    And user click "cardProduct" button in "Cart" page
    Then user able to see "Tambah ke Keranjang" data verification

