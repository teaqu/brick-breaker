package game.model.body;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import game.level.GameLevel;

public class Platform extends StaticBody {

    private float halfWidth;
    private float halfHeight;

    public Platform(GameLevel gameLevel, float halfWidth, float halfHeight) {
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