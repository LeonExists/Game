import java.io.IOException;

public class Main {
    static final int fps = 60; 

    public static void main(String[] args) throws IOException {
        // Canvas
        Canvas canvas = new Canvas("My Game", 512, 512);

        // Map
        Map map = new Map(canvas, "map_1.txt");

        // Input Manager
        InputManager inputManager = InputManager.getInstance();
        canvas.addKeyListener(inputManager);

        // Player
        Player player = new Player(canvas, 0, 0, "player.png");
        canvas.addGameObject(player);

        
        // Game Loop
        while (true) {
            Game.sleep(1000 / fps);

            // player - movement
            player.movement();

            // redraw screen
            canvas.repaint();
        }
    }
}
