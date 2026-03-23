import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import java.awt.Image;

public class Animation {
    private static final String DEFAULT_IMAGE_PATH = "Game/src/images/";

    private ArrayList<Image> frames = new ArrayList<Image>();

    public Animation(String[] framePaths) {
        // load frames
        this.frames = loadFrames(framePaths);
    }


    // ! duplicate : of loadImage() inside GameObject class. - idea : move to Game class and have it in there once for everything
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
    // ! duplicate : of loadImage() inside GameObject class. - idea : move to Game class and have it in there once for everything

    private ArrayList<Image> loadFrames(String[] framePaths) {
        ArrayList<Image> frames = new ArrayList<Image>();

        for (int i = 0; i < framePaths.length; i++) {
            frames.add(loadImage(framePaths[i]));
        }

        return frames;
    }


    public Image getFrame(int index) { return frames.get(index); }
}
