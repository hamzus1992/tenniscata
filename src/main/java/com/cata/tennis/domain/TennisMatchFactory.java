package com.cata.tennis.domain;

import org.springframework.stereotype.Component;

@Component
public class TennisMatchFactory {

    public TennisMatch createTennisMatch() {
        return new TennisMatch();
    }
}
