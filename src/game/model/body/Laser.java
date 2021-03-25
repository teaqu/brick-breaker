package game.model.body;

import game.encounter.LaserEncounter;
import game.level.GameLevel;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Laser extends Platform {

    public Laser(GameLevel gameLevel, float halfWidth, float halfHeight) {
        super(gameLevel, halfWidth, halfHeight);
    }

    public Laser(GameLevel level) {
        super(level, 12, .1f);
        this.setPosition(new Vec2(0, -11.9f));
        this.setFillColor(Color.red);
        this.setLineColor(Color.red);
        this.addCollisionListener(new LaserEncounter(level, this));
    }
}
