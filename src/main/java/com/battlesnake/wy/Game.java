package com.battlesnake.wy;

import com.fasterxml.jackson.databind.JsonNode;

public class Game {
    private String id;
    private JsonNode ruleset;
    private int timeout;

    public Game (String id, JsonNode ruleset, int timeout) {
        this.id = id;
        this.timeout = timeout;
        this.ruleset = ruleset;
    }
}
