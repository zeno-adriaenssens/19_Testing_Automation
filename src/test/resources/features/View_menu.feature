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

    Given there are meals on the menu all the information
    When Yarne looks at the menu
    Then Yarne should see each "<Meal>" with its respective "<Price>"
    Examples:
    | Meal				        | Price		  |
    | Broodje kaas            	| 2.00        |
    | Spagheti bolongaise     	| 5.00        |
    | Kippensoep               	| 4.00        |

  Scenario: Customer sees an overview of meals sorted by type

    Given there are meals on the menu all the information
    When Yarne looks at the menu
    Then Yarne should see all the Meals grouped by their Type



  Scenario Outline: Customer gets the list of all meals and it’s specified if it is vegetarian and if it has allergens in it

    Given there are meals on the menu all the information
    When Yarne looks at the menu
    Then Yarne should see each "<Meal>" with information over the "<Description>" and if it is "<Vegetarian>"
    Examples:
    | Meal				        | Description               | Vegetarian	|
    | Niet-veggie Lasagne     	| Met vlees en extra kaas   | nee           |
    | Veggie lasagne           	| Vegetarisch zonder kaas   | ja		    |
    | Kip Wrap                	| Met kip en gluten         | nee           |
