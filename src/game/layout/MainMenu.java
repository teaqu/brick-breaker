package game.layout;

import game.Game;
import game.action.OptionsAction;
import game.action.PlayAction;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private Image background;

    private JButton play;
    private JButton options;

    public MainMenu(Game game) {
        background = new ImageIcon("data/images/background.png").getImage();
        play = new JButton("PLAY");
        options = new JButton("OPTIONS");

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
        play.addActionListener(new PlayAction(game));
        options.addActionListener(new OptionsAction(game));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }
}
