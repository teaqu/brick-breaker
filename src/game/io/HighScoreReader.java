package game.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HighScoreReader {
    private String fileName;

    public HighScoreReader(String fileName) {
        this.fileName = fileName;
    }

    public void readScores() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                String name = tokens[0];
                int score = Integer.parseInt(tokens[1]);
                System.out.println("Name: " + name + ", Score: " + score);
                line = reader.readLine();
            }
            System.out.println("...done.");
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