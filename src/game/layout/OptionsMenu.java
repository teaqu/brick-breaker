package game.layout;

import game.Game;
import game.action.BackAction;
import game.action.MainAction;
import game.action.RestartAction;
import game.change.VolumeChange;
import game.level.GameLevel;

import javax.swing.*;
import java.awt.*;

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

    public OptionsMenu(Game game) {
        this.game = game;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add margin between buttons
        gbc.insets = new Insets(3, 3, 3, 3);

        menu = new JButton("MAIN MENU");
        back = new JButton("BACK");
        back.addActionListener(new BackAction(game));
        title = new JLabel("Options");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(0);
        soundsLabel = new JLabel("Sounds Volume");
        musicLabel = new JLabel("Music Volume");
        menu.addActionListener(new MainAction(game));
        soundsVolume = new JSlider();
        soundsVolume.setValue(game.getOptions().getSoundsVolume());
        soundsVolume.addChangeListener(new VolumeChange(game));
        musicVolume = new JSlider();
        musicVolume.setValue(game.getOptions().getMusicVolume());
        musicVolume.addChangeListener(new VolumeChange(game, true));
        restartLevel = new JButton("RESTART LEVEL");
        restartLevel.addActionListener(new RestartAction(game));

        add(title, gbc);
        add(soundsLabel, gbc);
        add(soundsVolume, gbc);
        add(musicLabel, gbc);
        add(musicVolume, gbc);
        add(menu, gbc);
        if (game.getLevel() != null) {
            add(restartLevel, gbc);
            add(back, gbc);
        }
    }

}
