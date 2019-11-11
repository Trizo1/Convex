import java.awt.*;
import java.util.Scanner;

public class Segment implements Figure {
    private R2Point p, q;
    private double radiusMin;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    public void draw(Graphics g) {
        g.clearRect(-Drawing.width/2, -Drawing.height/2, Drawing.width, Drawing.height);
        g.drawLine(p.get_x(), p.get_y(), q.get_x(), q.get_y());
    }
    public double radiusMinCircle(int x, int y){
        if(Math.sqrt(Math.pow(((Math.abs(p.get_x() - x))), 2) + Math.pow(((Math.abs(p.get_y() - y))), 2)) > Math.sqrt(Math.pow(((Math.abs(q.get_x() - x))), 2) + Math.pow(((Math.abs(q.get_y() - y))), 2)))
            radiusMin = Math.sqrt(Math.pow(((Math.abs(p.get_x() - x))), 2) + Math.pow(((Math.abs(p.get_y() - y))), 2));
        else
            radiusMin = Math.sqrt(Math.pow(((Math.abs(q.get_x() - x))), 2) + Math.pow(((Math.abs(q.get_y() - y))), 2));
        return radiusMin;
    }
    public void drawMinCircle(Graphics g, int x, int y){
        g.setColor(new Color(0,0,0));
        g.fillOval(x,y, 3,3);
        g.drawOval(x - (int)radiusMin, y - (int)radiusMin, 2*(int)radiusMin , 2*(int)radiusMin );
    }
}
