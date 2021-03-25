package game.level;

import game.Game;
import game.model.body.Brick;
import game.model.body.TNT;
import game.destruction.BrickDestruction;
import org.jbox2d.common.Vec2;

public class Level6 extends GameLevel {
    public Level6(Game game) {
        super(game);
        genWallsMed();
        setMusic("music/passing_time.mp3");

        // 5 level 1 bricks side by side
        for (int i = 0; i < 20; i++) {
            Brick brick = new Brick(this, 2);
            brick.setPosition(new Vec2(
                    -6 + i * 3 - (i / 5) * 3 * 5,
                    2 + (i / 5) * 2)
            );
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

        TNT tnt = new TNT(this);
        tnt.setPosition(new Vec2(0, 15));
    }
}