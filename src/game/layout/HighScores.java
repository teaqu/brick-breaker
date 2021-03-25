package game.layout;

import game.Game;
import game.action.MainAction;

import javax.swing.*;

public class HighScores {
    private JPanel mainPanel;
    private JButton back;
    private Game game;

    public HighScores(Game game) {
        this.game = game;
    }

    private void createUIComponents() {
        back = new JButton("BACK");
        back.addActionListener(new MainAction(game));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
