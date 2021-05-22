package com.battlesnake.wy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width, height;
    private List<Posn> food;
    private List<Posn> hazards;
    private List<Battlesnake> snakes;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board(int width, int height,
                 List<Posn> food,
                 List<Posn> hazards,
                 List<Battlesnake> snakes) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.hazards = hazards;
        this.snakes = snakes;
    }

    public int width() { return width; }
    public int height() { return height; }
    public List<Posn> food() { return food; }
    public List<Posn> hazards() { return hazards; }
    public List<Battlesnake> snakes() { return snakes; }


}
