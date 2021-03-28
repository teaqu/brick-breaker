package game;

import game.layout.GameView;
import game.level.GameLevel;
import game.model.Stats;

public class Listener {
    private GameLevel level;

    public Listener(GameLevel level) {
        this.level = level;
    }

    public Game getGame() {
        return level.getGame();
    }

    public GameLevel getLevel() {
        return level;
    }

    public Stats getStats() {
        return level.getStats();
    }

    public GameView getGameView() {
        return level.getGameView();
    }
}
