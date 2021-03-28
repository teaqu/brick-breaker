package game.action;

import game.Game;
import game.layout.LevelsMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Show the levels page
 */
public class LevelsAction implements ActionListener {

    Game game;

    public LevelsAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Redirect to levels page
        game.resetFrame();
        game.getFrame().add(new LevelsMenu(game));
    }
}