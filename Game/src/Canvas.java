import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<GameObject> objects = new ArrayList<>();

    public void addObject(GameObject obj) {
        objects.add(obj);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GameObject obj : objects) {
            obj.draw(g);
        }
    }
}
