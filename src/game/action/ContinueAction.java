package game.action;

import game.Game;
import game.io.HighScoreWriter;
import game.layout.EndGame;
import game.layout.HighScores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Save and continue on to HighScores page after game over.
 */
public class ContinueAction implements ActionListener {

    private Game game;
    private EndGame endGame;

    public ContinueAction(Game game, EndGame endGame) {
        this.game = game;
        this.endGame = endGame;
    }

    public void actionPerformed(ActionEvent e) {

        // Write highscores
        HighScoreWriter highScoreWriter = new HighScoreWriter("data/highscores.txt");
        try {
            highScoreWriter.writeHighScore(
                    endGame.getName().getText(), // Name entered by user
                    game.getStats().getScore()
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // Redirect to highscores page
        game.resetFrame();
        game.getFrame().add(new HighScores(game).getMainPanel());

        // Clear the game so we can play again with fresh data
        game.reset();
    }

}