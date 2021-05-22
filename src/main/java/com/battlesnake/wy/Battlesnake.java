package com.battlesnake.wy;

import java.util.ArrayList;
import java.util.List;

public class Battlesnake {
    private String id, name, latency, shout, squad;
    private int health;
    private List<Posn> body;

    public Battlesnake() {
        this(new ArrayList<>());
    }

    public Battlesnake(List<Posn> body) {
        this("(no-args constructor used)",
                "(no name)",
                0, "0", "(did not shout)", "(no squad)",
                body);
    }

    public Battlesnake(String id, String name, int health, String latency,
                       String shout, String squad, List<Posn> body) {
        this.id = id;
        this.name = name;
        this.latency = latency;
        this.health = health;
        this.body = body;
    }

    public Battlesnake(String id, String name, int health, String latency,
                       String shout, String squad) {
        this(id, name, health, latency, shout, squad,
                new ArrayList<>());
    }

    public int length() {
        return body.size();
    }

    public Posn head() {
        return body.get(0);
    }

    public List<Posn> body() {
        return this.body;
    }

    public String id() { return id; }

}
