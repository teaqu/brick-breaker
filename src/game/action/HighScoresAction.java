package game.action;

import game.Game;
import game.layout.HighScores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Show the high scores page.
 */
public class HighScoresAction implements ActionListener {

    Game game;

    public HighScoresAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Redirect to high scores
        game.resetFrame();
        game.getFrame().add(new HighScores(game).getMainPanel());
    }
}