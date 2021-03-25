package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.model.body.Ball;
import game.model.body.Bird;
import game.level.GameLevel;

public class BirdEncounter extends Listener implements CollisionListener {

    Bird bird;

    public BirdEncounter(GameLevel level, Bird bird) {
        super(level);
        this.bird = bird;
    }

    @Override
    public void collide(CollisionEvent e) {
        bird.changeDirection();

        if (e.getOtherBody() instanceof Ball) {
            getStats().addScore(3);
            bird.kill();
        }
    }
}
