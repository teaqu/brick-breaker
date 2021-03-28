package game.layout;

import city.cs.engine.UserView;
import game.level.GameLevel;

/**
 * Shows the game world
 */
public class GameView extends UserView {
    public GameView(GameLevel level, int width, int height) {
        super(level, width, height);
        setOpaque(false);
    }
}
