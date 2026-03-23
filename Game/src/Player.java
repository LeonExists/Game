public class Player extends GameObject {
    @Override
    DEFAULT_IMAGE_PATH = "Game/src/images/player/";

    private int speed = 8;

    priavte Animation walk = new Animation({ "player.png", "player_walk_" })


    public Player(int x, int y, String imagePath) {
        super(x, y, imagePath);
    }

    public Player(int x, int y) {
        this(x, y, "player.png");
    }

    @Override
    protected String getDefaultImagePath() { return "Game/src/images/player/"; }

    
    public void update() {
        movement();

        animate();
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


    public void animate() {

    }
}
