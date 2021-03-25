package game.level;

import game.Game;
import game.model.body.Brick;
import game.destruction.BrickDestruction;
import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel {

    public Level1(Game game){
        super(game);
        genWalls();
        setMusic("music/young_love.mp3");

        // 5 level 1 bricks side by side
        for (int i = 0; i < 5; i++) {
            Brick brick = new Brick(this);
            brick.setPosition(new Vec2(-6 + i * 3, 2));
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }
    }
}