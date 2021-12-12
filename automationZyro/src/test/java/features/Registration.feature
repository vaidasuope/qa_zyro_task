Feature: Registration

  Scenario: Not possible to register twice with the same email address
    Given that user open Zyro website
    And user accepts cookie banner
    When user clicks on Join Zyro button
    Then user is on "signup" page
    When user clicks on "Continue with Email" button on Registration page
    And user enters email address "tset.retset852@gmail.com" and password "Hello987"
    And user clicks on SignUp button
    Then error message that email is already used is displayed
    When user clicks Login in error message on Registration page
    Then user is on SigIn page


