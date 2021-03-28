package game.track;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Listener;
import game.model.body.Ball;
import game.level.GameLevel;
import org.jbox2d.common.Vec2;

/**
 * Follow the ball if it goes out of view
 */
public class BallTracker extends Listener implements StepListener {
    private Ball ball;
    public BallTracker(GameLevel level, Ball ball) {
        super(level);
        this.ball = ball;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        // We only follow the ball in y and when above y + 10 which is out of
        // the view
        float position = Math.max(0, ball.getPosition().y - 10);
        getGameView().setCentre(new Vec2(getGameView().getX(), position));
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}