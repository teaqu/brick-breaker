package game.track;

import city.cs.engine.AttachedImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Listener;
import game.model.body.Direction;
import game.level.GameLevel;

import java.util.List;

/**
 * Allows our Direction bodies to face left or right.
 */
public class DirectionTracker extends Listener implements StepListener {
    Direction direction;

    // So we can track when the direction changes
    private float curDirection;

    public DirectionTracker(GameLevel level, Direction direction) {
        super(level);
        this.direction = direction;
        curDirection = direction.getDirection();

        // Change direction (of the images) if direction is wrong
        if (curDirection > 0) {
            changeDirection();
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // if direction has changed
        if (curDirection != direction.getDirection()) {
            // change direction and set new currDirection
            curDirection = direction.getDirection();
            changeDirection();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

    private void changeDirection() {
        // Flip all the images
        List<AttachedImage> images = direction.getImages();
        for(AttachedImage image : images) {
            image.flipHorizontal();
        }
    }
}