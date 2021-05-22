package com.battlesnake.wy;

import java.util.List;
import java.util.Random;

public class SnakeRandom {
    public Random rng = new Random();

    /**
     *
     * @param moves Choices to pick randomly between.
     * @param defaultMove The move to respond when there are no choices.
     * @return The randomly chosen move.
     */
    public Posn get_random_move(List<Posn> moves, Posn defaultMove) {
        if (moves.size()==0) {
            return defaultMove;
        } else {
            return moves.get(rng.nextInt(moves.size()));
        }
    }
    public Posn get_first_move(List<Posn> moves, Posn defaultMove) {
        if (moves.size()==0) {
            return defaultMove;
        } else {
            return moves.get(0);
        }
    }
}
