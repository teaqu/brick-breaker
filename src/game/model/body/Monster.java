package game.model.body;

import city.cs.engine.*;
import game.level.GameLevel;
import game.sensor.DirectionSensor;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Monster extends Walker implements Direction {

    private float direction;
    private float monsterLevel;
    private GameLevel level;
    private static SoundClip monsterSound;

    private static final Shape monsterShape = new PolygonShape(
            -1.087f,0.978f, 1.087f,0.955f, 1.082f,0.177f, 0.425f,-0.976f, -0.604f,-0.976f, -1.078f,-0.306f
    );

    private static final BodyImage l1Image =
            new BodyImage("data/images/monster.png", 2f);

    private static final BodyImage l1Image2 =
            new BodyImage("data/images/monster2.png", 2f);

    private static final BodyImage l2Image =
            new BodyImage("data/images/monster_l2.png", 2f);

    private static final BodyImage l2Image2 =
            new BodyImage("data/images/monster2_l2.png", 2f);

    private static final BodyImage deadImage =
            new BodyImage("data/images/monster_dead.png", 2.2f);

    private static final BodyImage deadImage2 =
            new BodyImage("data/images/monster_dead2.png", 2.2f);

    public Monster(GameLevel level) {
        this(level, 0);
    }

    public Monster(GameLevel level, int monsterLevel) {
        super(level, monsterShape);
        this.level = level;
        this.direction = Math.random() > 0.5 ? 2f : -2f;
        this.setMonsterLevel(monsterLevel);
        this.startWalking(this.direction);

        if (monsterSound == null) {
            try {
                monsterSound = new SoundClip("data/sounds/monster.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    public float getMonsterLevel() {
        return monsterLevel;
    }

    public void setMonsterLevel(float monsterLevel) {
        removeAllImages();
        if (monsterLevel > 0) {
            addImage(l2Image);
            addImage(l2Image2);
        } else {
            addImage(l1Image);
            addImage(l1Image2);
        }
        this.monsterLevel = monsterLevel;
    }

    public void damage() {
        setMonsterLevel(monsterLevel - 1);
        monsterSound.play();
        if (monsterLevel < 0) {
            kill();
        }
    }

    public float getDirection() {
        return direction;
    }

    public void changeDirection() {
        this.direction *= -1;
        this.startWalking(this.direction);
    }

    public void kill() {
        removeAllImages();
        addImage(deadImage);
        addImage(deadImage2);
        getFixtureList().get(0).destroy();
        level.removeConsumableBody(this);
        Sensor sensor = new Sensor(this, monsterShape);
        sensor.addSensorListener(new DirectionSensor(level, this));

    }
}
