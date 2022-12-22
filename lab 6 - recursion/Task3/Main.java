// Найдите корень уравнения cos⁡(x^5) + x^4 - 345.3*x - 23 = 0 на отрезке [0;10] с точностью по x не хуже 0.001. 
// Известно, что на этом промежутке корень единственный. Используйте для этого метод деления отрезка пополам (и рекурсию).

package Task3;

public class Main {
    public static void main(String[] args) {
        search(0, 10);
    }

    public static double function(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23 ;
    }

    public static double search(double start, double end) {

        double x = (end + start) / 2; 

        // требуемая точность
        if (end - start <= 0.001) { 
            System.out.println("Ответ: " + start);
            return start;
        }
        // поиск по правой половине дерева
        if(function(start) * function(x) > 0) { 
            return search(x, end);
        } else {
            // поиск по левой половине дерева
            return search(start, x);
        }
    }
}
