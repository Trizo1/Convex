import java.awt.*;
import java.util.Scanner;

public class Convex {
    private Figure fig;
    private int xcircle,ycircle;
    public Convex() {
        fig = new Void();
    }
    public void add(R2Point p) {
        fig = fig.add(p);
    }
    public double area() {
        return fig.area();
    }
    public double perimeter() {
        return fig.perimeter();
    }
    public void draw(Graphics g){
        fig.draw(g);
    }
    public void addPointCircle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите координату х для центра окружности");
        xcircle = scan.nextInt();
        System.out.println("Введите координату у для центра окружности");
        ycircle = scan.nextInt();
    }
    public double radiusMinCircle(){
        return fig.radiusMinCircle(xcircle, ycircle);
    }
    public void drawMinCircle(Graphics g){
        fig.drawMinCircle(g, xcircle, ycircle);
    }
}
