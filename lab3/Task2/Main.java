package Task2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Iterator<Integer> iter1 = list1.iterator();

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        Iterator<Integer> iter2 = list2.iterator();

        DoubleIterator<Integer> doubleIterator= new DoubleIterator<>(iter1, iter2);
        while (doubleIterator.hasNext()) {
            System.out.println(doubleIterator.next());
        }
    }    
}
