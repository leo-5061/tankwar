import object.GameObject;

import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject {
    public final static int UP = 8;
    public final static int DOWN = 2;
    public final static int LEFT = 4;
    public final static int RIGHT = 6;

    private int speed;

    private boolean[] dirs = new boolean[4];
    //    private int direction;
    private Direction direction;
    private boolean enemy;

    public Tank(int x, int y, Direction direction,Image[] images) {
        this(x,y,direction,false,images);
    }
    public Tank(int x, int y, Direction direction,boolean enemy,Image[] images) {
        super(x,y,images);
        this.x=x;
        this.y=y;
        this.direction = direction;
        speed = 1;
        this.enemy=enemy;

    }

//    public Image getImage() {
//        String name=enemy?"etank":"itank";
//        if (direction == Direction.UP) {
//            return new ImageIcon("assets/images/"+name+"U.png").getImage();
//        }
//        if (direction == Direction.DOWN) {
//            return new ImageIcon("assets/images/"+name+"D.png").getImage();
//        }
//        if (direction == Direction.LEFT) {
//            return new ImageIcon("assets/images/"+name+"L.png").getImage();
//        }
//        if (direction == Direction.RIGHT) {
//            return new ImageIcon("assets/images/"+name+"R.png").getImage();
//        }
//        if (direction == Direction.RIGHT_UP) {
//            return new ImageIcon("assets/images/"+name+"RU.png").getImage();
//        }
//        if (direction == Direction.LEFT_DOWN) {
//            return new ImageIcon("assets/images/"+name+"LD.png").getImage();
//        }
//        if (direction == Direction.LEFT_UP) {
//            return new ImageIcon("assets/images/"+name+"LU.png").getImage();
//        }
//        if (direction == Direction.RIGHT_DOWN) {
//            return new ImageIcon("assets/images/"+name+"RD.png").getImage();
//        }
//        return null;
//    }

    public void detectDirection() {
        if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.UP;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.DOWN;
        } else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT;
        } else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT;
        } else if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT_UP;
        } else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT_DOWN;
        } else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT_UP;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT_DOWN;
        }

    }

    public void move() {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case RIGHT_UP:
                y -= speed;
                x += speed;
                break;
            case LEFT_DOWN:
                y += speed;
                x -= speed;
                break;
            case LEFT_UP:
                x -= speed;
                y -= speed;
                break;
            case RIGHT_DOWN:
                x += speed;
                y += speed;
                break;

        }
        if (x<0){
            x=0;
        }else if (x>TankGame.getGameClient().getScreenWidth()-width){
            x=TankGame.getGameClient().getScreenWidth()-width;
        }
        if (y<0){
            y=0;
        }else if (y>TankGame.getGameClient().getScreenWidth()-height){
            y=TankGame.getGameClient().getScreenHeight()-height;
        }
    }

    public void draw(Graphics g) {
        if (isMoving()) {
            detectDirection();
            move();
        }
        g.drawImage(image[direction.ordinal()], getX(), getY(), null);
    }

    public boolean isMoving() {
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i] == true) {
                return true;
            }
        }
        return false;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean[] getDirs() {
        return dirs;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirs(boolean[] dirs) {
        this.dirs = dirs;
    }

    //    public int getDirection() {
//        return direction;
//    }
}
