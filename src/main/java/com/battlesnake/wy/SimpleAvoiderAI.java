package com.battlesnake.wy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleAvoiderAI extends SimpleSnakeAI {
    @Override
    public Map<String, String> move(Game game, int turn, Board board, Battlesnake you) {
        Map<String, String> response = new HashMap<>();

        ArrayList<Posn> safeMoves = getSafeMoves(board, you);

        int w = board.width();
        int h = board.height();

        Posn head = you.body().get(0);
        Posn headprev = you.body().get(1);
        Posn dir = head.add(headprev.opposite());
        boolean travelAlongX = (dir.y==0);

        return response;
    }
}

