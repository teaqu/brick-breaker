package game.action;

import game.Game;
import game.level.GameLevel;
import game.level.Level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAction implements ActionListener {

    Game game;
    int level;

    public PlayAction(Game game) {
        this(game, 1);
    }

    public PlayAction(Game game, int level) {
        this.game = game;
        this.level = level;
    }

    public void actionPerformed(ActionEvent e) {
        game.changeLevel(game.getLevelByNum(level));
    }
}