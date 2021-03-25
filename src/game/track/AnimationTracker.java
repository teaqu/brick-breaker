package game.track;

import city.cs.engine.AttachedImage;
import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Listener;
import game.level.GameLevel;

import java.util.List;

/**
 * Animate the creatures by rotating their images.
 */
public class AnimationTracker extends Listener implements StepListener {
    Body body;
    int count = 0;

    public AnimationTracker(GameLevel level, Body body) {
        super(level);
        this.body = body;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (++count % 30 == 0) {
            List<AttachedImage> images = body.getImages();
            body.removeAllImages();

            // Add first image to the end
            AttachedImage first = images.get(0);
            images.remove(0);
            images.add(first);

            // Add images in new order
            for (int i = 0; i < images.size(); i++) {
                body.addImage(images.get(i).getBodyImage());

                // Add flipped if flipped
                if (images.get(i).isFlippedHorizontal()) {
                    body.getImages().get(i).flipHorizontal();
                }
            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }
}