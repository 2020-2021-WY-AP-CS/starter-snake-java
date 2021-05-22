package com.battlesnake.wy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class SnakeAI {

    protected static final Logger LOG = LoggerFactory.getLogger(SnakeAI.class);

    protected int width, height;
    protected String id;

    public boolean inBounds(Posn p) {
        return (0 <= p.x && p.x < width) &&
                (0 <= p.y && p.y < height);
    }
    public void start(Game game, int turn, Board board, Battlesnake you) {
        width = board.width();
        height = board.height();
        id = you.id();
        LOG.debug("game started");
    }

    public abstract Map<String, String> move(Game game, int turn, Board board, Battlesnake you);

    public void end(Game game, int turn, Board board, Battlesnake you) {
        LOG.debug("game ended");
    }
}
