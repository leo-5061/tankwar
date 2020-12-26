import object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class GameClient extends JComponent {
    private int screenWidth;
    private int screenHeight;
    private Tank playerTank;
    private List<Tank> enemyTank=new ArrayList<>();
    private List<Wall> walls=new ArrayList<>();
    private List<GameObject> gameObjects=new ArrayList<>();

    GameClient() {
        this(1024, 768);
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
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public void init() {

        Image[] brickImage={new ImageIcon("assets/images/brick.png").getImage()};
        String[] replaceDirection={"U","D","L","R","RU","LD","LU","RD"};
        Image[] itankImage=new Image[8];
        Image[] etankImage=new Image[8];
        for(int i=0;i<itankImage.length;i++){
            itankImage[i]=new ImageIcon("assets/images/itank"+replaceDirection[i]+".png").getImage();
            etankImage[i]=new ImageIcon("assets/images/etank"+replaceDirection[i]+".png").getImage();
        }

        playerTank = new Tank(490, 50, Direction.DOWN,itankImage);
        gameObjects.add(playerTank);
        for(int i=0;i<3;i++){
            for (int j=0;j<5;j++){
                enemyTank.add(new Tank(370+j*60,250+i*75,Direction.UP,true,etankImage));
            }
        }
        gameObjects.addAll(enemyTank);
        Image images[]={new ImageIcon("assets/images/brick.png").getImage()};
        walls.add(new Wall(270,120,true,16,brickImage));
        walls.add(new Wall(160,150,false,16,brickImage));
        walls.add(new Wall(820,150,false,16,brickImage));
        gameObjects.addAll(walls);
//        for (int i=0,i<)
//        walls.add(new Wall(256,150,true,))

    }

    public void keyPressed(KeyEvent e) {
        //傳址
        boolean dirs[]= playerTank.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0]=true;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=true;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
                break;


        }
    }
    public void keyReleased(KeyEvent e) {
        //傳址
        boolean dirs[]= playerTank.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0]=false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
                break;


        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image background=new ImageIcon("assets/images/background.jpg").getImage();
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,screenWidth,screenHeight);
        g.drawImage(background,0,0,null);

//        g.drawImage(playerTank.getImage(),
//                playerTank.getX(), playerTank.getY(), null);
        for (GameObject gameObject:gameObjects){
            gameObject.draw(g);
        }
//        playerTank.draw(g);
//        for (Tank tank:enemyTank){
//            tank.draw(g);
//        }
//        for (Wall wall:walls){
//            wall.draw(g);
//        }
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}


