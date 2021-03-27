package game.action;

import game.Game;
import game.layout.OptionsMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction implements ActionListener {

    Game game;

    public MainAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.getFrame().setVisible(true);
        game.getFrame().setLocation(game.getOptionsFrame().getLocation());
        game.resetFrame();
        game.getFrame().add(game.getMainMenu());
        game.getOptionsFrame().setVisible(false);
    }
}