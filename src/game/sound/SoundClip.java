package game.sound;

import game.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundClip extends city.cs.engine.SoundClip {
    private Game game;
    private String fileName;

    public SoundClip(String fileName, Game game) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(fileName);
        this.game = game;
        this.fileName = fileName;
    }

    @Override
    public void play() {
        this.setOptionsVolume();
        super.play();
    }

    @Override
    public void loop() {
        this.setOptionsVolume();
        super.loop();
    }

    private void setOptionsVolume() {
        if (fileName.contains(".mp3")) {
            this.setVolume(game.getOptions().getMusicClipVolume());
        } else {
            this.setVolume(game.getOptions().getSoundsClipVolume());
        }
    }

}
