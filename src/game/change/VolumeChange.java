package game.change;

import game.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolumeChange implements ChangeListener {

    private final Game game;
    private final boolean music;

    public VolumeChange(Game game) {
        this.game = game;
        this.music = false;
    }

    /**
     * @param music if we are changing the music volume
     */
    public VolumeChange(Game game, boolean music) {
        this.game = game;
        this.music = music;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider volumeSlider = (JSlider) e.getSource();
        if (music) {
            game.getOptions().setMusicVolume(volumeSlider.getValue());
        } else {
            game.getOptions().setSoundsVolume(volumeSlider.getValue());
        }
    }
}
