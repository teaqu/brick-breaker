package game.action;

import game.Game;
import game.io.GameSaverLoader;
import game.io.HighScoreWriter;
import game.layout.HighScores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveAction implements ActionListener {

    Game game;

    public SaveAction(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        GameSaverLoader gameSaverLoader = new GameSaverLoader();
        try {
           gameSaverLoader.save(game, "data/save.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}