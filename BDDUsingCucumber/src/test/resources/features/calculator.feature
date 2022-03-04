@tag
Feature: Calcaulator application

Background:To launch the chrome browser
Given Browser is open

@UITest
Scenario Outline: Calculator UI Test number button
Given Calculator page is open
Then Calcaultor has number '<number>'

Examples:
|number|
|0|
|1|
|2|
|3|
|4|
|5|
|6|
|7|
|8|
|9|

@UITest
Scenario Outline: Calculator UI Test opearotors
Given Calculator page is open
Then Calcaultor has operator '<operator>'
Examples:
|operator|
|+ |
|- |
|* |
|/ |
|= |



@UITest
Scenario: Calculator UI Test Display screen
Given Calculator page is open
Then Calcaultor has display field



@UITest
Scenario Outline: Calculator UI Test Button color
Given Calculator page is open
Then Calcaultor '<button>' has color '<color>'
Examples:
|button| color |
|2 | black |
|5 | black |
|* | blue |
|/ | blue |
|= | red |


@Functional
Scenario Outline: Calculator number should come on display screen
Given Calculator page is open
And number button is clicked '<number>'
Then display screen should have number '<number>'



Examples:
|number|
|0 |
|1 |
|2 |
|3 |
|4 |
|5 |
|6 |
|7 |
|8 |
|9 |



@Functional
Scenario Outline: Calculator Add functionality
Given Calculator page is open
And number button is clicked '<number>'
And Operator button is clicked '<operator>'
And number button is clicked '<number2>'
And Operator button is clicked '<operator2>'
Then display screen should have number '<Result>'



Examples:
|number| operator |number2| operator2 | Result|
|2 |+ |4 |= |6 |
|2 |- |2 |= |0 |
|3 |* |3 |= |9 |
|6 |/ |2 |= |3 |

@DataTable
Scenario: Library add book functionality
Given Library is open
And Library has following book 
		|book|author|
		|ABC |Mr.ABC|
		|DEF |Mr.DEF|
		|FGH |Mr EFG|
When you add a new book with name 'LMN' and author name 'VGH'

Then Final book list is
		|book|author|
		|ABC |Mr.ABC|
		|DEF |Mr.DEF|
		|FGH |Mr EFG|
		|LMN | VGH  |
		
		
@DataTableExample
Scenario: Library add book functionality
Given Library has following book
And Library has following book
		|bookName|author|
		|ABC |Mr.ABC|
		|DEF |Mr.DEF|
		|FGH |Mr EFG|
When you add a new book with name 'LMN' and author name 'VGH'

Then Final book list is
		|book|author|
		|ABC |Mr.ABC|
		|DEF |Mr.DEF|
		|FGH |Mr EFG|
		|LMN | VGH  |
		
