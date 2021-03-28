package game.layout;

import game.Game;
import game.action.MainAction;
import game.action.PlayAction;

import javax.swing.*;
import java.awt.*;

/**
 * Levels menu allows user to play specific level.
 */
public class LevelsMenu extends JPanel {
    private Game game;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;
    private JButton level6;
    private JButton main;

    public LevelsMenu(Game game) {
        this.game = game;

        // Set grid layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add margin between buttons
        gbc.insets = new Insets(3, 3, 3, 3);

        // Add level and main menu buttons
        level1 = new JButton("LEVEL 1: BRICKS");
        level2 = new JButton("LEVEL 2: BRICKS X2");
        level3 = new JButton("LEVEL 3: BIRDS");
        level4 = new JButton("LEVEL 4: MONSTER");
        level5 = new JButton("LEVEL 5: MONSTERS");
        level6 = new JButton("LEVEL 6: BOMB");
        main = new JButton("MAIN MENU");
        level1.addActionListener(new PlayAction(game, 1));
        level2.addActionListener(new PlayAction(game, 2));
        level3.addActionListener(new PlayAction(game, 3));
        level4.addActionListener(new PlayAction(game, 4));
        level5.addActionListener(new PlayAction(game, 5));
        level6.addActionListener(new PlayAction(game, 6));
        main.addActionListener(new MainAction(game));
        add(level1, gbc);
        add(level2, gbc);
        add(level3, gbc);
        add(level4, gbc);
        add(level5, gbc);
        add(level6, gbc);
        add(main, gbc);
    }

}
