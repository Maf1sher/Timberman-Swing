package org.mafisher.view;

import org.mafisher.enums.RGBColorEnums;
import org.mafisher.model.Board;
import org.mafisher.model.GameResult;
import org.mafisher.model.Timberman;

import java.util.List;

public interface GameUI {
    void initial();
    void update();
    void close();
    void drawMenu(int selectedOption);
    void drawBackground();
    void drawBoard(Board board);
    void drawTimberman(Timberman timberman);
    void drawScore(int score);
    void drwaGameOver(int score, StringBuilder nick);
    void drawTimer(int time);
    void drawScoreboard(List<GameResult> scoreboard);
    void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors);
}
