package game.level;

import game.Game;
import game.model.body.Brick;
import game.model.body.TNT;
import game.destruction.BrickDestruction;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level6 extends GameLevel {
    public Level6(Game game) {
        super(game);
        genWallsMed();
        setMusic("music/passing_time.mp3");
        setBackground(new ImageIcon("data/images/background6.png").getImage());
        setTextColour(new Color(255, 255, 255));

        // 20 level 2 bricks together as a giant brick
        for (int i = 0; i < 20; i++) {
            Brick brick = new Brick(this, 2);
            brick.setPosition(new Vec2(
                    -6 + i * 2 - (i / 5) * 2 * 5,
                    2 + (i / 5))
            );
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

        // Boom! Add TNT atop the bricks
        TNT tnt = new TNT(this);
        tnt.setPosition(new Vec2(0, 15));
    }
}