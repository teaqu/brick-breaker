package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Restart the level
 */
public class RestartAction implements ActionListener {

    Game game;

    public RestartAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Start the level again
        game.restartLevel(game.getLevel());

        // Go back to game level screen
        if (game.getOptionsFrame().isVisible()) {
            game.swapFrames();
        }
    }
}