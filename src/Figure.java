import java.awt.*;

public interface Figure {
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics g);
    public double radiusMinCircle(int x, int y);
    public void drawMinCircle(Graphics g, int x, int y);
}
