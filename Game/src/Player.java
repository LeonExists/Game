public class Player extends GameObject {
    private int speed = 8;


    public Player(int x, int y, String imagePath) {
        super(x, y, imagePath);
    }

    public Player(int x, int y) {
        this(x, y, "player.png");
    }


    public void move(int dx, int dy) { setPosition(super.getX() + dx, super.getY() + dy); }


    public void setSpeed(int speed) { this.speed = speed; }
    public int getSpeed() { return speed; }


    public void movement() {
        InputManager inputManager = InputManager.getInstance();

        if (inputManager.isUpPressed()) move(0, -speed);
        if (inputManager.isDownPressed()) move(0, speed);
        if (inputManager.isLeftPressed()) move(-speed, 0);
        if (inputManager.isRightPressed()) move(speed, 0);
    }
}
