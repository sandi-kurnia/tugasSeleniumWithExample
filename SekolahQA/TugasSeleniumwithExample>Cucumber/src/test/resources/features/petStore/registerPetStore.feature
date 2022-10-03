Feature: Test Register functionality

  Scenario Outline: Register with credential user
    Given User at Sign Pages
    When User click Register buttons
      And User input User ID "<UsersID>"
      And User input Password "<Password>"
      And User input Repeat Password "<RepeatPassword>"
      And User input First Name "<FirstName>"
      And User input Last Name "<LastName>"
      And User input Email "<Email>"
      And User input Phone "<Phone>"
      And User input First Address "<FirstAddress>"
      And User input Second Address  "<SecondAddress>"
      And User input City "<City>"
      And User input State "<State>"
      And User input Zip "<Zip>"
      And User input Country "<Country>"
      And User select Language Preferences "<LanguagePrefences>"
      And User select Favourite Categories "<Category>"
      And User select Enable MyLists
      And User select Enable MyBanners
      And User click User Account Informations Button to Register
    Then Direct user to MainPages

    Examples:
      |UsersID        |Password |RepeatPassword|FirstName   |LastName   |Email              |Phone      |FirstAddress|SecondAddress|City       |State  |Zip   |Country|LanguagePrefences|Category|
      |MamatSutrisne  |Testi123@|Testi123@     |Mamang      |Sutrisno   |testingqa1@gmail.com|9532351442 |Delhi       |Bihar        |Pradesh    |Texas  |208025|India  |english          |DOGS    |
      |PopoRacingNaonA|Testi123@|Testi123@     |Popo        |Racing     |testingqa2@gmail.com|9532351441 |Delhi       |Bihar        |Pradesh    |London |208025|India  |japanese         |BIRDS   |



