// 1)	Дано натуральное число n. Выведите все числа от 1 до n.

package Task1;

public class Main {

    public static void main(String[] args) {
        
        var n = 10;
        recursionPrint(n);
    }

    public static void recursionPrint(int n) {
        if (n == 0) {
            return;
        } else {
            recursionPrint(n - 1);
        }

        System.out.print(n + " ");
        return;
    }
}
