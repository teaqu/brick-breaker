package game.encounter;

import city.cs.engine.*;
import game.Listener;
import game.model.body.Monster;
import game.level.GameLevel;

/**
 * The monster hit something.
 */
public class MonsterEncounter extends Listener implements CollisionListener {

    Monster monster;

    public MonsterEncounter(GameLevel level, Monster monster) {
        super(level);
        this.monster = monster;
    }

    @Override
    public void collide(CollisionEvent e) {
        // Change direction
        monster.changeDirection();
    }
}
