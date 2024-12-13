Feature: Tennis Score Computation

  Scenario: Compute score for the input string "ABABAA"
    Given a match input "ABABAA"
    When the scores are computed
    Then the result should be:
      """
      Player A : 15 / Player B : 0
      Player A : 15 / Player B : 15
      Player A : 30 / Player B : 15
      Player A : 30 / Player B : 30
      Player A : 40 / Player B : 30
      Player A wins the game
      """