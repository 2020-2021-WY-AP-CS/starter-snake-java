package com.battlesnake.wy;

/**
 * The Posn class provides integer coordinate pairs (x,y). It is also used for directions.
 * There is also a <code>index</code> field that enumerates the four basic directions (up, down, left, right).
 * Directions are interpreted in the standard first quadrant mathematical representation, where positive y values are "up".
 * Basic arithmetic methods are also provided.
 * Notes: after writing some AI routines, I came to believe using (change in x, change in y) was
 * easy but it made it difficult to write strategies like "after you turn left, go one step and then head down".
 */
public class Posn implements Comparable<Posn> {
    public int x, y;
    /**
     * Classifies four basic moves: left (0), right (1), up (2), down (3). Negative one (-1) in other cases.
     */
    public int index;

    /**
     * Construct a coordinate pair.
     * @param x
     * @param y
     */
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

    /**
     * Create a new Posn with the opposite x and y coordinates.
     * @return
     */
    public Posn opposite() {
        return new Posn(-x, -y);
    }

    /**
     * Create a new posn, the sum of <code>this</code> and <code>other</code>.
     * @param other
     * @return
     */
    public Posn add(Posn other) {
        return new Posn(x + other.x, y + other.y);
    }

    public static final Posn UP = new Posn(0,1);
    public static final Posn DOWN = new Posn(0,-1);
    public static final Posn LEFT = new Posn(-1,0);
    public static final Posn RIGHT = new Posn(1,0);

    /**
     * A four element array containing Posns for the cardinal directions up down, left, and right.
     */
    public static final Posn[] ALL_DIRECTIONS = { UP, DOWN, LEFT, RIGHT };
    public static final String[] STRING_DIRECTIONS = {"up", "down", "left", "right"};

    private static int classify(int x, int y) {
        if (x==0 && y==1) { return 0; }
        else if (x==0 && y==-1) { return 1; }
        else if (x==-1 && y==0) { return 2; }
        else if (x==1 && y==0) { return 3; }
        else return -1;
    }

    /**
     * Convert one of the four cardinal directions to a String.
     * Used in sending commands to the Battlesnake server.
     *
     * @return One of "up", "down", "left", "right"
     * @throws IllegalArgumentException when the Posn is not one of the cardinal directions.
     */
    public String asDirectionString() {
        if (index >= 0) {
            return STRING_DIRECTIONS[index];
        }
        else {
            throw new IllegalArgumentException("Posn must be up, down, left, right for conversion");
        }
    }

}
