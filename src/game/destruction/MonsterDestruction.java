package game.destruction;

import city.cs.engine.DestructionEvent;
import city.cs.engine.DestructionListener;
import game.Listener;
import game.model.body.Monster;
import game.level.GameLevel;

/**
 * Listen for dead monsters
 */
public class MonsterDestruction extends Listener implements DestructionListener {

    Monster monster;

    public MonsterDestruction(GameLevel level, Monster monster) {
        super(level);
        this.monster = monster;
    }

    @Override
    public void destroy(DestructionEvent destructionEvent) {
        // Add to our score
        getStats().addScore(1);

        // remove the monster from the level
        getLevel().removeConsumableBody(monster);
    }
}
