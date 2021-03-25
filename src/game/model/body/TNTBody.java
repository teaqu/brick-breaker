package game.model.body;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import game.level.GameLevel;

public class TNTBody extends DynamicBody {

    private static final Shape boxShape = new BoxShape(1f, 1f);
    private TNT tnt;

    private static final BodyImage tntImage =
            new BodyImage("data/images/tnt.png", 2f);

    public TNTBody(GameLevel level, TNT tnt) {
        super(level, boxShape);
        addImage(tntImage);
        this.tnt = tnt;
    }

    public void setFuse() {
        tnt.setFuse();
    }

    public static BodyImage getTntImage() {
        return tntImage;
    }
}