package Task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> col = new ArrayList<String>();
        col.add("a");
        col.add("a");
        col.add("b");
        col.add("c");
        System.out.println(deleteDuplicates(col)); 
        System.out.println(deleteDuplicates(col).getClass()); 
    }

    // Хэшсет - реализация Сета на основе хэш-таблицы. В Сетах дубликатов быть не может
    public static <T> Collection<T> deleteDuplicates (Collection<T> collection) {
        return new HashSet<T>(collection);
    }
}
