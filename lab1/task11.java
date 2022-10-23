public class task11 {
    public static void main(String[] args) {
        System.out.println(geometric(2, 6)); 
    }

    public static double geometric(int a, int b) {
        System.out.println("a = " + a + "\nb = " + b);
        return Math.pow(a*b, 0.5);
    }
}
