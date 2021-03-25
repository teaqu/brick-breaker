package game.timer;

import game.model.body.TNT;
import game.model.body.TNTBody;
import game.model.body.TNTExplosion;
import game.level.GameLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TNTTimer implements ActionListener {

    private GameLevel level;
    private TNT tnt;
    private int count;

    public TNTTimer(GameLevel level, TNT tnt) {
        this.level = level;
        this.tnt = tnt;
        count = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        count++;
        if (count < 5) {
            TNTBody body = tnt.getBody();
            if (body.getImages().size() > 0) {
                body.removeAllImages();
            } else {
                body.addImage(TNTBody.getTntImage());
            }
        } else if (count == 5) {
            TNTBody body = tnt.getBody();
            body.destroy();
            tnt.explode();
        } else if (count > 15) {
            TNTExplosion explosion = tnt.getExplosion();
            explosion.destroy();
            tnt.getTimer().stop();
        }
    }
}