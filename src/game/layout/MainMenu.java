package game.layout;

import game.Game;
import game.action.HighScoresAction;
import game.action.OptionsAction;
import game.action.PlayAction;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends ImagePanel {

    private JButton play;
    private JButton options;
    private JButton highScores;

    public MainMenu(Game game) {
        super("data/images/background.png");
        play = new JButton("PLAY");
        options = new JButton("OPTIONS");
        highScores = new JButton("HIGH SCORES");

        // Vertical alignment
        // https://stackoverflow.com/a/22933763/2047666
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add margin between buttons
        gbc.insets = new Insets(3, 3, 3, 3);

        // Add buttons
        add(play, gbc);
        add(options, gbc);
        add(highScores, gbc);
        play.addActionListener(new PlayAction(game));
        options.addActionListener(new OptionsAction(game));
        highScores.addActionListener(new HighScoresAction(game));
    }

}
