package game.layout;

import javax.swing.*;
import java.awt.*;

/**
 * Show a background image in the JPanel
 */
public class ImagePanel extends JPanel {

    private Image background;

    public ImagePanel(String filename) {
        background = new ImageIcon(filename).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw image over entire panel
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public void setBackground(Image bg) {
        background = bg;
    }
}
