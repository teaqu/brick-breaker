package game.action;

import game.level.GameLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseAction implements ActionListener {

    GameLevel level;
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