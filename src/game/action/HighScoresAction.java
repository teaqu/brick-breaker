package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresAction implements ActionListener {

    Game game;

    public HighScoresAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.resetFrame();
        game.getFrame().add(game.getHighScores().getMainPanel());
    }
}