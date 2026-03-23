import java.util.ArrayList;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animation {
    private int speed;
    private int currentFrame = 0;
    private int tickCount = 0;
    private ArrayList<Image> frames = new ArrayList<Image>();

    public Animation(String[] framePaths, int speed) {
        this.frames = loadFrames(framePaths);
        this.speed = speed;
    }


    private ArrayList<Image> loadFrames(String[] framePaths) {
        ArrayList<Image> loadedFrames = new ArrayList<Image>();

        for (int i = 0; i < framePaths.length; i++) {
            try {
                java.io.File file = new java.io.File("Game/src/images/player/" + framePaths[i]);
                if (file.exists()) {
                    loadedFrames.add(ImageIO.read(file));
                } else {
                    throw new IllegalArgumentException("Image not found: " + framePaths[i]);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to load animation frame: " + framePaths[i], e);
            }
        }

        return loadedFrames;
    }


    public Image getFrame(int index) { return frames.get(index); }


    public void play(GameObject gameObject) {
        tickCount++;

        if (tickCount >= speed) {
            tickCount = 0;
            currentFrame = (currentFrame + 1) % frames.size();
        }

        gameObject.setImage(frames.get(currentFrame));
    }

    public void reset() {
        currentFrame = 0;
        tickCount = 0;
    }
}
