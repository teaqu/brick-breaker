package game.layout;

import game.Game;
import game.action.ContinueAction;
import game.model.Stats;

import javax.swing.*;

public class EndGame {
    private JPanel mainPanel;
    private JTextField name;
    private JButton continueButton;
    private JLabel scoreLabel;
    private JLabel levelLabel;
    private JLabel scoreStat;
    private JLabel levelStat;
    private JLabel title;
    private boolean complete = false;
    private Game game;

    public EndGame(Game game) {
        this.game = game;
    }

    public EndGame(Game game, boolean complete) {
        this(game);
        this.complete = complete;
        title.setText("GAME " + (complete ? "COMPLETE" : "OVER"));
    }

    private void createUIComponents() {
        continueButton = new JButton("CONTINUE");
        Stats stats = game.getStats();
        scoreStat = new JLabel(String.valueOf(stats.getScore()));
        levelStat = new JLabel(String.valueOf(stats.getLevel()));
        ContinueAction continueAction = new ContinueAction(game, this);
        continueButton.addActionListener(continueAction);
        title = new JLabel("GAME" + (complete ? "COMPLETE" : "OVER"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getName() {
        return name;
    }
}
