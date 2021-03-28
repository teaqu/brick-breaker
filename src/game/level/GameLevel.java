package game.level;

import city.cs.engine.*;
import game.Game;
import game.layout.GameView;
import game.model.body.Ball;
import game.model.body.Board;
import game.model.body.Wall;
import game.encounter.BallEncounter;
import game.model.body.Laser;
import game.model.Stats;
import game.track.BallTracker;
import game.track.BoardTracker;
import org.jbox2d.common.Vec2;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all the levels
 */
public abstract class GameLevel extends World {
    private Game game;

    // The player
    private Board board;

    // Balls within the level
    private List<Ball> balls;

    // Level music
    private SoundClip music;

    // Level background image
    private Image background;

    // Text colour for level. Can change this so it is more readable
    // depending on the background
    private Color textColour = new Color(0);

    // For tracking the ball within the level. This allows us to follow the
    // ball out of the game view.
    private BallTracker ballTracker;

    // So we can restart the level and reset the stats
    private String startStats;

    // These bodies need to be destroyed for the level to complete. (remaining)
    private List<Body> consumableBodies;

    public GameLevel(Game game) {
        this.game = game;

        board = new Board(this);
        consumableBodies = new ArrayList<>();
        balls = new ArrayList<>();

        // Set current level and export stats in case of restart
        game.getStats().setLevel(getLevel());
        startStats = game.getStats().exportStats();

        // Set board and create a new ball
        board.setPosition(new Vec2(7.5f, -10));
        BoardTracker boardTracker = new BoardTracker(this, board);
        this.addStepListener(boardTracker);
        newBall();
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Create a new ball
     * This happens when a laser destroys the current ball
     */
    public void newBall() {
        Ball ball = new Ball(this);
        BallEncounter ballEncounter = new BallEncounter(this, ball);
        ball.addCollisionListener(ballEncounter);
        balls.add(ball);

        // Set ball location near board and give it some velocity
        ball.setPosition(new Vec2(board.getPosition().x, board.getPosition().y + 1));
        ball.applyImpulse(new Vec2((float) Math.random() * 2 - 1, 0));

        // Track ball
        if (ballTracker == null) {
            ballTracker = new BallTracker(this, getBalls().get(0));
        } else {
            ballTracker.setBall(ball);
        }

        // follow the ball
        addStepListener(ballTracker);
    }

    public void addConsumableBody(Body body) {
        consumableBodies.add(body);
        game.getStats().setRemaining(consumableBodies.size());
    }

    public void removeConsumableBody(Body body) {
        consumableBodies.remove(body);
        game.getStats().setRemaining(consumableBodies.size());
    }

    public int countConsumableBodies() {
        return consumableBodies.size();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public boolean isComplete() {
        return countConsumableBodies() == 0;
    }

    public Game getGame() {
        return game;
    }

    protected void genWalls() {
        // make the top
        StaticBody ground = new Wall(this, 12.1f, 0.1f);
        ground.setPosition(new Vec2(0f, 12));

        // add another platform here
        StaticBody wall1 = new Wall(this, 0.1f, 12f);
        wall1.setPosition(new Vec2(-12f, 0));

        // add another platform here
        StaticBody wall2 = new Wall(this, 0.1f, 12f);
        wall2.setPosition(new Vec2(12f, 0));

        new Laser(this);
    }

    protected void genWallsTall() {
        // make the top
        StaticBody ground = new Wall(this, 12.1f, 0.1f);
        ground.setPosition(new Vec2(0f, 24));

        // add another platform here
        StaticBody wall1 = new Wall(this, 0.1f, 18f);
        wall1.setPosition(new Vec2(-12f, 6));

        // add another platform here
        StaticBody wall2 = new Wall(this, 0.1f, 18f);
        wall2.setPosition(new Vec2(12f, 6));

        new Laser(this);
    }

    protected void genWallsMed() {
        // make the top
        StaticBody ground = new Wall(this, 12.1f, 0.1f);
        ground.setPosition(new Vec2(0f, 16));

        // add another platform here
        StaticBody wall1 = new Wall(this, 0.1f, 14f);
        wall1.setPosition(new Vec2(-12f, 2));

        // add another platform here
        StaticBody wall2 = new Wall(this, 0.1f, 14f);
        wall2.setPosition(new Vec2(12f, 2));

        new Laser(this);
    }

    public Stats getStats() {
        return game.getStats();
    }

    public GameView getGameView() {
        return game.getLayout().getGameView();
    }

    public void start() {
        super.start();
        if (music != null) {
            music.loop();
        }
    }

    public void resume() {
        super.start();
        if (music != null) {
            music.resume();
        }
    }

    public void stop() {
        super.stop();
        if (music != null) {
            music.pause();
        }
    }

    public void setMusic(String filename) {
        try {
            music = new SoundClip("data/" + filename, game);   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Color getTextColour() {
        return textColour;
    }

    public void setTextColour(Color textColour) {
        this.textColour = textColour;
    }

    // Set current level in stats using class name
    // eg Level5 == 5
    public int getLevel() {
        String levelName = getClass().getName();
        return Integer.parseInt(levelName.replaceAll("[\\D]", ""));
    }

    public String getStartStats() {
        return startStats;
    }
}