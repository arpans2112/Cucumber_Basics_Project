Feature: DataTable_ScenarioOutLine Feature

Scenario Outline: login with valid id and password
  Given Login lending page
  When  Enter Credentials username "<UserName>" and Password "<Password>"
  Then  click login button
  Examples:
         |UserName              |Password     |
         |sainiwinarth@gmail.com|@rpaN@9070676|
         |sainiwinarth@gmail.com|@rpaN@2648169|
  
