package game.model.body;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.level.GameLevel;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Brick extends StaticBody {

    private int brickLevel;
    private static SoundClip brickSound;

    private Color[] colours = {
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.RED
    };

    private static final Shape brickShape = new BoxShape(1f, 0.5f);

    public Brick(GameLevel gameLevel, int brickLevel) {
        super(gameLevel, brickShape);
        this.setBrickLevel(brickLevel);

        if (brickSound == null) {
            try {
                brickSound = new SoundClip("data/sounds/bling.wav", gameLevel.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

    }

    public Brick(GameLevel gameLevel) {
        this(gameLevel, 0);
    }

    public int getBrickLevel() {
        return brickLevel;
    }

    public void damage() {
        brickSound.play();
        setBrickLevel(brickLevel - 1);
    }

    public void setBrickLevel(int brickLevel) {
        this.brickLevel = brickLevel;
        if (this.brickLevel >= 0) {
            this.setFillColor(colours[brickLevel]);
        } else {
            this.destroy();
        }
    }
}