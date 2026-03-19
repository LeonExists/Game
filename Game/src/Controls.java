import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls extends KeyAdapter {
    // movement
    public static boolean upPressed = false;
    public static boolean downPressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        // movement
        if (keyCode == KeyEvent.VK_UP) upPressed = true;
        else if (keyCode == KeyEvent.VK_DOWN) downPressed = true;
        else if (keyCode == KeyEvent.VK_LEFT) leftPressed = true;
        else if (keyCode == KeyEvent.VK_RIGHT) rightPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();

        System.out.println("Key: " + keyCode);

        // movement
        if (keyCode == KeyEvent.VK_UP) upPressed = false;
        else if (keyCode == KeyEvent.VK_DOWN) downPressed = false;
        else if (keyCode == KeyEvent.VK_LEFT) leftPressed = false;
        else if (keyCode == KeyEvent.VK_RIGHT) rightPressed = false;
    }

    public boolean isUpPressed() { return upPressed; }
    public boolean isDownPressed() { return downPressed; }
    public boolean isLeftPressed() { return leftPressed; }
    public boolean isRightPressed() { return rightPressed; }
}
