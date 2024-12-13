package com.cata.tennis.controller;

import com.cata.tennis.adapter.TennisMatchController;
import com.cata.tennis.domain.TennisMatchPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TennisMatchControllerTest {

    private MockMvc mockMvc;
    private TennisMatchPort mockService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockService = Mockito.mock(TennisMatchPort.class);
        TennisMatchController controller = new TennisMatchController(mockService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void computeScore_shouldReturnBadRequestForInvalidInput() throws Exception {
        String invalidInput = objectMapper.writeValueAsString(Map.of("input", "ABZ"));


        mockMvc.perform(post("/api/tennis/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidInput))
                .andExpect(status().isBadRequest());
    }

    @Test
    void computeScore_shouldReturnOkForValidInput() throws Exception {
        String validInput = objectMapper.writeValueAsString(Map.of("input", "ABABAA"));
        String expectedOutput = """
            Player A : 15 / Player B : 0
            Player A : 15 / Player B : 15
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A wins the game""";

        when(mockService.computeScore("ABABAA")).thenReturn(expectedOutput);

        mockMvc.perform(post("/api/tennis/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validInput))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

    @Test
    void computeScore_shouldNormalizeInputToUpperCase() throws Exception {
        String input = objectMapper.writeValueAsString(Map.of("input", "abABaB"));
        String expectedOutput = """
        Player A : 15 / Player B : 0
        Player A : 15 / Player B : 15
        Player A : 30 / Player B : 15
        Player A : 30 / Player B : 30
        Player A : 40 / Player B : 30
        Player A wins the game""";

        when(mockService.computeScore("ABABAB")).thenReturn(expectedOutput); // Uppercase input

        mockMvc.perform(post("/api/tennis/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

}
