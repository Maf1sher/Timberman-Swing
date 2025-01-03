package org.mafisher.controller;

import org.mafisher.model.GameResult;
import org.mafisher.view.GameUI;

import java.io.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ScoreBoardController {

    private final String scoreBoardFileName = "scoreboard.txt";
    private final LinkedList<GameResult> scoreBoard;

    public ScoreBoardController() {
        this.scoreBoard = readScoreBoard();
    }

    public void addScore(GameResult score) {
        scoreBoard.add(score);
        scoreBoard.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
    }

    public void showScoreBoard(GameUI gameUI) {
        gameUI.drawBackground();
        gameUI.drawScoreboard(scoreBoard.stream().limit(10).collect(Collectors.toList()));
        gameUI.update();
        while (!KeyController.isEnternProcessed());
    }

    public void saveScoreBoard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoreBoardFileName))) {
            for (int i = 0; i < Math.min(scoreBoard.size(), 10); i++) {
                writer.write(scoreBoard.get(i).getPlayerNick() + " - " + scoreBoard.get(i).getScore() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LinkedList<GameResult> readScoreBoard() {
        LinkedList<GameResult> readedScoreBoard = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(scoreBoardFileName))) {
            String line;
            while ((line = reader.readLine()) != null && !line.equals("\n")) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String playerNick = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    readedScoreBoard.add(new GameResult(score, playerNick));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedScoreBoard;
    }
}
