package game.action;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction implements ActionListener {

    Game game;

    public MainAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        game.resetFrame();
        JFrame frame = game.getFrame();
        frame.add(game.getMainMenu());
    }
}