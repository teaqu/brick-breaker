package game.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Save high scores
 */
public class HighScoreWriter {
    private String fileName;

    public HighScoreWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeHighScore(String name, int score)
            throws IOException {
        // Add new score to end of the file
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            // Write name and score
            writer.write(name + "," + score + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}