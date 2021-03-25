package game.layout;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.level.GameLevel;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    public GameView(GameLevel level, int width, int height) {
        super(level, width, height);
        background = new ImageIcon("data/images/background.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

}
