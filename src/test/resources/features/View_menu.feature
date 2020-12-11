Feature: View menu

  As a potential customer
  I want to be able to see all available meals.
  So that I can order the meals I want to eat.

# Personas
# Yarne - Student

  Scenario: Customer gets list of all meals

    Given all meals are on the menu
    When Yarne looks at the menu
    Then Yarne should see an overview of all meals

  Scenario: Customer gets a message to warn him that there are no meals

    Given there are no meals on the menu
    When Yarne looks at the emtpy menu
    Then Yarne should gets a message to warn him there are no meals on the me

  Scenario Outline: Customer gets the list of all meals and each meal has a price

    Given there are meals on the menu with given price
    When Yarne looks at the menu
    Then Yarne should see each "<Meal>" with its respective "<Price>"
    Examples:
    | Meal				        | Price		  |
    | Broodje kaas            	| 2.50        |
    | Spagheti bolongaise     	| 5.00        |
    | Kippensoep               	| 4.00        |

