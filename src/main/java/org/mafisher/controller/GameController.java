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
        StringBuilder nickBuilder = new StringBuilder();
        boolean isFinished = false;
//        Terminal terminal = gameUI.getTerminal();

//        try {

//            while (terminal.pollInput() != null) {
//                // czyscimy buffor wcisnietych klawiszy
//            }

//            while (!isFinished) {
                gameUI.drwaGameOver( score, nickBuilder.toString());
                refreshBoard();

//                KeyStroke keyStroke = terminal.pollInput();
//                if (keyStroke != null) {
//                    switch (keyStroke.getKeyType()) {
//                        case Enter:
//                            if (!nickBuilder.isEmpty()) {
//                                isFinished = true;
//                            }
//                            break;
//                        case Backspace:
//                            if (!nickBuilder.isEmpty()) {
//                                nickBuilder.deleteCharAt(nickBuilder.length() - 1);
//                            }
//                            break;
//                        case Character:
//                            nickBuilder.append(keyStroke.getCharacter());
//                            break;
//                    }
//                }

//                Thread.sleep(50);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return nickBuilder.toString();
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
        gameUI.drawBoard(board);
        gameUI.drawTimberman(timberman);
        gameUI.drawTimer(timer);
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
