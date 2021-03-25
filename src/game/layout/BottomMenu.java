package game.layout;

import game.action.PauseAction;
import game.action.QuitAction;
import game.action.RestartAction;
import game.level.GameLevel;
import game.model.Stats;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomMenu implements ChangeListener {
    private final Stats stats;
    private JPanel mainPanel;
    private JLabel scoreStat;
    private JLabel livesStat;
    private JLabel levelStat;
    private JLabel remainingStat;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private GameLevel level;

    public BottomMenu(GameLevel level, Stats stats) {
        this.level = level;
        this.stats = stats;
        stats.addChangeListener(this);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        scoreStat = new JLabel(String.valueOf(stats.getScore()));
        livesStat = new JLabel(stats.getHearts());
        levelStat = new JLabel(String.valueOf(stats.getLevel()));
        remainingStat = new JLabel(String.valueOf(stats.getRemaining()));

        quitButton = new JButton("Quit");
        pauseButton = new JButton("Pause");
        restartButton = new JButton("Restart");
        restartButton.addActionListener(new RestartAction(level));
        pauseButton.addActionListener(new PauseAction(level));
        quitButton.addActionListener(new QuitAction());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        scoreStat.setText(String.valueOf(stats.getScore()));
        livesStat.setText(stats.getHearts());
        levelStat.setText(String.valueOf(stats.getLevel()));
        remainingStat.setText(String.valueOf(stats.getRemaining()));
    }

}
