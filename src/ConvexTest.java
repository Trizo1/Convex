
public class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        Drawing d = new Drawing(convex);
        convex.addPointCircle();
        while (true) {
            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = " + convex.perimeter());
            System.out.println("Радиус минимального круга = " + convex.radiusMinCircle());
            d.repaint();
        }
    }
}