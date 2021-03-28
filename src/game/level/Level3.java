package game.level;

import game.Game;
import game.model.body.Bird;
import game.model.body.Brick;
import game.destruction.BrickDestruction;
import game.encounter.BirdEncounter;
import game.track.BirdTracker;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level3 extends GameLevel {
    public Level3(Game game){
        super(game);
        setBackground(new ImageIcon("data/images/background2.png").getImage());
        genWallsTall();
        setMusic("music/inspiration.mp3");

        // Brick in view
        Brick brick = new Brick(this);
        brick.setPosition(new Vec2(0, 10));
        brick.addDestructionListener(new BrickDestruction(this, brick));
        addConsumableBody(brick);

        // High altitude brick
        Brick brick2 = new Brick(this, 3);
        brick2.setPosition(new Vec2(5, 20));
        brick2.addDestructionListener(new BrickDestruction(this, brick2));
        addConsumableBody(brick2);

        // 3 high altitude birds
        for (int i = 0; i < 3; i++) {
            Bird bird = new Bird(this);
            bird.setPosition(new Vec2(i * 2, 20 - i * 6));
            BirdEncounter birdListener = new BirdEncounter(this, bird);
            BirdTracker birdTracker = new BirdTracker(this, bird);
            this.addStepListener(birdTracker);
            bird.addCollisionListener(birdListener);
            addConsumableBody(bird);
        }

    }
}