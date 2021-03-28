package game.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Quit the game
 */
public class QuitAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}