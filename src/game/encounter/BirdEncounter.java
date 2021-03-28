package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.model.body.Ball;
import game.model.body.Bird;
import game.level.GameLevel;

/**
 * The bird has hit something
 */
public class BirdEncounter extends Listener implements CollisionListener {

    Bird bird;

    public BirdEncounter(GameLevel level, Bird bird) {
        super(level);
        this.bird = bird;
    }

    @Override
    public void collide(CollisionEvent e) {
        // Every time the bird hits anything, change direction
        bird.changeDirection();

        // The ball has hit the bird
        if (e.getOtherBody() instanceof Ball) {
            // Give a generous score
            getStats().addScore(3);

            // Kill the bird so it'll fall from the sky
            bird.kill();
        }
    }
}
