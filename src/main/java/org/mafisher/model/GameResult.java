package org.mafisher.model;

public class GameResult {
    private final int score;
    private final String playerNick;

    public GameResult(int score, String playerNick) {
        this.score = score;
        this.playerNick = playerNick;
    }

    public int getScore() {
        return score;
    }

    public String getPlayerNick() {
        return playerNick;
    }

    @Override
    public String toString() {
        return playerNick + " - " + score;
    }
}
