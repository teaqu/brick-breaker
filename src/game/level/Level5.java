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

public class Level5 extends GameLevel {
    public Level5(Game game){
        super(game);
        genWalls();
        setMusic("music/passing_time.mp3");

        // Set of 5 bricks
        for (int i = 0; i < 5; i++) {
            Brick brick = new Brick(this);
            brick.setPosition(new Vec2(-6 + i * 3, 2));
            brick.addDestructionListener(new BrickDestruction(this, brick));
            addConsumableBody(brick);
        }

        // Two birds top of map
        for (int i = 0; i < 2; i++) {
            Bird bird = new Bird(this);
            bird.setPosition(new Vec2(i * 2, 10 - i * 3));
            BirdEncounter birdListener = new BirdEncounter(this, bird);
            BirdTracker birdTracker = new BirdTracker(this, bird);
            this.addStepListener(birdTracker);
            bird.addCollisionListener(birdListener);
            addConsumableBody(bird);
        }

        // Platform for our monster
        Platform platform = new Platform(this, 2f, 0.1f);
        platform.setPosition(new Vec2(-10, 3));

        // Put monster on platform
        Monster monster = new Monster(this, 1);
        monster.setPosition(new Vec2(-10, 5));
        MonsterEncounter monsterListener = new MonsterEncounter(this, monster);
        MonsterTracker monsterTracker = new MonsterTracker(this, monster, platform);
        this.addStepListener(monsterTracker);
        monster.addCollisionListener(monsterListener);
        addConsumableBody(monster);
    }
}