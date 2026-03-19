import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<GameObject> objects = new ArrayList<>();

    public Canvas(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        Canvas canvas = this;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(canvas);
        frame.setVisible(true);
    }

    public void addGameObject(GameObject obj) {
        synchronized (objects) {
            objects.add(obj);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        synchronized (objects) {
            for (GameObject obj : objects) {
                obj.draw(g);
            }
        }
    }
}
