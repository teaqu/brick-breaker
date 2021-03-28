package game.io;

import game.Game;
import game.level.GameLevel;

import java.io.*;
import java.util.ArrayList;

public class GameSaverLoader {
    public void save(Game game, String fileName) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
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
            String line = reader.readLine();
            String[] lineArr = line.split(",");
            game.getStats().importStats(line);
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
