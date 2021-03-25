package game.model.body;

import city.cs.engine.*;
import game.level.GameLevel;
import game.sensor.DirectionSensor;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Bird extends DynamicBody implements Direction {

    private float direction;
    private GameLevel level;
    private static SoundClip birdSound;

    private static final Shape birdShape = new PolygonShape(
            -1.056f, 0.474f, 0.585f, 0.982f, 1.079f, 0.153f, 1.11f, -0.378f, 0.485f, -0.668f, -0.734f, -0.754f, -1.128f, 0.017f
    );

    private static final BodyImage birdImage =
            new BodyImage("data/images/bird.png", 2f);

    private static final BodyImage birdImage2 =
            new BodyImage("data/images/bird2.png", 2f);

    private static final BodyImage deadBirdImage =
            new BodyImage("data/images/bird_dead.png", 2f);

    private static final BodyImage deadBirdImage2 =
            new BodyImage("data/images/dead_bird2.png", 2f);

    public Bird(GameLevel level) {
        super(level, birdShape);
        this.level = level;
        this.direction = Math.random() > 0.5 ? 0.1f : -0.1f;
        this.setGravityScale(0);
        addImage(birdImage);
        addImage(birdImage2);

        if (birdSound == null) {
            try {
                birdSound = new SoundClip("data/sounds/bird.wav", level.getGame());
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    public float getDirection() {
        return direction;
    }

    public void changeDirection() {
        this.direction *= -1;
    }

    public void kill() {
        setGravityScale(1);
        removeAllImages();
        addImage(deadBirdImage);
        addImage(deadBirdImage2);
        level.removeConsumableBody(this);
        birdSound.play();

        getFixtureList().get(0).destroy();
        Sensor sensor = new Sensor(this, birdShape);
        sensor.addSensorListener(new DirectionSensor(level, this));
    }
}
