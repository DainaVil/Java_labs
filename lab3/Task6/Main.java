package Task6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        addElements(arrayList, linkedList, random);
        pickFromArrayList(arrayList, random);
        pickFromLinkedList(linkedList, random);
    }

    public static void addElements(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Random random) {
        for (int i=0; i<=1000000; i++) {
            arrayList.add(random.nextInt(1, 100));
            linkedList.add(random.nextInt(1, 100));
        }
    }
    
    public static double pickFromArrayList(ArrayList<Integer> arrayList, Random random) {
        double start = System.currentTimeMillis();
        for (int i=0; i<=100000; i++) {
            arrayList.get(random.nextInt(1, 1000000));
        }
        double finish = System.currentTimeMillis();
        double result = finish - start;
        System.out.println("ArrayList: " + result);
        return result;
    }

    public static double pickFromLinkedList(LinkedList<Integer> linkedList, Random random) {
        double start = System.currentTimeMillis();
        for (int i=0; i<=100000; i++) {
            linkedList.get(random.nextInt(1, 1000000));
        }
        double finish = System.currentTimeMillis();
        double result = finish - start;
        System.out.println("LinkedList: " + result);
        return result;
    }

    // ArrayList намного быстрее, так как у LinkedList поиск занимает O(n)
}
