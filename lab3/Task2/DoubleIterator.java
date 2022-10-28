package Task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

// В этом задании сначала происходит итерация по первому итератору, затем по второму
public class DoubleIterator<T> implements Iterator<T>{
    
    private Iterator<T> iter1;
    private Iterator<T> iter2;

    // Конструктор
    public DoubleIterator(Iterator<T> iter1, Iterator<T> iter2) {
        this.iter1 = iter1;
        this.iter2 = iter2;
    }

    @Override
    public boolean hasNext() {
        while (iter1.hasNext()) return true;
        while (iter2.hasNext()) return true;
        return false;
    }

    @Override
    public T next() {
        if(!hasNext()) throw new NoSuchElementException();
        while (iter1.hasNext()) return iter1.next();
        while (iter2.hasNext()) return iter2.next();
        return null;
    }
}
