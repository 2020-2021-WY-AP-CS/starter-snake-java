package com.battlesnake.wy;

import com.fasterxml.jackson.databind.JsonNode;

public class Posn implements Comparable<Posn> {
    public int x, y;
    public Posn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Posn other) {
        int result = this.x - other.x;
        if (result == 0 ) {
            result = this.y - other.y;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Posn) {
            Posn other = (Posn) o;
            return (x == other.x && y == other.y);
        } else {
            return false;
        }
    }

    public Posn opposite() {
        return new Posn(-x, -y);
    }

    public Posn add(Posn other) {
        return new Posn(x + other.x, y + other.y);
    }

    public static final Posn UP = new Posn(0,1);
    public static final Posn DOWN = new Posn(0,-1);
    public static final Posn LEFT = new Posn(-1,0);
    public static final Posn RIGHT = new Posn(1,0);

    public static final Posn[] ALL_DIRECTIONS = { UP, DOWN, LEFT, RIGHT };

    public String asDirectionString() {
        if (x==0 && y==1) { return "up"; }
        else if (x==0 && y==-1) { return "down"; }
        else if (x==-1 && y==0) { return "left"; }
        else if (x==1 && y==0) { return "right"; }
        else {
            throw new IllegalArgumentException("Posn must be up, down, left, right for conversion");
        }
    }

}
