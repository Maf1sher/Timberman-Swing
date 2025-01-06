package org.mafisher.controller;

//import com.googlecode.lanterna.input.KeyStroke;
//import com.googlecode.lanterna.terminal.Terminal;
import org.mafisher.model.Game;
import org.mafisher.model.GameResult;
import org.mafisher.model.TupleBoolean;
import org.mafisher.view.GameUI;

public class GameController extends Game{

    private final GameUI gameUI;

    public GameController(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public GameResult startGame(){
        initializeGame();
        while(gameOver()){
            gameLoop();
        }
        String nick = endGame();
        return new GameResult(score, nick);
    }

    private void initializeGame() {
        board.clearBoard();
        this.score = 0;
        this.timer = 100;
        board.addLevel(new TupleBoolean(false, false));
        for (int i = 0; i < 10; i++) {
            board.addLevel(generateLevel());
        }
        refreshBoard();
    }

    private void gameLoop(){
        tick++;
        if(calculateTime())
            refreshBoard();

        if(KeyController.isLeftPressed()){
            timberman.setLeftSide();
            cutLevel();
        }

        if(KeyController.isRightPressed()){
            timberman.setRightSide();
            cutLevel();

        }

        try {
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        gameUI.drawTimer(timer);
//        gameUI.update();
    }

    private String endGame() {
        StringBuilder nick = new StringBuilder();
        gameUI.drwaGameOver(score, nick);
        refreshBoard();

        while (!KeyController.isEnternProcessed()  || nick.length() < 3) {
            String currentKey = KeyController.getCurrentKeyPressed();

            if (KeyController.isBackspacePressed()) {
                if (nick.length() > 0) {
                    nick.deleteCharAt(nick.length() - 1);
                }
            }

            if (currentKey != null && !currentKey.equals("") && !currentKey.equals("ENTER")) {
                nick.append(currentKey.trim());
            }

            gameUI.drwaGameOver(score, nick);

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        refreshBoard();
        return nick.toString();
    }

    private void cutLevel(){
        board.addLevel(generateLevel());
        board.deleteLevel();
        score++;
        if(timer < 100)
            timer++;
        refreshBoard();
    }

    private void refreshBoard(){
        gameUI.drawBackground();
        gameUI.drawScore(score);
        gameUI.drawTimer(timer);
        gameUI.drawTimberman(timberman);
        gameUI.drawBoard(board);
        gameUI.update();
    }


    private boolean gameOver() {
        if(timer <= 0)
            return false;

        if(timberman.isLeftSide() && board.getFirstLevel().getValue1())
            return false;

        if(timberman.isRightSide() && board.getFirstLevel().getValue2())
            return false;

        return true;

    }
}
