import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GameObject {
    private final String imageSource = "Game/src/images/";

    private Canvas canvas;

    private final int size = 64;

    private int x;
    private int y;
    private Image image;


    public GameObject(Canvas canvas, int x, int y, String imagePath) {
        this.canvas = canvas;

        this.x = x;
        this.y = y;
        this.image = new ImageIcon(imageSource + imagePath).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.x * size, this.y * size, size, size, null);
    }


    public int getX() { return this.x; }
    public int getY() { return this.y; }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        canvas.repaint();
    }
}
