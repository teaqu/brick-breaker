package game.mouse;

import city.cs.engine.World;
import game.layout.GameView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private World world;
    private GameView view;

    public MouseHandler(World w, GameView v) {
        world = w;
        view = v;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    //we have to implement the other methods to satisfy
    //the interface, but we can leave them empty.

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
