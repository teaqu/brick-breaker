package game.sensor;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.Listener;
import game.level.GameLevel;
import game.model.body.Board;
import game.model.body.Coin;
import game.model.body.Laser;

/**
 * This is used as a replacement for the fixture so that we can
 * kill birds and monsters and then have them fall through the map
 * only bouncing against walls and nothing else.
 */
public class CoinSensor extends Listener implements SensorListener {

    /**
     * Monsters and Birds both implement Direction
     */
    private Coin coin;

    public CoinSensor(GameLevel level, Coin coin) {
        super(level);
        this.coin = coin;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        // If it's a wall, bounce off it
        if (sensorEvent.getContactBody() instanceof Laser) {
            coin.destroy();
        } else if (sensorEvent.getContactBody() instanceof Board) {
            getStats().addScore(2);
            coin.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
