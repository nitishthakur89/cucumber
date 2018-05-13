Feature: proof that cucumber works fine on my system again

  @Regression
  Scenario Outline: my first program
    Given code is correct
    When POC is carry with <user>
    Then test cases pass with <pwd>

    Examples: 
      | user   | pwd    |
      | jaggu  | pass   |
      | nitish | Thakur |
      | debu   | ghosh  |
