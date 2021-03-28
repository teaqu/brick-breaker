package game.action;

import game.Game;
import game.io.GameSaverLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Load the saved game.
 */
public class LoadAction implements ActionListener {

    Game game;

    public LoadAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        GameSaverLoader gameSaverLoader = new GameSaverLoader();
        try {
            // Load game from save
            gameSaverLoader.load(game, "data/save.txt");

           // Show level if we're on the options page
           if (game.getOptionsFrame().isVisible()) {
               game.swapFrames();
           }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}