$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/features/KeywordDrivenTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Keyword Driven Approach",
  "description": "",
  "id": "keyword-driven-approach",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Smoke Test",
  "description": "",
  "id": "keyword-driven-approach;smoke-test",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I want to grab \"\u003cSheetName\u003e\" test cases",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I validate the outcomes",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "keyword-driven-approach;smoke-test;",
  "rows": [
    {
      "cells": [
        "SheetName"
      ],
      "line": 28,
      "id": "keyword-driven-approach;smoke-test;;1"
    },
    {
      "cells": [
        "Search"
      ],
      "line": 29,
      "id": "keyword-driven-approach;smoke-test;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 29,
  "name": "Smoke Test",
  "description": "",
  "id": "keyword-driven-approach;smoke-test;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    },
    {
      "line": 22,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I want to grab \"Search\" test cases",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I validate the outcomes",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Search",
      "offset": 16
    }
  ],
  "location": "CommonStepDefinitions.i_want_to_grab_list_of_test_cases(String)"
});
formatter.result({
  "duration": 124504022117,
  "error_message": "java.lang.NullPointerException\n\tat step_definitions.KeywordFramework.main(KeywordFramework.java:25)\n\tat step_definitions.CommonStepDefinitions.i_want_to_grab_list_of_test_cases(CommonStepDefinitions.java:14)\n\tat ✽.Given I want to grab \"Search\" test cases(cucumber/features/KeywordDrivenTest.feature:24)\n",
  "status": "failed"
});
formatter.match({
  "location": "CommonStepDefinitions.i_validate_the_outcomes()"
});
formatter.result({
  "status": "skipped"
});
});