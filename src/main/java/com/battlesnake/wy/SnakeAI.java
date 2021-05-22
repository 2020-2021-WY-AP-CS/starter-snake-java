package com.battlesnake.wy;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class SnakeAI {

    protected static final Logger LOG = LoggerFactory.getLogger(SnakeAI.class);
    private static final Map<String, String> EMPTY = new HashMap<>();

    public static final int EVENT_START = 1;
    public static final int EVENT_MOVE = 2;
    public static final int EVENT_END = 3;

    protected int width, height;
    protected String id;

    public boolean inBounds(Posn p) {
        return (0 <= p.x && p.x < width) &&
                (0 <= p.y && p.y < height);
    }

    public Map<String, String> dispatch(JsonNode request,
                                        int eventType) {
        Game game = BattleJson.toGame(request.get("game"));
        int turn = BattleJson.getInt(request, "turn");
        Board board = BattleJson.toBoard(request.get("board"));
        Battlesnake snake = BattleJson.toBattlesnake(request.get("you"));
        Map<String, String> response = EMPTY;
        switch (eventType) {
            case EVENT_START:
                start(game, turn, board, snake);
                break;
            case EVENT_END:
                end(game, turn, board, snake);
                break;
            case EVENT_MOVE:
                response = move(game, turn, board, snake);
                break;
            default:
                throw new IllegalArgumentException("Bad eventType provided");
        }
        return response;
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
