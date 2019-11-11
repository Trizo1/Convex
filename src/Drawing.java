import javax.swing.*;
import java.awt.*;

public class Drawing extends JFrame {
    public static final int width = 1000;
    public static final int height = 1000;
    private Convex convex;
    public  Drawing(Convex convex) {
        this.convex=convex;
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Окно рисования");
        this.setLocationRelativeTo(null);
        this.setState(JFrame.ICONIFIED);
    }
    @Override
    public void paint(Graphics g) {
        g.translate(Drawing.width/2, Drawing.height/2);
        g.setColor(new Color(255, 5, 0));
        convex.draw(g);
        convex.drawMinCircle(g);
    }
}
