package game.layout;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.level.GameLevel;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    public GameView(GameLevel level, int width, int height) {
        super(level, width, height);
        setOpaque(false);
    }
}
