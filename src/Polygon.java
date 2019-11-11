import java.awt.*;
import java.util.Scanner;

public class Polygon extends Deq implements Figure {
    private double s, p;
    private R2Point firstPoint, secondPoint, point;
    private int xmax, ymax;
    private double radiusMin;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a);
            pushBack(c);
        } else {
            pushFront(c);
            pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter() {
        return p;
    }

    public double area() {
        return s;
    }

    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i = length(); i > 0 && !t.light(back(), front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i > 0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        return this;
    }
    public void draw(Graphics g) {
        g.clearRect(-Drawing.width/2, -Drawing.height/2, Drawing.width, Drawing.height);
        firstPoint = front();
        secondPoint = back();
        for(int i=length(); i>=0; i--){
            g.drawLine(firstPoint.get_x(), firstPoint.get_y(), secondPoint.get_x(), secondPoint.get_y());
            pushBack(firstPoint);
            firstPoint=secondPoint;
            secondPoint=popFront();
        }
    }
    public double radiusMinCircle(int x, int y){
        point=front();
        xmax = Math.abs(point.get_x() - x);
        ymax = Math.abs(point.get_y() - y);
        for(int i=length(); i>=0; i--){
            pushBack(point);
            point=popFront();
            if(Math.sqrt(Math.pow(((Math.abs(point.get_x() - x))), 2) + Math.pow(((Math.abs(point.get_y() - y))), 2)) > Math.sqrt(Math.pow(xmax, 2) + Math.pow(ymax, 2))) {
                xmax = Math.abs(x - point.get_x());
                ymax = Math.abs(y - point.get_y());
            }
        }
        radiusMin = Math.sqrt(Math.pow(xmax, 2) + Math.pow(ymax, 2));
        return radiusMin;
    }
    public void drawMinCircle(Graphics g, int x, int y){
        g.setColor(new Color(0,0,0));
        g.fillOval(x,y, 3,3);
        g.drawOval(x - (int)radiusMin, y - (int)radiusMin, 2*(int)radiusMin , 2*(int)radiusMin );
    }
}
