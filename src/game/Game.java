package game;

import city.cs.engine.UserView;
import game.controller.GameController;
import game.layout.*;
import game.level.*;
import game.controller.BoardController;
import game.model.Options;
import game.mouse.GiveFocus;
import game.model.Stats;
import game.mouse.MouseHandler;
import game.sound.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel level;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private GameView gameView;

    private UserView userView;

    private OptionsMenu optionsMenu;

    private MainMenu mainMenu;

    private HighScores highScores;

    private Stats stats;

    private Options options;

    private SoundClip levelComplete;

    private BoardController boardController;

    private GameController gameController;

    /**
     * Add the view to a frame (Java top level window)
     */
    private JFrame frame;
    private JFrame optionsFrame;

    /**
     * Initialise a new Game.
     */
    public Game() {
        // Setup scores
        stats = new Stats();
        options = new Options();

        try {
            levelComplete = new SoundClip("data/sounds/level_complete.wav", this);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // enable the frame to quit the application
        // when the x button is pressed
        frame = new JFrame("Basic world");

        mainMenu = new MainMenu(this);
        mainMenu.setPreferredSize(new Dimension(600, 600));
        frame.add(mainMenu, BorderLayout.CENTER);

        highScores = new HighScores(this);

        // Setup options menu
        optionsMenu = new OptionsMenu(this);

        optionsFrame = new JFrame("Basic world");
        optionsMenu.setPreferredSize(new Dimension(600, 600));
        optionsFrame.add(getOptionsMenu());

        // Setup frames
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setLocation(frame.getLocation());
        optionsFrame.setResizable(false);
        optionsFrame.pack();
        optionsFrame.setVisible(false);
    }

    public void goToNextLevel(){
        levelComplete.play();
        if (level instanceof Level1){
            changeLevel(new Level2(this));
        } else if (level instanceof Level2) {
            changeLevel(new Level3(this));
        } else if (level instanceof Level3) {
            changeLevel(new Level4(this));
        } else {
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    /**
     * @todo reset score back to what it was
     * @param level
     */
    public void restartLevel(GameLevel level) {
        if (level instanceof Level1){
            changeLevel(new Level1(this));
        } else if (level instanceof Level2) {
            changeLevel(new Level2(this));
        } else if (level instanceof Level3) {
            changeLevel(new Level3(this));
        } else {
            changeLevel(new Level4(this));
        }
    }

    public void gameOver() {
        System.out.println("Game over.");
        System.exit(0);
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception ignored){}

        new Game();
    }

    public Stats getStats() {
        return stats;
    }

    public GameLevel getLevel() {
        return level;
    }

    public GameView getView() {
        return gameView;
    }

    private void changeLevel(GameLevel newLevel) {
        level.stop();
        level = newLevel;
        boardController.updateBoard(level.getBoard());
        //level now refer to the new level
        gameView.setWorld(level);
        userView.setWorld(level);
        userView.setZoom(3);
        level.start();

        // uncomment this to make a debugging view
//        JFrame debugView = new DebugViewer(level, 500, 500);
    }

    public void start() {
        resetFrame();

        level = new Level1(this);
        userView = new UserView(level, 100, 100);

        // make a view
        gameView = new GameView(level, 500, 500);
        gameView.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        gameView.addMouseListener(new MouseHandler(level, gameView));

        boardController = new BoardController(level.getBoard());
        gameView.addKeyListener(boardController);

        gameController = new GameController(this);
        gameView.addKeyListener(gameController);

        gameView.addMouseListener(new GiveFocus(gameView));

        // add the view to a frame (Java top level window)
        frame.add(gameView);

        userView = new UserView(level, 100, 100);
        userView.setZoom(3);
        frame.add(userView, BorderLayout.EAST);

        BottomMenu sideMenu = new BottomMenu(level, this.getStats());
        frame.add(sideMenu.getMainPanel(), BorderLayout.SOUTH);

        level.start();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void resetFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().invalidate();
        frame.getContentPane().revalidate();
        frame.repaint();
    }

    public void resetFrame() {
        resetFrame(frame);
    }

    public void resetOptionsFrame() {
        resetFrame(optionsFrame);
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public OptionsMenu getOptionsMenu() {
        return optionsMenu;
    }

    public Options getOptions() {
        return options;
    }

    public HighScores getHighScores() {
        return highScores;
    }

    public JFrame getOptionsFrame() {
        return optionsFrame;
    }

    public void swapFrames() {
        if (frame.isVisible()) {
            optionsFrame.setLocation(frame.getLocation());
            resetOptionsFrame();
            optionsFrame.add(new OptionsMenu(this));
            optionsFrame.setVisible(true);
            frame.setVisible(false);
        } else {
            frame.setLocation(optionsFrame.getLocation());
            frame.setVisible(true);
            optionsFrame.setVisible(false);
        }
    }
}
