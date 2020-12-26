import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TankGame {
    private static GameClient gameClient;
    public static void main(String[] args) {
        gameClient=new GameClient();
        JFrame frame=new JFrame();
        frame.add(gameClient);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                gameClient.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                gameClient.keyReleased(e);
            }

        });

        gameClient.repaint();
        frame.pack();


    }

    public static GameClient getGameClient() {
        return gameClient;
    }
}
