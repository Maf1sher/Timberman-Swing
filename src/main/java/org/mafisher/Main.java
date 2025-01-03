package org.mafisher;

import org.mafisher.controller.MenuController;
import org.mafisher.view.GameUI;
import org.mafisher.view.GameUISwing;

public class Main {
    public static void main(String[] args) {
        GameUI gameUI = new GameUISwing();
        MenuController menuController = new MenuController(gameUI);
        menuController.run();
    }
}