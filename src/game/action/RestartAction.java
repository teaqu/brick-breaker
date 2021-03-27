package game.action;

import game.Game;
import game.level.GameLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartAction implements ActionListener {

    Game game;

    public RestartAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.restartLevel(game.getLevel());
        if (game.getOptionsFrame().isVisible()) {
            game.swapFrames();
        }
    }
}