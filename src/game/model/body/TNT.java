package game.model.body;

import game.encounter.ExplosionEncounter;
import game.level.GameLevel;
import game.sound.SoundClip;
import game.timer.TNTTimer;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class TNT {

    private enum State {
        STABLE, FUSE, EXPLODING
    }

    private static SoundClip boxSound;
    private static SoundClip fuseSound;

    private GameLevel level;
    private State state;
    private Timer timer;
    private TNTBody body;
    private TNTExplosion explosion;

    public TNT(GameLevel level) {
        this.level = level;
        state = State.STABLE;
        body = new TNTBody(level, this);

        // when hitting the box
        if (boxSound == null) {
            try {
                boxSound = new SoundClip("data/sounds/tnt_hit.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

        // sound of the fuse befor the explosion
        if (fuseSound == null) {
            try {
                fuseSound = new SoundClip("data/sounds/fuse.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    public void setPosition(Vec2 vec2) {
        this.body.setPosition(vec2);
    }

    public void setFuse() {
        boxSound.play();
        if (state == State.STABLE) {
            fuseSound.play();
            state = State.FUSE;
            // use a timer befor the explosion
            timer = new Timer(100, new TNTTimer(level, this));
            timer.start();
        }
    }

    public void explode() {
        explosion = new TNTExplosion(level);
        explosion.setPosition(this.body.getPosition());
        explosion.addCollisionListener(new ExplosionEncounter(level, explosion));
        state = State.EXPLODING;
    }

    public TNTBody getBody() {
        return body;
    }

    public TNTExplosion getExplosion() {
        return explosion;
    }

    public Timer getTimer() {
        return timer;
    }

}