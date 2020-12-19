import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {
        GameClient gameClient=new GameClient();
        JFrame frame=new JFrame();
        frame.add(new GameClient());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
