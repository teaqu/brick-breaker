package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Show the options page
 */
public class OptionsAction implements ActionListener {

    Game game;

    public OptionsAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
      game.swapFrames();
    }
}