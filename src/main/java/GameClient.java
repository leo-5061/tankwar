import object.Direction;
import object.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;
import static object.Tank.LEFT;

public class GameClient extends JComponent {
    private int screenWidth;
    private int screenHeight;
    private Tank playerTank;

    GameClient() {
        this(800, 600);
    }

    GameClient(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void init() {
        playerTank = new Tank(200, 200, Direction.DOWN);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                playerTank.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                playerTank.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                playerTank.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                playerTank.setDirection(Direction.RIGHT);
                break;


        }
        playerTank.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(playerTank.getImage(),
                playerTank.getX(), playerTank.getY(), null);
    }


}


