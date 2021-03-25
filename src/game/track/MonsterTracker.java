package game.track;

import city.cs.engine.*;
import game.Listener;
import game.model.body.Monster;
import game.model.body.Platform;
import game.level.GameLevel;

public class MonsterTracker extends Listener implements StepListener {

    Monster monster;
    Platform platform;

    int count = 0;

    public MonsterTracker(GameLevel level, Monster monster, Platform platform) {
        super(level);

        // Animate and give the monster a direction
        AnimationTracker animationTracker = new AnimationTracker(getLevel(), monster);
        DirectionTracker directionTracker = new DirectionTracker(getLevel(), monster);
        getLevel().addStepListener(animationTracker);
        getLevel().addStepListener(directionTracker);

        this.monster = monster;
        this.platform = platform;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (monster.getPosition().x + 1 > platform.getPosition().x + platform.getHalfWidth() && monster.getDirection() > 0
                || monster.getPosition().x - 1 < platform.getPosition().x - platform.getHalfWidth() && monster.getDirection() < 0) {
            monster.changeDirection();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

}
