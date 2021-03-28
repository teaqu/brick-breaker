package game.level;

import game.Game;
import game.model.body.Bird;
import game.model.body.Brick;
import game.model.body.Monster;
import game.model.body.Platform;
import game.destruction.BrickDestruction;
import game.encounter.BirdEncounter;
import game.encounter.MonsterEncounter;
import game.track.BirdTracker;
import game.track.MonsterTracker;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level5 extends GameLevel {
    public Level5(Game game){
        super(game);
        genWallsTall();
        setMusic("music/passing_time.mp3");
        setBackground(new ImageIcon("data/images/background5.png").getImage());
        setTextColour(new Color(255, 255, 255));

        // Platform for our monster
        Platform platform = new Platform(this, 4f, 0.1f);
        platform.setPosition(new Vec2(0, 5));

        // Put monster on platform
        for (int i = 0; i < 3; i++) {
            Monster monster = new Monster(this, 1);
            monster.setPosition(new Vec2(-2 + i*3, 5));
            MonsterEncounter monsterListener = new MonsterEncounter(this, monster);
            MonsterTracker monsterTracker = new MonsterTracker(this, monster, platform);
            this.addStepListener(monsterTracker);
            monster.addCollisionListener(monsterListener);
            addConsumableBody(monster);
        }

        for (int i = 0; i < 8; i++) {
            Brick brick = new Brick(this, 1);
            brick.setPosition(new Vec2(-7 + i * 2, 12));
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

    }
}