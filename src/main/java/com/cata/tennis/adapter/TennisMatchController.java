package com.cata.tennis.adapter;

import com.cata.tennis.domain.TennisMatchPort;
import com.cata.tennis.dto.TennisMatchInputDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tennis")
@Validated
public class TennisMatchController {

    private final TennisMatchPort tennisMatchPort;

    public TennisMatchController(TennisMatchPort tennisMatchPort) {
        this.tennisMatchPort = tennisMatchPort;
    }

    @PostMapping("/compute")
    public String computeScore(@Valid @RequestBody TennisMatchInputDTO inputDTO) {
        String normalizedInput = inputDTO.getInput().toUpperCase();
        return tennisMatchPort.computeScore(normalizedInput);
    }
}
