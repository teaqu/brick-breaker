package game.destruction;

import city.cs.engine.*;
import game.Listener;
import game.model.body.Brick;
import game.model.body.Coin;
import game.level.GameLevel;

/**
 * Listen for any bricks that are destroyed
 */
public class BrickDestruction extends Listener implements DestructionListener {

    Brick brick;

    public BrickDestruction(GameLevel level, Brick brick) {
        super(level);
        this.brick = brick;
    }

    @Override
    public void destroy(DestructionEvent destructionEvent) {
        // Create a new coin at the brick's position
        Coin coin = new Coin(getLevel());
        coin.setPosition(brick.getPosition());

        // Add score for destroying brick
        getStats().addScore(1);

        // Remove the brick from the level
        getLevel().removeConsumableBody(brick);
    }
}
