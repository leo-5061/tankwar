import object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends GameObject {

    private boolean horizontal;
    private int bricks;

    public Wall(int x, int y, boolean horizontal, int bricks, Image[] images) {
        super(x, y, images);
        this.x=x;
        this.y=y;
        this.horizontal = horizontal;
        this.bricks = bricks;

    }

    public void draw(Graphics g) {
        if (horizontal) {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x + i * (width-2), y, null);
            }

        } else {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x, y + i * (height-2), null);
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getBricks() {
        return bricks;
    }
}
