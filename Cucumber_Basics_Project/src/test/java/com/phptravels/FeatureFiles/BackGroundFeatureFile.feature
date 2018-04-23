Feature: BackGroundFeatureFile

Background:  Common Login Step
	Given Login lending page


Scenario: login with valid id and password 
  When  Enter Username "sainiwinarth@gmail.com" and password "@rpaN@9070676"
  Then  click login button

Scenario: login with invalid id and password
  When  Enter Username "sainiwinarth@gmail.com" and password "@rpaN@2648169"
  Then  click login button