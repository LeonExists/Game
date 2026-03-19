import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Canvas
        Canvas canvas = new Canvas("My Game", 512, 512); 

        // Map
        Map map = new Map(canvas, "map_1.txt");

        // Player
        GameObject player = new GameObject(canvas, 0, 0, "player.png");
        canvas.addGameObject(player);

        // Game Loop
        while (true) {
            int playerX = player.getX();

            Game.sleep(500);

            player.setPosition(playerX + 1, 0);
            System.out.println("Player X: " + playerX);
        }
    }
}
