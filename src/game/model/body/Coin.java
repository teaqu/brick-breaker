package game.model.body;

import city.cs.engine.*;
import game.level.GameLevel;
import game.sensor.CoinSensor;

public class Coin extends DynamicBody {

    private static final Shape coinShape = new CircleShape(0.5f);

    private static final BodyImage image =
            new BodyImage("data/images/coin.gif", 2f);

    public Coin(GameLevel level) {
        super(level, coinShape);
        addImage(image);

        // So coins will only collide with lasers and the board
        getFixtureList().get(0).destroy();
        
        Sensor sensor = new Sensor(this, coinShape);
        sensor.addSensorListener(new CoinSensor(level, this));
    }
}
