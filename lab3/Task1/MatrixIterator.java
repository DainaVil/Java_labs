package Task1;

import java.util.Iterator;

// здесь T - любой тип данных
public class MatrixIterator<T> implements Iterator<T> {
    private int size; 
    private int pos = 0; 
    private int row = 0;
    private int col = 0; 
    private T[][] matrix;

    // Конструктор
    public MatrixIterator(T[][] matrix) {
        this.matrix = matrix;
        this.size = countSize(matrix);
    }

    // Подсчет общего числа элементов
    public int countSize(T[][] matrix) {
        int count = 0;
        for (T[] row : matrix) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return pos < size;
    }

    @Override
    public T next() {
        if (pos >= size) throw new ArrayIndexOutOfBoundsException();
        
        T element = matrix[row][col];  
        pos++;
        col++;
        
        // переход на следующую строку
        while (row < matrix.length && col >= matrix[row].length) {
            col = 0;
            row++;
        }
        return element;
    }
}

