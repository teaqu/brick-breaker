package game.model.body;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.level.GameLevel;

import java.awt.*;

public class Board extends StaticBody {

    public float walking_speed = 0.5f;

    public boolean left = false;
    public boolean right = false;

    private static final Shape boardShape = new BoxShape(1.5f, 0.2f);

    public Board(GameLevel gameLevel) {
        super(gameLevel, boardShape);
        this.setFillColor(new Color(255, 0, 0));
        this.setLineColor(new Color(255, 0, 255));
    }

}