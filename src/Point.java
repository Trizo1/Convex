import java.awt.*;

public class Point implements Figure {
    private R2Point p;
    public Point(R2Point p) {
        this.p = p;
    }
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public double radiusMinCircle(int x, int y) { return 0; }
    public Figure add(R2Point q) {
        if (!R2Point.equal(p,q)) return new Segment(p, q);
        else return this;
    }
    public void draw(Graphics g) {
        g.fillOval(p.get_x(), p.get_y(), 3,3);
    }
    public void drawMinCircle(Graphics g, int x, int y){
        g.setColor(new Color(0,0,0));
        g.fillOval(x,y, 3,3);
    }
}
