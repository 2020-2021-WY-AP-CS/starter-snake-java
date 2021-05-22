package com.battlesnake.wy;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class BattleJson {

    public static Posn toPosn(JsonNode j) {
        return new Posn (j.get("x").asInt(), j.get("y").asInt());
    }

    public static Battlesnake toBattlesnake(JsonNode j) {
        String id = getStr(j, "id");
        String name = getStr(j, "name");
        int health = getInt(j, "health");
        String latency = getStr(j, "latency");
        String shout = getStr(j, "shout");
        String squad = getStr(j, "squad");
        List<Posn> body = toPosnList(j.get("body"));
        return new Battlesnake(id, name, health, latency,
                shout, squad, body);

    }

    public static List<Posn> toPosnList(JsonNode j) {
        ArrayList<Posn> body = new ArrayList<>();
        for (JsonNode jSegment : j) {
            body.add(BattleJson.toPosn(jSegment));
        }
        return body;
    }

    public static List<Battlesnake> toBattlesnakeList(JsonNode j) {
        ArrayList<Battlesnake> snook = new ArrayList<>();
        for (JsonNode jj : j) {
            snook.add(BattleJson.toBattlesnake(jj));
        }
        return snook;
    }

    public static Board toBoard(JsonNode j) {
        int width = getInt(j, "width");
        int height = getInt(j, "height");
        List<Posn> food = toPosnList(j.get("food"));
        List<Posn> hazards = toPosnList(j.get("hazards"));
        List<Battlesnake> snakes = toBattlesnakeList(j.get("snakes"));

        return new Board(width, height, food, hazards, snakes);
    }

    public static Game toGame(JsonNode j) {
        String id = getStr(j, "id");
        JsonNode ruleset = j.get("ruleset");
        int timeout = getInt(j, "timeout");
        return new Game(id, ruleset, timeout);
    }

    public static String getStr(JsonNode j, String key) {
        return j.get(key).asText();
    }
    public static int getInt(JsonNode j, String key) {
        return j.get(key).asInt();
    }

}
