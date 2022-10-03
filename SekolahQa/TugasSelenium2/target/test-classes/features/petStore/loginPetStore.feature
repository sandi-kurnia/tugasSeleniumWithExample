Feature: Login at JPetStore

Scenario Outline: Login with registered user
  Given User at Login Page
    And User enter User ID "<UserID>"
    And User enter Valid Password "<Password>"
  When User click login button to login
  Then User get Alert in home page

  Examples:
    |UserID     |Password |
    |AntonMotor1|Testi123@|
    |AntonMobil1|Testi123@|

Scenario Outline: Login with unregistered User
  Given User at Login Page
    And User enter User ID "<UserID>"
    And User enter Valid Password "<Password>"
  When User click login button to login
  Then User get Alert "Invalid username or password. Signon failed."

  Examples:
    |UserID     |Password |
    |AntonMotor1|Testi123 |
    |AntonMobil |Testi1231|
