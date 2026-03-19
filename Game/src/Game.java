import java.awt.*;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) throws Exception {
        // Setup - frame + canvas
        JFrame frame = new JFrame("Game");
        Canvas canvas = new Canvas();

        // Player - create
        GameObject player = new GameObject(0, 0, "player.png");
        canvas.addObject(player);

        // Setup - frame + canvas
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
