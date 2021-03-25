package game.model.body;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import game.level.GameLevel;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class TNTExplosion extends DynamicBody {

    private static SoundClip explosionSound;

    private static final Shape explosionShape = new CircleShape(4f);

    private static final BodyImage explosionImage =
            new BodyImage("data/images/explosion.gif", 6f);


    public TNTExplosion(GameLevel level) {
        super(level, explosionShape);
        addImage(explosionImage);

        if (explosionSound == null) {
            try {
                explosionSound = new SoundClip("data/sounds/explosion.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

        explosionSound.play();
    }

    public static SoundClip getExplosionSound() {
        return explosionSound;
    }
}