public class task9 {
    public static void main(String[] args) {
        System.out.println(diff21(20));
        System.out.println(diff21(1));
        System.out.println(diff21(-1));
        System.out.println(diff21(50));
    }

    public static int diff21(int a) {
        System.out.println("a = " + a);
        return 21 - a;
    }
}
