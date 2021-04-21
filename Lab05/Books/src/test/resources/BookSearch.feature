Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
  Background: A Library
    Given An open Library
    And a book with the title 'One good book', written by 'Anonymous', published in 2013/03/14
    And a book with the title 'Some other book', written by 'Tim Thomson', published in 2014/8/23
    And a book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 2012/01/01


  Scenario Outline: Search books by publication year
    When the customer searches for books published between 2013 and 2014
    Then 2 books should have been found
    And Book 1 should have the title 'Some other book'
    And Book 2 should have the title 'One good book'

    Examples: Single digits
      | a | b | c  |
      | 1 | 2 | 3  |
      | 3 | 7 | 10 |