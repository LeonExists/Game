import java.io.IOException;

public class Main {
    static final int fps = 60; 

    public static void main(String[] args) throws IOException {
        // Canvas
        Canvas canvas = new Canvas("My Game", 512, 512); 

        // Map
        Map map = new Map(canvas, "map_1.txt");

        // Controls
        Controls controls = new Controls();
        canvas.addKeyListener(controls);

        // Player
        Player player = new Player(canvas, 0, 0, "player.png");
        canvas.addGameObject(player);

        // Game Loop
        while (true) {
            Game.sleep(1000 / fps);

            // movement
            if (controls.isUpPressed()) { player.move(0, -8); }
            if (controls.isDownPressed()) { player.move(0, 8); }
            if (controls.isLeftPressed()) { player.move(-8, 0); }
            if (controls.isRightPressed()) { player.move(8, 0); }

            // redraw screen
            canvas.repaint();
        }
    }
}
