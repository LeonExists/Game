import javax.swing.*;
import java.awt.*;


public class ImageFrame extends JPanel {
    private final String source = "Game/src/images/";
    private Image image;

    public ImageFrame(String imageName) {
        image = new ImageIcon(source + imageName).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 64, 64, this); // x, y, observer
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Image");
        ImageFrame panel = new ImageFrame("player.png");

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
