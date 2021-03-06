package game.layout;

import game.Game;
import game.action.*;
import game.change.VolumeChange;

import javax.swing.*;
import java.awt.*;

/**
 * The game options menu
 */
public class OptionsMenu extends JPanel {
    private Game game;
    private JButton menu;
    private JButton back;
    private JSlider soundsVolume;
    private JSlider musicVolume;
    private JLabel title;
    private JLabel soundsLabel;
    private JLabel musicLabel;
    private JButton restartLevel;
    private JButton saveGame;
    private JButton loadGame;

    public OptionsMenu(Game game) {
        this.game = game;

        // Set layout to grid, nice for buttons
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add margin between buttons
        gbc.insets = new Insets(3, 3, 3, 3);

        // Create  buttons and their actions
        menu = new JButton("MAIN MENU");
        title = new JLabel("Options");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(0);

        // Create volume sliders
        soundsLabel = new JLabel("Sounds Volume");
        musicLabel = new JLabel("Music Volume");
        menu.addActionListener(new MainAction(game));
        soundsVolume = new JSlider();
        soundsVolume.setValue(game.getOptions().getSoundsVolume());
        soundsVolume.addChangeListener(new VolumeChange(game));
        musicVolume = new JSlider();
        musicVolume.setValue(game.getOptions().getMusicVolume());
        musicVolume.addChangeListener(new VolumeChange(game, true));

        // Add to the menu
        add(title, gbc);
        add(soundsLabel, gbc);
        add(soundsVolume, gbc);
        add(musicLabel, gbc);
        add(musicVolume, gbc);
        add(menu, gbc);

        // Only show these if we're playing a level (not from the main menu)
        if (game.getLevel() != null) {
            // Add level buttons
            restartLevel = new JButton("RESTART LEVEL");
            restartLevel.addActionListener(new RestartAction(game));
            saveGame = new JButton("SAVE GAME");
            saveGame.addActionListener(new SaveAction(game));
            loadGame = new JButton("LOAD GAME");
            loadGame.addActionListener(new LoadAction(game));
            back = new JButton("BACK");
            back.addActionListener(new BackAction(game));
            add(restartLevel, gbc);
            add(loadGame, gbc);
            add(saveGame, gbc);
            add(back, gbc);
        }
    }

}
