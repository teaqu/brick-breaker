package game.layout;

import game.Game;
import game.action.MainAction;
import game.io.HighScoreReader;

import javax.swing.*;
import java.io.IOException;

/**
 * Highscores page
 */
public class HighScores {
    private JPanel mainPanel;
    private JButton main;
    private JTable scoresTable;
    private Game game;
    private  HighScoreReader reader;

    public HighScores(Game game) {
        this.game = game;
    }

    private void createUIComponents() throws IOException {
        // Get high scores from txt
        reader = new HighScoreReader("data/highscores.txt");

        // Add to scores JTable
        String[] cols = {"name", "score"};
        scoresTable = new JTable(reader.readScores(), cols);

        // Back to main menu
        main = new JButton("MAIN MENU");
        main.addActionListener(new MainAction(game));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
