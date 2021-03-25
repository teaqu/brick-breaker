package game.action;

import game.level.GameLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartAction implements ActionListener {

    GameLevel level;

    public RestartAction(GameLevel level) {
        this.level = level;
    }

    public void actionPerformed(ActionEvent e) {
        this.level.getGame().restartLevel(level);
    }
}