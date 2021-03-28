package game.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read our high scores
 */
public class HighScoreReader {
    private String fileName;

    public HighScoreReader(String fileName) {
        this.fileName = fileName;
    }

    public Object[][] readScores() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            // Add lines to data list
            ArrayList<String[]> data = new ArrayList<>();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                data.add(line.split(","));
                line = reader.readLine();
            }
            // Sort by score desc
            data.sort((o1, o2) -> Integer.valueOf(o2[1]).compareTo(Integer.valueOf(o1[1])));

            // Return array of our scores
            return data.toArray(new Object[data.size()][]);
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