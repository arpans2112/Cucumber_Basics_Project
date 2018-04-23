Feature: ExtentReportConfiguration Feature

Scenario: login with valid id and password
  Given Login lending page
  When  Enter Username "sainiwinarth@gmail.com" and password "@rpaN@9070676"
  Then  click login button

Scenario: login with invalid id and password
  Given Login lending page
  When  Enter Username "sainiwinarth@gmail.com" and password "@rpaN@2648169"
  And  click login button