package com.battlesnake.wy;

import java.util.*;

public class SimpleSnakeAI extends SnakeAI {

    private Random rng = new Random();

    /**
     *
     * @param moves Choices to pick randomly between.
     * @param defaultMove The move to respond when there are no choices.
     * @return The randomly chosen move.
     */
    public Posn get_random_move(List<Posn> moves, Posn defaultMove) {
        if (moves.size()==0) return defaultMove;

        return moves.get(rng.nextInt(moves.size()));
    }
    @Override
    public Map<String, String> move(Game game, int turn, Board board, Battlesnake you) {
        Map<String, String> response = new HashMap<>();

        Posn head = you.head();
        List<Posn> body = you.body();
        ArrayList<Posn> moves = new ArrayList<>();
        for (Posn dir : Posn.ALL_DIRECTIONS) {
            Posn dest = head.add(dir);
            boolean hitSelf = body.contains(dest);
            boolean hitWall = ! inBounds(dest);
            if( !hitSelf && ! hitWall) {
                moves.add(dir);
            }
        }

        Posn choice = get_random_move(moves, Posn.UP);
        response.put("move", choice.asDirectionString());

        return response;
    }
}
