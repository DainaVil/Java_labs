package Task1;

public class Main {
    public static void main(String[] args) {
        var M1 = new Integer[][] {{1,2}, {3, 4, 5}};
        var M2 = new String[][] {{"a","b"}, {"c", "d"}};

        System.out.println("Матрица 1");
        var iter1 = new MatrixIterator<Integer>(M1);
        while (iter1.hasNext()) {
            System.out.print(iter1.next()+ " ");
        }

        System.out.println("\nМатрица 2");
        var iter2 = new MatrixIterator<String>(M2);
        while (iter2.hasNext()) {
            System.out.print(iter2.next() + " ");
        }
        
    }
}
