package game.track;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Listener;
import game.model.body.Bird;
import game.level.GameLevel;
import org.jbox2d.common.Vec2;

public class BirdTracker extends Listener implements StepListener {
    Bird bird;

    public BirdTracker(GameLevel level, Bird bird) {
        super(level);

        // Animate and give the bird a direction
        AnimationTracker animationTracker = new AnimationTracker(getLevel(), bird);
        DirectionTracker directionTracker = new DirectionTracker(getLevel(), bird);
        getLevel().addStepListener(animationTracker);
        getLevel().addStepListener(directionTracker);
        this.bird = bird;
    }

    /**
     * change direction whenever the bird hits another body
     * @param stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        bird.move(new Vec2(bird.getDirection(), 0));
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }
}