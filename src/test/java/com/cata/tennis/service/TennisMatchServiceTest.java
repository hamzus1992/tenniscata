package com.cata.tennis.service;

import com.cata.tennis.domain.TennisMatchFactory;
import com.cata.tennis.domain.TennisMatchService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisMatchServiceTest {

    @Test
    void computeScore_shouldReturnCorrectScores() {
        TennisMatchFactory factory = new TennisMatchFactory();
        TennisMatchService service = new TennisMatchService(factory);

        String input = "ABABAA";
        String expectedOutput = """
            Player A : 15 / Player B : 0
            Player A : 15 / Player B : 15
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A wins the game""";

        String actualOutput = service.computeScore(input);

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
