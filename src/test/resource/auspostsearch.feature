Feature: proof that user can able to search by tracking number

  @ausposttracking
  Scenario: search by tracking number
    Given user has opened aus post site with browser "firefox"
    When user is searching wih tracking "EBA00369813701008462501"
    Then user is able to search sucessfully
