package game.action;

import game.Game;
import game.level.Level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAction implements ActionListener {

    Game game;

    public PlayAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        // Make new level
        game.changeLevel(new Level1(game));
    }
}