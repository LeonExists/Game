import java.io.IOException;

public class Main {
    static final int FPS = 60; 

    public static void main(String[] args) throws IOException {
        // Canvas
        Canvas canvas = new Canvas("My Game", 512, 512);

        // Map
        Map map = new Map(canvas, "map_1.txt");

        // Input Manager
        InputManager inputManager = InputManager.getInstance();
        canvas.addKeyListener(inputManager);

        // Player
        Player player = new Player(0, 0, "player.png");
        canvas.addGameObject(player);


        // Game Loop
        while (true) {
            Game.sleep(1000 / FPS);

            // player - movement
            player.update();

            // redraw screen
            canvas.repaint();
        }
    }
}
