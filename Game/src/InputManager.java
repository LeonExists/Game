import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputManager extends KeyAdapter {
    private static InputManager instance;

    // Track pressed keys by key code
    private Map<Integer, Boolean> keyStates = new HashMap<>();

    // Key mappings for easy reference
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";

    private InputManager() {}

    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }


    @Override
    public void keyPressed(KeyEvent event) {
        keyStates.put(event.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keyStates.put(event.getKeyCode(), false);
    }


    // Check if a specific key code is pressed
    public boolean isKeyPressed(int keyCode) { return keyStates.getOrDefault(keyCode, false); }

    
    // Movement
    public boolean isUpPressed() { return isKeyPressed(KeyEvent.VK_UP) || isKeyPressed(KeyEvent.VK_W); }
    public boolean isDownPressed() { return isKeyPressed(KeyEvent.VK_DOWN) || isKeyPressed(KeyEvent.VK_S); }
    public boolean isLeftPressed() { return isKeyPressed(KeyEvent.VK_LEFT) || isKeyPressed(KeyEvent.VK_A); }
    public boolean isRightPressed() { return isKeyPressed(KeyEvent.VK_RIGHT) || isKeyPressed(KeyEvent.VK_D); }


    // Clear all key states (useful for scene transitions)
    public void clearAllKeys() {
        keyStates.clear();
    }

    // Get all currently pressed keys
    public Map<Integer, Boolean> getKeyStates() {
        return new HashMap<>(keyStates);
    }
}
