package game.level;

import game.Game;
import game.model.body.Brick;
import game.destruction.BrickDestruction;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level2 extends GameLevel {

    public Level2(Game game){
        super(game);
        setBackground(new ImageIcon("data/images/background2.png").getImage());
        genWalls();
        setMusic("music/rolling.mp3");

        // 5 level 1 bricks side by side
        for (int i = 0; i < 5; i++) {
            Brick brick = new Brick(this);
            brick.setPosition(new Vec2(-6 + i * 3, 4));
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

        // 5 level 2 bricks side by side
        for (int i = 0; i < 5; i++) {
            Brick brick = new Brick(this, 1);
            brick.setPosition(new Vec2(-6 + i * 3, 2));
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

    }
}