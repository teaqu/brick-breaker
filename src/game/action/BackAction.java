package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action to go back from options menu to level
 */
public class BackAction implements ActionListener {

    Game game;

    public BackAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Swap back to level
        game.swapFrames();

        // Resume level
        game.getLevel().start();
    }
}