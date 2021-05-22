package com.battlesnake.wy;

import java.util.*;

public class SimpleSnakeAI extends SnakeAI {

    private Random rng = new Random();

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
        Posn choice = moves.get(rng.nextInt(moves.size()));
        response.put("move", choice.asDirectionString());

        return response;
    }
}
