package game.io;

import game.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Save or load the game.
 */
public class GameSaverLoader {
    public void save(Game game, String fileName) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            // Write initial level stats to save
            writer.write(game.getLevel().getStartStats());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public void load(Game game, String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            // Get firs line of save
            String line = reader.readLine();
            String[] lineArr = line.split(",");
            // Update game stats
            game.getStats().importStats(line);
            // Start save level
            game.changeLevel(game.getLevelByNum(Integer.parseInt(lineArr[0])));

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

}
