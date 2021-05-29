package com.battlesnake.wy;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that provides breadth first search of the squares reachable from a given square.
 * Utility functions give the ability to directly convert a Board or a List of Battlesnake to the array
 * used to represent blocked squares.
 *
 * FloodFill uses an array int[][]contents to indicate the position of obstacles on the board.
 * Nonzero entries are obstacles. Point (x,y) corresponds to contents[y][x]. There are helper functions
 * isOccupied and setOccupied to isolate the "unnatural" y then x order.
 */
public class FloodFill {

    /**
     * Is the given pt occupied in the contents array?
     * @param contents
     * @param pt
     * @return True iff contents[y][x] is true for the given point (x,y).
     */
    public static boolean isOccupied(int[][] contents, Posn pt) {
        return (contents[pt.y][pt.x]!=0);
    }

    /**
     * Mark a single entry as occupied.
     * @param contents
     * @param pt
     */
    public static void setOccupied(int[][] contents, Posn pt) {
        contents[pt.y][pt.x] = 1;
    }

    /**
     * Mark the list of entries in body as occupied in contents.
     * @param body
     * @param contents
     */
    public static void markListOccupied(List<Posn> body, int [][] contents) {
        for(Posn pt : body) {
            setOccupied(contents, pt);
        }
    }

    /**
     * Create the contents array from the Board b.
     * @param b
     * @return An array where nonzero entries indicate occupied squares of b.
     */
    public static int[][] getOccupied(Board b) {
        int[][] contents =  new int[b.width()][b.height()];
        for (Battlesnake s : b.snakes()) {
            markListOccupied(s.body(), contents);
        }
        return contents;
    }

    /**
     * Compute the number of squares reachable from the given position.
     * This does not mean that a snake could actually use all of these squares; for example,
     * a one unit wide plus-shaped space (<pre>+</pre>) would count all four "arms" of the plus as reachable although no more than
     * two could actually be filled by a snake.
     *
     * @param start The starting position.
     * @param contents An array where nonzero entries indicate occupied squares.
     * @return The number of squares reachable from the starting position.
     */
    public static int numConnectedSquares(Posn start, int[][] contents) {
        List<Posn> toCheck = new ArrayList<>();
        toCheck.add(start);
        int count = 0;

        while(!toCheck.isEmpty()) {
            Posn currentSpot = toCheck.remove(0);

            if (isOccupied(contents, currentSpot)) {
                continue;
            }

            count += 1;
            setOccupied(contents, currentSpot);

            for(Posn dir : Posn.ALL_DIRECTIONS) {
                Posn newPt = currentSpot.add(dir);
                if(! isOccupied(contents, newPt)) {
                    toCheck.add(newPt);
                }
            }
        }
        return count;
    }
}
