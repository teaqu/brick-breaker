package game.destruction;

import city.cs.engine.*;
import game.Listener;
import game.model.body.Brick;
import game.model.body.Coin;
import game.level.GameLevel;

public class BrickDestruction extends Listener implements DestructionListener {

    Brick brick;

    public BrickDestruction(GameLevel level, Brick brick) {
        super(level);
        this.brick = brick;
    }

    @Override
    public void destroy(DestructionEvent destructionEvent) {
        Coin coin = new Coin(getLevel());
        coin.setPosition(brick.getPosition());
        getStats().addScore(1);
        getLevel().removeConsumableBody(brick);
    }
}
