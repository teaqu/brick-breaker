package game.sensor;

import city.cs.engine.*;
import game.Listener;
import game.level.GameLevel;
import game.model.body.Direction;
import game.model.body.Laser;
import game.model.body.Wall;

/**
 * This is used as a replacement for the fixture so that we can
 * kill birds and monsters and then have them fall through the map
 * only bouncing against walls and nothing else.
 */
public class DirectionSensor extends Listener implements SensorListener {

    /**
     * Monsters and Birds both implement Direction
     */
    private Direction direction;

    public DirectionSensor(GameLevel level, Direction direction) {
        super(level);
        this.direction = direction;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        // If it's a wall, bounce off it
        if (sensorEvent.getContactBody() instanceof Wall) {
            direction.changeDirection();
        } else if (sensorEvent.getContactBody() instanceof Laser) {
            direction.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
