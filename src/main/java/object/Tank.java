package object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    public final static int UP=8;
    public final static int DOWN=2;
    public final static int LEFT=4;
    public final static int RIGHT=6;

    private int speed;
    private int x;
    private int y;
    private boolean[] dirs=new boolean[4];
//    private int direction;
    private Direction direction;

    public Tank(int x,int y,Direction direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
        speed=5;
    }
    public Image getImage() {
        if(direction==Direction.UP){
            return new ImageIcon("assets/images/itankU.png").getImage();
        }
        if(direction==Direction.DOWN){
            return new ImageIcon("assets/images/itankD.png").getImage();
        }
        if(direction==Direction.LEFT){
            return new ImageIcon("assets/images/itankL.png").getImage();
        }
        if(direction==Direction.RIGHT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }
        if(direction==Direction.RIGHT_UP){
            return new ImageIcon("assets/images/itankRU.png").getImage();
        }
        if(direction==Direction.LEFT_DOWN){
            return new ImageIcon("assets/images/itankLD.png").getImage();
        }
        if(direction==Direction.LEFT_UP){
            return new ImageIcon("assets/images/itankLU.png").getImage();
        }
        if(direction==Direction.RIGHT_DOWN){
            return new ImageIcon("assets/images/itankRD.png").getImage();
        }
        return null;
    }
    public void move(){
        switch (direction) {
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case RIGHT_UP:
                y-=speed;
                x+=speed;
                break;
            case LEFT_DOWN:
                y+=speed;
                x-=speed;
                break;
            case LEFT_UP:
                x-=speed;
                y-=speed;
                break;
            case RIGHT_DOWN:
                x+=speed;
                y+=speed;
                break;

        }
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
    public int getSpeed(){
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
    public void setSpeed(int speed){
        this.speed=speed;
    }

    public void setDirs(boolean[] dirs) {
        this.dirs = dirs;
    }
    //    public int getDirection() {
//        return direction;
//    }
}
