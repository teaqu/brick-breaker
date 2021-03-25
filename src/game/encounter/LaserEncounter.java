package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.model.body.Ball;
import game.model.body.Laser;
import game.level.GameLevel;

/**
 * Laser below the board that destroys balls and creatures.
 */
public class LaserEncounter extends Listener implements CollisionListener {

    private Laser laser;

    public LaserEncounter(GameLevel level, Laser laser) {
        super(level);
        this.laser = laser;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ball) {
            // Reduce lives
            int lives = getStats().getLives();
            getStats().setLives(--lives);
            if (lives < 1) {
                getGame().gameOver();
            }

            // Put new ball on map
            getLevel().newBall();
        }
        getLevel().removeConsumableBody(e.getOtherBody());
        e.getOtherBody().destroy();
    }
}