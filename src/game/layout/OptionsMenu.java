package game.layout;

import game.Game;
import game.action.MainAction;
import game.change.VolumeChange;

import javax.swing.*;

public class OptionsMenu {
    private Game game;
    private JButton back;
    private JPanel mainPanel;
    private JSlider soundsVolume;
    private JSlider musicVolume;

    public OptionsMenu(Game game) {
        this.game = game;
    }

    private void createUIComponents() {
        back = new JButton("BACK");
        back.addActionListener(new MainAction(game));
        soundsVolume = new JSlider();
        soundsVolume.setValue(game.getOptions().getSoundsVolume());
        soundsVolume.addChangeListener(new VolumeChange(game));
        musicVolume = new JSlider();
        musicVolume.setValue(game.getOptions().getMusicVolume());
        musicVolume.addChangeListener(new VolumeChange(game, true));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
