package game.model.body;

import city.cs.engine.*;
import game.sound.SoundClip;
import game.level.GameLevel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The ball for destorying bricks and creatures
 */
public class Ball extends DynamicBody {

    private static final Shape ballShape = new CircleShape(0.5f);
    private static SoundClip ballSound;

    public Ball(GameLevel level) {
        super(level,ballShape);

        if (ballSound == null) {
            try {
                ballSound = new SoundClip("data/sounds/ball.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    public void playSound() {
        ballSound.play();
    }
}
