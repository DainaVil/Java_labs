package task2;

import java.util.Random;

class Vector {
    double x;
    double y;
    double z;

    // Конструктор класса
    public Vector (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Перегрузка конструктора
    public Vector () {
        Random random = new Random();
        this.x = random.nextDouble(50.0);
        this.y = random.nextDouble(50.0);
        this.z = random.nextDouble(50.0);
    }

    // Печать вектора
    public void print_vector() {
        System.out.format(" (%.1f, %.1f, %.1f) \n", x, y, z);
    }

    // Длина вектора
    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    // Скалярное произведение векторов
    public static double dotProduct(Vector v1, Vector v2) {
        return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
    }

    // Векторное произведение двух векторов
    public static Vector crossProduct(Vector v1, Vector v2) {
        return new Vector(v1.y*v2.z - v1.z*v2.y, v1.z*v2.x - v1.x*v2.z, v1.x*v2.y - v1.y*v2.x);
    }

    // Косинус угла между векторами
    public static double cos(Vector v1, Vector v2) {
        return dotProduct(v1, v2) / (v1.length()*v2.length());
    }

    // Сложение векторов
    public static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.x+v2.x, v1.y+v2.y, v1.z+v2.z);
    }
    // Вычитание векторов
    public static Vector substract(Vector v1, Vector v2) {
        return new Vector(v1.x-v2.x, v1.y-v2.y, v1.z-v2.z);
    }

    // Метод возвращает массив векторов размера N
    public static Vector[] randVectors(int N) {
        Vector[] arrayVectors = new Vector[N];
        for (int i = 0; i < N; i++) {
            arrayVectors[i] = new Vector();
        }
        return arrayVectors;
    }

}

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(1.0, 2.0, 3.0);
        Vector v2 = new Vector(1.0, 2.0, 3.0);
        Vector v3 = new Vector(1.0, 1.0, 1.0);

        System.out.print("Вектор 1 ");
        v1.print_vector();
        System.out.print("\nВектор 2 ");
        v2.print_vector();
        System.out.print("\nВектор 3 ");
        v3.print_vector();


        System.out.println("\nДлина вектора 1");
        double res = v1.length();
        System.out.println(res);

        System.out.println("\nСкалярное произведение 1 и 2");
        res = Vector.dotProduct(v1, v2);
        System.out.println(res);

        System.out.println("\nВекторное произведение 1 и 2");
        Vector resV = Vector.crossProduct(v1, v2);
        resV.print_vector();

        System.out.println("\nКосинус угла между векторами 1 и 3");
        res = Vector.cos(v1, v3);
        System.out.println(res);

        System.out.println("\n1 + 2");
        resV = Vector.add(v1, v2);
        resV.print_vector();

        System.out.println("\n1 - 3");
        resV = Vector.substract(v1, v3);
        resV.print_vector();

        int N = 5;
        Vector[] array = Vector.randVectors(N);
        System.out.println("\nМассив векторов размера " + N);
        for (Vector v : array) {
            v.print_vector();
        }

    }
}


