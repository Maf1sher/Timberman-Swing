package org.mafisher.controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    private static volatile boolean leftPressed = false;
    private static volatile boolean rightPressed = false;
    private static volatile boolean upPressed = false;
    private static volatile boolean downPressed = false;
    private static volatile boolean enterPressed = false;

    private static volatile boolean leftProcessed = false;
    private static volatile boolean rightProcessed = false;
    private static volatile boolean upProcessed = false;
    private static volatile boolean downProcessed = false;
    private static volatile boolean enterProcessed = false;

    public static boolean isLeftPressed() {
        if (leftPressed && !leftProcessed) {
            leftProcessed = true;
            return true;
        }
        return false;
    }
    public static boolean isRightPressed() {
        if (rightPressed && !rightProcessed) {
            rightProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isUpProcessed() {
        if (upPressed && !upProcessed) {
            upProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isDownProcessed() {
        if (downPressed && !downProcessed) {
            downProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isEnternProcessed() {
        synchronized (KeyController.class) {
            if (enterPressed && !enterProcessed) {
                enterProcessed = true;
                return true;
            }
            return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> leftPressed = true;
            case KeyEvent.VK_RIGHT -> rightPressed = true;
            case KeyEvent.VK_UP -> upPressed = true;
            case KeyEvent.VK_DOWN -> downPressed = true;
            case KeyEvent.VK_ENTER -> enterPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                leftPressed = false;
                leftProcessed = false;
            }
            case KeyEvent.VK_RIGHT -> {
                rightPressed = false;
                rightProcessed = false;
            }
            case KeyEvent.VK_UP -> {
                upPressed = false;
                upProcessed = false;
            }
            case KeyEvent.VK_DOWN -> {
                downPressed = false;
                downProcessed = false;
            }
            case KeyEvent.VK_ENTER -> {
                enterPressed = false;
                enterProcessed = false;
            }
        }
    }
}