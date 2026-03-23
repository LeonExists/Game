import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class GameObject {
    public static final int DEFAULT_SIZE = 64;

    private int width = 64;
    private int height = 64;
    private int currentWidth;
    private int currentHeight;

    private int x;
    private int y;
    private Image image;

    public GameObject(int x, int y, String imagePath) {
        this(x, y, imagePath, DEFAULT_SIZE, DEFAULT_SIZE);
    }

    public GameObject(int x, int y, String imagePath, int width, int height) {
        this.x = x;
        this.y = y;
        this.image = loadImage(imagePath);
        this.width = width;
        this.height = height;
        this.currentWidth = width;
        this.currentHeight = height;
    }


    protected String getDefaultImagePath() { return "Game/src/images/"; }

    // ! duplicate : of loadImage() inside Animation class. - idea : move to Game class and have it in there once for everything
    private Image loadImage(String imagePath) {
        Objects.requireNonNull(imagePath, "Image path cannot be null");
        try {
            // Try loading from classpath resources first
            java.net.URL resource = getClass().getClassLoader().getResource(imagePath);
            if (resource != null) {
                return ImageIO.read(resource);
            }

            // Fall back to file system with default path
            java.io.File file = new java.io.File(getDefaultImagePath() + imagePath);
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
    // ! duplicate : of loadImage() inside Animation class. - idea : move to Game class and have it in there once for everything

    public void draw(Graphics g) {
        if (g != null && image != null) {
            if (currentWidth < 0) {
                int drawWidth = -currentWidth;
                g.drawImage(image, x + drawWidth, y, x, y + currentHeight,
                        0, 0, image.getWidth(null), image.getHeight(null), null);
            } else {
                g.drawImage(image, x, y, x + currentWidth, y + currentHeight,
                        0, 0, image.getWidth(null), image.getHeight(null), null);
            }
        }
    }


    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return this.currentWidth; }
    public int getHeight() { return this.currentHeight; }


    public void setImage(Image image) {
        this.image = image;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height) {
        this.currentWidth = width;
        this.currentHeight = height;
    }

    public void flip(int direction) {
        setSize(this.width * direction, getHeight());
    }

    public void move(int dx, int dy) {
        setPosition(x + dx, y + dy);
    }
}
