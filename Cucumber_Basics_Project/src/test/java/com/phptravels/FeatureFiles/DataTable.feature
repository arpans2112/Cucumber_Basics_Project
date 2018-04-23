Feature: Facebook Login Feature test

Scenario: login with valid id and password
  Given Login lending page
  When  Enter Credentials
         |UserName              |Password     |
         |sainiwinarth@gmail.com|@rpaN@9070676|
  Then  click login button
