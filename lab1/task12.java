public class task12 {
    public static void main(String[] args) {
        System.out.println(dist(1.5, 2, 5, 6));
    }

    public static double dist(double x1, double y1, double x2, double y2) {
        System.out.println("x1 = " + x1
                            + "\ny1 = " + y1
                            + "\nx2 = " + x2
                            + "\ny2 = " + y2
                            );
        return Math.pow((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1), 0.5);
    }
}
