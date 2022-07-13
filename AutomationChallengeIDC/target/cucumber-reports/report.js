$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AutomationChallengeIDC.feature");
formatter.feature({
  "line": 3,
  "name": "Automation Challenge IDC",
  "description": "Description: The purpose of this feature is to automate Test 1, Test 2, Test 3,Test 4",
  "id": "automation-challenge-idc",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.scenarioOutline({
  "line": 12,
  "name": "To automate the process for Test_1",
  "description": "",
  "id": "automation-challenge-idc;to-automate-the-process-for-test-1",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@test1"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Click on Open Modal button",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Enter values for \"\u003cName\u003e\" and \"\u003cCity\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Click the Enter Data button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Close the Modal",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Verify values under Open Modal button that were entered in the textboxes",
  "keyword": "And "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "automation-challenge-idc;to-automate-the-process-for-test-1;",
  "rows": [
    {
      "cells": [
        "Name",
        "City"
      ],
      "line": 21,
      "id": "automation-challenge-idc;to-automate-the-process-for-test-1;;1"
    },
    {
      "cells": [
        "Prasanna Kumar",
        "Hyderabad"
      ],
      "line": 22,
      "id": "automation-challenge-idc;to-automate-the-process-for-test-1;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3478940100,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "User is on home page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "Navigation to the home page using the \"URL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User is on the home page",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "URL",
      "offset": 39
    }
  ],
  "location": "Background.navigation_to_the_home_page_using_the(String)"
});
formatter.result({
  "duration": 3401691300,
  "status": "passed"
});
formatter.match({
  "location": "Background.user_is_on_the_home_page()"
});
formatter.result({
  "duration": 384141600,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "To automate the process for Test_1",
  "description": "",
  "id": "automation-challenge-idc;to-automate-the-process-for-test-1;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@test1"
    },
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Click on Open Modal button",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Enter values for \"Prasanna Kumar\" and \"Hyderabad\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Click the Enter Data button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Close the Modal",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Verify values under Open Modal button that were entered in the textboxes",
  "keyword": "And "
});
formatter.match({
  "location": "Test1.click_on_Open_Modal_button()"
});
formatter.result({
  "duration": 94657100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Prasanna Kumar",
      "offset": 18
    },
    {
      "val": "Hyderabad",
      "offset": 39
    }
  ],
  "location": "Test1.enter_values_for_and(String,String)"
});
formatter.result({
  "duration": 354275200,
  "status": "passed"
});
formatter.match({
  "location": "Test1.click_the_Enter_Data_button()"
});
formatter.result({
  "duration": 47328700,
  "status": "passed"
});
formatter.match({
  "location": "Test1.close_the_Modal()"
});
formatter.result({
  "duration": 172314000,
  "status": "passed"
});
formatter.match({
  "location": "Test1.verify_values_under_Open_Modal_button_that_were_entered_in_the_textboxes()"
});
formatter.result({
  "duration": 284914200,
  "status": "passed"
});
formatter.after({
  "duration": 438219000,
  "status": "passed"
});
});