package task1;

import java.util.Random;

// Класс матрицы
class Matrix {

    int n;
    int m;
    double[][] thisMatrix;

    // Конструктор класса
    public Matrix(int n, int m) {
        this.thisMatrix = new double[n][m];
        this.n = n;
        this.m = m;
        this.random_fill();
    }

    // Перегрузка конструктора при передаче готовой матрицы 
    public Matrix(double[][] thisMatrix) {
        this.thisMatrix = thisMatrix;
        this.n = thisMatrix.length;
        this.m = thisMatrix[0].length;
    }

    // Заполнение матрицы случайными числами
    private void random_fill() {
        Random random = new Random();
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                thisMatrix[i][j] = random.nextInt(50);
            }
        }
    }

    //Вывод матрицы на экран
    public void print_matrix() {
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                System.out.printf("%.1f  ", thisMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    // Сложение и вычитание матриц
    public Matrix addition_substraction(Matrix secondMatrix, boolean substraction) {
        if ((this.n != secondMatrix.n) || (this.m != secondMatrix.m)) {
            System.out.println("Размерности матриц не совпадают");
            return null;
        } else {
            double[][] newMatrix = new double[this.n][this.m];
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    if (substraction == false) {
                        newMatrix[i][j] = this.thisMatrix[i][j] + secondMatrix.thisMatrix[i][j];
                    } else {
                        newMatrix[i][j] = this.thisMatrix[i][j] = secondMatrix.thisMatrix[i][j];
                    }
                }
            }
            return new Matrix(newMatrix);
        }
    }

    // Умножение матрицы на число k
    public Matrix multiply(double k){
        double[][] newMatrix = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                newMatrix[i][j] = this.thisMatrix[i][j] * k;
            }
        }
        return new Matrix(newMatrix);
    }

    // Умножение матрицы на другую матрицу
    public Matrix multiply(Matrix secondMatrix) {
        if (this.m != secondMatrix.n) {
            System.out.println("Эти матрицы не могут быть умножены");
            return null;
        }
        double[][] newMatrix = new double[this.n][secondMatrix.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < secondMatrix.m; j++) {
                for (int k = 0; k < this.m; k++) {
                    newMatrix[i][j] += this.thisMatrix[i][k] * secondMatrix.thisMatrix[k][j];
                }
            }
        }
        return new Matrix(newMatrix);
    }

    // Транспонирование матрицы
    public Matrix transpose() {
        double[][] newMatrix = new double[this.m][this.n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                newMatrix[j][i] = thisMatrix[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    // Возведение матрицы в степень
    public Matrix exponentiation(int N) {
        if (this.n != this.m) {
            System.out.println("Можно возвести в степень только квадратную матрицу");
            return null;
        }

        Matrix newMatrix = this;
        Matrix secondMatrix = this;
        int counter = 1;
        while (counter < N) {
            newMatrix = newMatrix.multiply(secondMatrix);
            counter++;
        }
        return newMatrix;
    }
}

public class Main {
    public static void main(String[] args) {

        Matrix A = new Matrix(3, 2);
        Matrix B = new Matrix(3, 2);
        Matrix C = new Matrix(2, 3);
        Matrix D = new Matrix(3, 3);
        
        System.out.println("Матрица А:");
        A.print_matrix();
        System.out.println("\nМатрица B:");
        B.print_matrix();

        // Сложение и вычитание матриц
        System.out.println("\nA + B:");
        Matrix result = A.addition_substraction(B, false);
        result.print_matrix();
        System.out.println("\nA - B:");
        result = A.addition_substraction(B, true);
        result.print_matrix();
        System.out.println("\nМатрица C:");
        C.print_matrix();
        System.out.println("\nA + C:");
        result = A.addition_substraction(C, false);

        // Умножение матрицы на число
        System.out.println("\nA * 2,5:");
        result = A.multiply(2.5);
        result.print_matrix();

        // Умножение матриц
        System.out.println("\nA * C:");
        result = A.multiply(C);
        result.print_matrix();
        System.out.println("\nA * B:");
        result = A.multiply(B);

        System.out.println("\nТранспонированная матрица A:");
        Matrix AT = A.transpose();
        AT.print_matrix();
        
        System.out.println("\nМатрица D:");
        D.print_matrix();

        // Возведение матрицы в степень
        result = D.exponentiation(2);
        System.out.println("\nМатрица D в степени 2:");
        result.print_matrix();
    }
}
