package game.controller;

import game.Game;
import game.layout.OptionsMenu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {

    private Game game;

    public GameController(Game game){
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            this.game.getLevel().stop();
            game.swapFrames();
            game.getOptionsFrame().setVisible(true);
        }
    }
}
