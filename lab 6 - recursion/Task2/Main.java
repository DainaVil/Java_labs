// 2)	Напишите метод, который проверяет, входит ли в массив заданный элемент или нет. 
// Используйте перебор и двоичный поиск для решения этой задачи. 
// Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).

package Task2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // создание массива случайных чисел от 0 до 100
        int n = 10000000; 
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 100);
        }

        // for (int i = 0; i < 20; i++) {
        //     System.out.print(array[i] + " ");
        // }

        // сортировка массива для правильной работы бин. поиска
        Arrays.sort(array);

        System.out.println("Поиск методом перебора...");
        long start = System.nanoTime();
        findRegularly(array, 60);
        long finish = System.nanoTime(); 
        System.out.println("Времени затрачено: " + (double) (finish - start));
        
        System.out.println("Поиск двоичным методом...");
        start = System.nanoTime();
        findRecursively(array, 60, 0, array.length);
        finish = System.nanoTime(); 
        System.out.println("Времени затрачено: " + (double) (finish - start));
    }

    public static int findRegularly(int[] array, int x) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        System.out.println("Элемент не найден");
        return -1;
    }

    public static int findRecursively(int[] array, int x , int i1, int i2) {
        
        // нахождение середины
        int middle = (i1 + i2) / 2;

        //предусматриваем выход из рекурсии, если нечего больше делить
        if (i2 <= i1) return -1; 

        if (array[middle] == x) {
            return middle;

        } else if (array[middle] > x) {
                // поиск по левой половине
                return findRecursively(array, x, i1, middle - 1);
        } else {
            // поиск по правой половине
            return findRecursively(array, x, middle + 1, i2);
        }
    }
}
