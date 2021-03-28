package game.encounter;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Listener;
import game.level.GameLevel;
import game.model.body.Bird;
import game.model.body.Brick;
import game.model.body.Monster;
import game.model.body.TNTExplosion;

/**
 * Destroy anything in contact with the explosion.
 * Explosions are caused by TNT going off.
 */
public class ExplosionEncounter extends Listener implements CollisionListener {

    private TNTExplosion explosion;

    public ExplosionEncounter(GameLevel level, TNTExplosion explosion){
        super(level);
        this.explosion = explosion;
    }

    @Override
    public void collide(CollisionEvent e) {

        // Destroy birds, bricks and monsters
        if (e.getOtherBody() instanceof Bird) {
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Brick) {
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Monster) {
            e.getOtherBody().destroy();
        }
    }
}