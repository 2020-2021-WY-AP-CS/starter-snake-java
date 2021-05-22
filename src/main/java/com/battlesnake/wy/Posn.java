package com.battlesnake.wy;

/**
 * Notes: after writing some AI routines, I came to believe using (change in x, change in y) was
 * easy but it made it difficult to write strategies like "after you turn left, go one step and then head down".
 */
public class Posn implements Comparable<Posn> {
    public int x, y;
    // index classifies four basic moves: left (0), right (1), up (2), down (3)
    public int index;

    public Posn(int x, int y) {
        this.x = x;
        this.y = y;
        this.index = classify(x,y);
    }

    public int compareTo(Posn other) {
        int result = this.x - other.x;
        if (result == 0) {
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
    public static final String[] STRING_DIRECTIONS = {"up", "down", "left", "right"};

    private static int classify(int x, int y) {
        if (x==0 && y==1) { return 0; }
        else if (x==0 && y==-1) { return 1; }
        else if (x==-1 && y==0) { return 2; }
        else if (x==1 && y==0) { return 3; }
        else return -1;
    }
    public String asDirectionString() {
        if (index >= 0) {
            return STRING_DIRECTIONS[index];
        }
        else {
            throw new IllegalArgumentException("Posn must be up, down, left, right for conversion");
        }
    }

}
