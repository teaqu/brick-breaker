package game.model.body;

import city.cs.engine.AttachedImage;

import java.util.List;

public interface Direction {
    public float getDirection();
    public void changeDirection();
    public List<AttachedImage> getImages();
    public void destroy();
}
