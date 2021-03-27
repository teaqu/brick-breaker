package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackAction implements ActionListener {

    Game game;

    public BackAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.getFrame().setVisible(true);
        game.getFrame().setLocation(game.getOptionsFrame().getLocation());
        game.getOptionsFrame().setVisible(false);
        game.getLevel().start();
    }
}