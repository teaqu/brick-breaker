package game.layout;

import game.Game;
import game.action.MainAction;
import game.io.HighScoreReader;

import javax.swing.*;
import java.io.IOException;

public class HighScores {
    private JPanel mainPanel;
    private JButton back;
    private JTable scoresTable;
    private Game game;

    public HighScores(Game game) {
        this.game = game;
    }

    private void createUIComponents() throws IOException {
        HighScoreReader reader = new HighScoreReader("data/highscores.txt");
        back = new JButton("BACK");
        back.addActionListener(new MainAction(game));
        String[] cols = {"name", "score"};
        scoresTable = new JTable(reader.readScores(), cols);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
