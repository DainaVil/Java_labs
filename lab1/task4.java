public class task4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println("a= " + a);
        System.out.println("b= " + b);

        int c = a;
        a = b;
        b = c;

        System.out.println("a= " + a);
        System.out.println("b= " + b);

        a = a + b - (b = a);
        
        System.out.println("a= " + a);
        System.out.println("b= " + b);
    }
}
