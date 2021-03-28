package game.controller;

import game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Listen to game keyboard events.
 */
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
            // Show options menu on ESC
            this.game.getLevel().stop();
            game.swapFrames();
            game.getOptionsFrame().setVisible(true);
        }
    }
}
