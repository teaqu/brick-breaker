package game.action;

import game.Game;
import game.io.HighScoreWriter;
import game.layout.EndGame;
import game.layout.HighScores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContinueAction implements ActionListener {

    private Game game;
    private EndGame endGame;

    public ContinueAction(Game game, EndGame endGame) {
        this.game = game;
        this.endGame = endGame;
    }

    public void actionPerformed(ActionEvent e) {
        HighScoreWriter highScoreWriter = new HighScoreWriter("data/highscores.txt");
        try {
            highScoreWriter.writeHighScore(
                    endGame.getName().getText(),
                    game.getStats().getScore()
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // We create a new highscores with new data
        // Updating the JTable is difficult so easier to create new panel
        game.setHighScores(new HighScores(game));
        game.resetFrame();
        game.getFrame().add(game.getHighScores().getMainPanel());

        // Clear the game
        game.reset();
    }

}