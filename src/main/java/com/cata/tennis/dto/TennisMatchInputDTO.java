package com.cata.tennis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TennisMatchInputDTO {

    @NotBlank(message = "Input string cannot be blank")
    @Pattern(regexp = "^[AaBb]+$", message = "Input string can only contain 'A', 'a', 'B', or 'b'")
    private String input;
}

