import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class GameObject {
    private static final String DEFAULT_IMAGE_PATH = "Game/src/images/";
    private static final int DEFAULT_SIZE = 64;

    private final Canvas canvas;
    private static int size = 64;

    private int x;
    private int y;
    private Image image;

    public GameObject(Canvas canvas, int x, int y, String imagePath) {
        this(canvas, x, y, imagePath, DEFAULT_SIZE);
    }

    public GameObject(Canvas canvas, int x, int y, String imagePath, int size) {
        this.canvas = Objects.requireNonNull(canvas, "Canvas cannot be null");

        this.x = x;
        this.y = y;
        this.size = size;
        this.image = loadImage(imagePath);
    }


    private Image loadImage(String imagePath) {
        Objects.requireNonNull(imagePath, "Image path cannot be null");
        try {
            // Try loading from classpath resources first
            java.net.URL resource = getClass().getClassLoader().getResource(imagePath);
            if (resource != null) {
                return ImageIO.read(resource);
            }

            // Fall back to file system with default path
            java.io.File file = new java.io.File(DEFAULT_IMAGE_PATH + imagePath);
            if (file.exists()) {
                return ImageIO.read(file);
            }

            // Try absolute path
            file = new java.io.File(imagePath);
            if (file.exists()) {
                return ImageIO.read(file);
            }

            throw new IllegalArgumentException("Image not found: " + imagePath);
        } catch (IOException e) {
            System.err.println("Failed to load image: " + imagePath);
            throw new RuntimeException("Image loading failed", e);
        }
    }

    public void draw(Graphics g) {
        if (g != null && image != null) {
            g.drawImage(image, x, y, size, size, null);
        }
    }


    public int getX() { return x; }
    public int getY() { return y; }
    public static int getSize() { return size; }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        canvas.repaint();
    }

    public void move(int dx, int dy) {
        setPosition(x + dx, y + dy);
    }
}
