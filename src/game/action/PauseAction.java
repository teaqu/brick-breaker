package game.action;

import game.level.GameLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pause the game.
 */
public class PauseAction implements ActionListener {

    GameLevel level;

    /**
     * Used to track pause / resume status.
     */
    boolean status = false;

    public PauseAction(GameLevel level) {
        this.level = level;
    }

    public void actionPerformed(ActionEvent e) {
        if (status) {
            this.level.stop();
        } else {
            this.level.resume();
        }
        status = ! status;
    }
}