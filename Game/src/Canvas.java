import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<GameObject> objects = new ArrayList<>();

    public Canvas(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        Canvas canvas = this;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(true);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.requestFocusInWindow();
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
