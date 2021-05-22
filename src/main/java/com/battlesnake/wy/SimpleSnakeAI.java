package com.battlesnake.wy;

import java.util.*;

public class SimpleSnakeAI extends SnakeAI {
    protected SnakeRandom srnd = new SnakeRandom();

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

        Posn choice = srnd.get_first_move(moves, Posn.UP);
        response.put("move", choice.asDirectionString());

        return response;
    }
}
