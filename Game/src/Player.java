public class Player extends GameObject {
    private int speed = 8;

    private String state = "idle"; // idle, walking
    private Animation walk = new Animation(new String[] { "player_1.png", "player_2.png" }, 15);


    public Player(int x, int y, String imagePath) {
        super(x, y, imagePath);
    }

    public Player(int x, int y) {
        this(x, y, "player_1.png");
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

        boolean moving = false;

        if (inputManager.isUpPressed()) { move(0, -speed); moving = true; }
        if (inputManager.isDownPressed()) { move(0, speed); moving = true; }
        if (inputManager.isLeftPressed()) { move(-speed, 0); moving = true; }
        if (inputManager.isRightPressed()) { move(speed, 0); moving = true; }

        state = moving ? "walking" : "idle";
    }


    public void animate() {
        if (state.equals("walking")) {
            walk.play(this);
        } else {
            walk.reset();
        }
    }
}
