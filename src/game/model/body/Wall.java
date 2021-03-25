package game.model.body;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import game.level.GameLevel;

public class Wall extends StaticBody {

    private float halfWidth;
    private float halfHeight;

    public Wall(GameLevel gameLevel, float halfWidth, float halfHeight) {
        super(gameLevel, new BoxShape(halfWidth, halfHeight));
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

}