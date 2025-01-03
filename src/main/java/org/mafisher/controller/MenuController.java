package org.mafisher.controller;

import org.mafisher.model.GameResult;
import org.mafisher.view.GameUI;

public class MenuController {

    private final GameUI gameUI;
    private final GameController gameController;
    private final ScoreBoardController ScoreBoardController;
    private final TimbermanColorController TimbermanColorController;

    private boolean menuRunning = true;
    private int selectedOption = 0;

    public MenuController(GameUI gameUI) {
        this.gameUI = gameUI;
        this.gameController = new GameController(gameUI);
        this.ScoreBoardController = new ScoreBoardController();
        this.TimbermanColorController = new TimbermanColorController();
    }

    public void run() {
        new Thread(gameUI::initial).start();

        while (menuRunning) {
            gameUI.drawBackground();
            gameUI.drawMenu(selectedOption);
            gameUI.update();

            if (KeyController.isEnternProcessed()) {
                switch (selectedOption) {
                    case 0:
                        GameResult result = gameController.startGame();
                        ScoreBoardController.addScore(result);
                        while(!KeyController.isEnternProcessed());
                        break;
                    case 1:
                        ScoreBoardController.showScoreBoard(gameUI);
                        break;
                    case 2:
                        TimbermanColorController.changeTimbermanColor(gameUI, gameController);
                        break;
                    case 3:
                        gameUI.close();
                        menuRunning = false;
                        ScoreBoardController.saveScoreBoard();
                        break;
                }
            }

            handleNavigation();
        }
    }

    private void handleNavigation() {
        if (KeyController.isDownProcessed()) {
            if (selectedOption < 3) {
                selectedOption++;
            }
        }

        if (KeyController.isUpProcessed()) {
            if (selectedOption > 0) {
                selectedOption--;
            }
        }
    }
}
