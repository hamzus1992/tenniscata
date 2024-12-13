package com.cata.tennis.cucumber.stepdef;

import com.cata.tennis.domain.TennisMatchFactory;
import com.cata.tennis.domain.TennisMatchService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisScoreSteps {

    private TennisMatchService service;
    private String input;
    private String result;

    @Autowired
    private TennisMatchFactory factory;

    @Given("a match input {string}")
    public void aMatchInput(String input) {
        service = new TennisMatchService(factory);
        this.input = input;
    }

    @When("the scores are computed")
    public void theScoresAreComputed() {
        result = service.computeScore(input);
    }

    @Then("the result should be:")
    public void theResultShouldBe(String expected) {
        assertEquals(expected, result);
    }
}
