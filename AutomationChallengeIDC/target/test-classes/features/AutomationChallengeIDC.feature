
@test
Feature: Automation Challenge IDC 
Description: The purpose of this feature is to automate Test 1, Test 2, Test 3,Test 4

Background: User is on home page

	Given Navigation to the home page using the "URL"
	And User is on the home page 
	
 @test1
 Scenario Outline: To automate the process for Test_1
 
   Given Click on Open Modal button
   When Enter values for "<Name>" and "<City>"
   And Click the Enter Data button
   Then Close the Modal
   And Verify values under Open Modal button that were entered in the textboxes
   
     Examples: 
     | Name | City | 
     | Prasanna Kumar | Hyderabad |

 @test2
 Scenario: To automate the process for Test_2

   Given Click on Click Me button
   When Search for the keyword "Angular"
   Then Verify two options are visible as "Angular" and "Angular 2"
   And Clear the search box and type "ReactJs"
   And Verify no option is visible
   
   @test3
 Scenario: To automate the process for Test_3
	
   Given In search box enter value "USA"
   When Verify table displays two rows with country as "USA"
   And Clear search box
   Then Verify table displays four rows
    
 @test4
 Scenario:  To automate the process for Test_4
 
   Given Drag button Drag Me to the Red Rectangle box
   When verify if button was dragged inside the box 
       
