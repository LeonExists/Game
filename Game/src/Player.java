public class Player extends GameObject {
    public Player(Canvas canvas, int x, int y, String imagePath) {
        super(canvas, x, y, imagePath);
    }

    // Default
    public Player(Canvas canvas, Controls controls, int x, int y) {
        this(canvas, x, y, "player.png");
    }


    public void move(int dx, int dy) {
        setPosition(super.getX() + dx, super.getY() + dy);
    }
}
