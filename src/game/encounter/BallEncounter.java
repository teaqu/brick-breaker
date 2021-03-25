package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.level.GameLevel;
import game.model.body.*;
import org.jbox2d.common.Vec2;

public class BallEncounter extends Listener implements CollisionListener {

    private Ball ball;

    public BallEncounter(GameLevel level, Ball ball){
        super(level);
        this.ball = ball;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Board) {
            Board board = (Board) e.getOtherBody();
            float boardPos = e.getPosition().x - board.getPosition().x;
            ball.applyImpulse(new Vec2(ball.getLinearVelocity().x + 10*boardPos, 20));
        } if (e.getOtherBody() instanceof TNTBody) {
            TNTBody tnt = (TNTBody) e.getOtherBody();
            tnt.setFuse();
        } else {
            // Bounce ball away
            float ballPosX = ball.getPosition().x - e.getPosition().x;
            float ballPosY = ball.getPosition().y - e.getPosition().y;
            ball.applyImpulse(new Vec2(ballPosX*10, ballPosY*10));

            if (e.getOtherBody() instanceof Brick) {
                Brick brick = (Brick) e.getOtherBody();
                brick.damage();
            } else if (e.getOtherBody() instanceof Monster) {
                Monster monster = (Monster) e.getOtherBody();
                monster.jump(5);
                monster.damage();
            }
        }
        if (getLevel().isComplete()) {
            getGame().goToNextLevel();
        }
        ball.playSound();
    }
}