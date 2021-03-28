package game.action;

import game.Game;
import game.layout.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Show the main menu
 */
public class MainAction implements ActionListener {

    Game game;

    public MainAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Set game frame to main menu
        game.resetFrame();
        game.getFrame().add(new MainMenu(game));

        // Get out of options menu
        if (game.getOptionsFrame().isVisible()) {
            game.swapFrames();
        }

        // Clear game so we can start again
        game.reset();
    }
}