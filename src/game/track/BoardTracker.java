package game.track;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Listener;
import game.model.body.Board;
import game.level.GameLevel;
import org.jbox2d.common.Vec2;

public class BoardTracker extends Listener implements StepListener {

    Board board;

    public BoardTracker(GameLevel level, Board board) {
        super(level);
        this.board = board;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (board.left && board.getPosition().x > -10.5f) {
            board.move(new Vec2(-board.walking_speed, 0));
        } else if (board.right && board.getPosition().x < 10.5f) {
            board.move(new Vec2(board.walking_speed, 0));
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

}
