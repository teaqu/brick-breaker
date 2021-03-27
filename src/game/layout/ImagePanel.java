package game.layout;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private final Image background;

    public ImagePanel(String filename) {
        background = new ImageIcon(filename).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
