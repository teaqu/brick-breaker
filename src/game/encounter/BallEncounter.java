package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.level.GameLevel;
import game.model.body.*;
import org.jbox2d.common.Vec2;

/**
 * Listen for any encounters with the ball.
 */
public class BallEncounter extends Listener implements CollisionListener {

    private Ball ball;

    public BallEncounter(GameLevel level, Ball ball) {
        super(level);
        this.ball = ball;
    }

    @Override
    public void collide(CollisionEvent e) {

        // Ball hits the board
        if (e.getOtherBody() instanceof Board) {
            Board board = (Board) e.getOtherBody();
            // Bounce the ball away from the board depending on it's position on
            // the board
            float boardPos = e.getPosition().x - board.getPosition().x;
            ball.applyImpulse(new Vec2(ball.getLinearVelocity().x + 10 * boardPos, 20));
        }
        // Ball hits TNT
        else if (e.getOtherBody() instanceof TNTBody) {
            TNTBody tnt = (TNTBody) e.getOtherBody();
            // Set the TNT fuse off!
            tnt.setFuse();
        } else {
            // Anything else just bounce ball away with some force
            float ballPosX = ball.getPosition().x - e.getPosition().x;
            float ballPosY = ball.getPosition().y - e.getPosition().y;
            ball.applyImpulse(new Vec2(ballPosX * 10, ballPosY * 10));

            // The ball hits a brick
            if (e.getOtherBody() instanceof Brick) {
                Brick brick = (Brick) e.getOtherBody();
                // Damage the brick (this will change colour)
                brick.damage();
            } else if (e.getOtherBody() instanceof Monster) {
                // Damage the monster and make it jump
                Monster monster = (Monster) e.getOtherBody();
                monster.jump(5);
                monster.damage();
            }
        }
        // Check if game is complete every encounter
        if (getLevel().isComplete()) {
            getGame().goToNextLevel();
        }

        // pop!
        ball.playSound();
    }
}