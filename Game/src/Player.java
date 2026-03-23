public class Player extends GameObject {
    private int speed = 8;
    int currentDirection = 0;

    private String state = "idle"; // idle, walking
    private Animation walk = new Animation(new String[] { "player_1.png", "player_2.png" }, 8);


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

        int dx = 0;
        int dy = 0;

        if (inputManager.isUpPressed()) { dy -= 1; }
        if (inputManager.isDownPressed()) { dy += 1; }
        if (inputManager.isLeftPressed()) { dx -= 1; flip(-1); }
        if (inputManager.isRightPressed()) { dx += 1; flip(1); }

        // if moving
        if (dx != 0 || dy != 0) {
            // normalize speed - fixes diagonal movement being faster
            double length = Math.sqrt(dx * dx + dy * dy);
            move((int) Math.round(dx / length * speed), (int) Math.round(dy / length * speed));

            state = "walking";
        } else {
            state = "idle";
        }
    }


    public void animate() {
        if (state.equals("walking")) {
            walk.play(this);
        } else {
            walk.reset();
        }
    }
}
