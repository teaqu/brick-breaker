package game;

import game.layout.*;
import game.level.*;
import game.model.Options;
import game.model.Stats;
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
    private GameLayout gameLayout;

    private OptionsMenu optionsMenu;

    private Stats stats;

    private Options options;

    private SoundClip levelComplete;

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
        frame = new JFrame("Brick Breaker");

        MainMenu mainMenu = new MainMenu(this);
        mainMenu.setPreferredSize(new Dimension(600, 600));
        frame.add(mainMenu, BorderLayout.CENTER);

        // Setup options menu
        optionsMenu = new OptionsMenu(this);

        optionsFrame = new JFrame("Brick Breaker");
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

    public void goToNextLevel() {
        levelComplete.play();
        GameLevel newLevel = getLevelByNum(level.getLevel() + 1);
        if (newLevel != null) {
            changeLevel(newLevel);
        } else {
            gameOver(true);
        }
    }

    public GameLevel getLevelByNum(int num) {
        if (num == 1){
            return new Level1(this);
        } else if (num == 2){
            return new Level2(this);
        } else if (num == 3){
            return new Level3(this);
        } else if (num == 4){
            return new Level4(this);
        } else if (num == 5){
            return new Level5(this);
        } else if (num == 6){
           return new Level6(this);
        }
        return null;
    }

    /**
     * @todo reset score back to what it was
     * @param level
     */
    public void restartLevel(GameLevel level) {
        stats.importStats(level.getStartStats());
        changeLevel(getLevelByNum(level.getLevel()));
    }

    public void gameOver() {
       gameOver(false);
    }

    public void gameOver(boolean complete) {
        resetFrame();
        getLevel().stop();
        EndGame endGame = new EndGame(this, complete);
        frame.add(endGame.getMainPanel());
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

    public GameLayout getLayout() {
        return gameLayout;
    }

    public void changeLevel(GameLevel newLevel) {
        if (level != null) {
            level.stop();
            gameLayout.changeLevel(newLevel);
        } else {
            // add the view to a frame (Java top level window)
            resetFrame();
            gameLayout = new GameLayout(newLevel);
            frame.add(gameLayout);
        }
        // add the view to a frame (Java top level window)
        level = newLevel;
        level.start();

        // uncomment this to make a debugging view
//        JFrame debugView = new DebugViewer(level, 500, 500);
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

    public OptionsMenu getOptionsMenu() {
        return optionsMenu;
    }

    public Options getOptions() {
        return options;
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

    public void reset() {
        this.level = null;
        this.stats = new Stats();
    }
}
