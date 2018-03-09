package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tansel
 */
public class Level3Enemy extends Enemy {

    public Level3Enemy(int x, int y) {
        super(x, y);
        image = new ImageIcon(this.getClass().getResource("/images/enemies/enemy3.png")).getImage();
        speed = 2;
    }

    @Override
    public void move( ArrayList<Brick> bricks, ArrayList<Bomb> bombs, ArrayList<Explosion> explosions) {
        x += dx;
        y += dy;

        for (int i = 0; i < 30; i++) {
            if (getBounds().intersects(walls[i])) {
                x -= dx;
                y -= dy;
                choosePath();
            }
        }

        for (int i = 0; i < bricks.size(); i++) {
            if (getBounds().intersects(bricks.get(i).getBounds())) {
                x -= dx;
                y -= dy;
                choosePath();
            }
        }

        for (int i = 0; i < bombs.size(); i++) {
            if (getBounds().intersects(bombs.get(i).getBounds())) {
                x -= dx;
                y -= dy;
                choosePath();
            }
        }

        for (int i = 0; i < explosions.size(); i++) {
            if (getBounds().intersects(explosions.get(i).getBounds()))
                visible = false;
        }

        if (x < 1)
            x = 1;
        if (x > 604)
            x = 604;
        if (y < 1)
            y = 1;
        if (y > 504)
            y = 504;
    }
}
