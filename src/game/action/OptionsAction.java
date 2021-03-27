package game.action;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsAction implements ActionListener {

    Game game;

    public OptionsAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.resetFrame();
        game.getFrame().add(game.getOptionsMenu());
    }
}