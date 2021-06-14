Feature: Smoke
  As a user
  User want to test all main site functionality
  So that user can be sure that site works correctly

  Scenario: Check that there no account with such email
    Given User opens 'https://www.amazon.com/' page
    And User checks right header visibility
    And User checks account button visibility
    When User clicks account button
    And User checks sign in field visibility
    And User enters email 'oleg140293@gmail.com' to email input field
    And User clicks continue button
    Then User checks 'We cannot find an account with that email address'

  Scenario: Check that current url contains such language
    Given User opens 'https://www.amazon.com/' page
    And User checks right header visibility
    And User checks language menu icon visibility
    When User clicks on language menu icon
    And User checks radio button visibility
    And User clicks on german radio button
    And User checks save changes button
    And User clicks on save changes button
    Then User checks that current url contains 'de_DE' language

  Scenario: Check that url changes when user goes to different pages
    Given User opens 'https://www.amazon.com/' page
    And User checks navigation footer line visibility
    When User clicks some link
    Then User checks page url equals 'https://www.comixology.com/'

  Scenario: Check that all shirts in category under 30$
    Given User opens 'https://www.amazon.com/' page
    And User checks men`s shirts category visibility
    When User clicks shop now
    And User checks shirts product visibility
    Then User checks that all shirts prices under 30

  Scenario: Check add product to cart
    Given User opens 'https://www.amazon.com/' page
    And User checks search field visibility
    When User makes search by keyword 'iPhone 11'
    And User checks search button visibility
    And User clicks search button
    And User clicks wish list on first product
    And User checks add to cart button visibility
    And User clicks add to cart button
    Then User checks that amount of products in cart is '1'

  Scenario: Check remove product from cart
    Given User opens 'https://www.amazon.com/' page
    And User checks search field visibility
    When User makes search by keyword 'iPhone 11'
    And User checks search button visibility
    And User clicks search button
    And User clicks wish list on first product
    And User checks add to cart button visibility
    And User clicks add to cart button
    When User checks that amount of products in cart is '1'
    And User click cart button
    And User checks product visibility in cart page
    And User clicks delete button
    Then User checks that amount of products in cart is '0'

  Scenario: Check product category functions
    Given User opens 'https://www.amazon.com/' page
    And User checks gaming accessories category visibility
    When User clicks see more
    And User checks gaming accessories category groups visibility
    Then User checks 15 groups in gaming accessories category

  Scenario: Check that current url contains category group title
    Given User opens 'https://www.amazon.com/' page
    And User checks gaming accessories category visibility
    When User clicks see more
    And User checks gaming accessories category groups visibility
    And User clicks on first group
    Then User checks that current url contains 'nintendo'

  Scenario: Check that all products contains category group title in title of product
    Given User opens 'https://www.amazon.com/' page
    And User checks gaming accessories category visibility
    When User clicks see more
    And User checks gaming accessories category groups visibility
    And User clicks on Playstation group
    And User checks Playstation products visibility
    Then User checks that all products contains 'playstation' or 'ps'

  Scenario: Check that filters works correctly
    Given User opens 'https://www.amazon.com/' page
    And User checks search field visibility
    When User makes search by keyword 'marshall headphones'
    And User checks search button visibility
    And User clicks search button
    And User checks filter by price visibility
    And User enters min price '125' and max price '150'
    When User clicks go button
    And User checks filters by brand visibility
    When User clicks first brand
    And User checks that all headphones contains 'marshall'
    Then User checks that product prices in the price range from 125 to 150