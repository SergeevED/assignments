package hw07;

import java.util.Arrays;

public class JavaArrayOrderedList<A extends Comparable<A>> extends JavaOrderedList<A> {
    private int allocated = 100;
    private A[] array = (A[]) new Comparable[100];

    private void reallocate() {
        allocated += 100;
        array = Arrays.copyOf(array, allocated);
    }

    @Override
    public void add(A newElem) {
        if (allocated == length)
            reallocate();
        int index = 0;
        while(index < length && ((array[index]).compareTo(newElem) < 0))
            index++;
        for (int i = length - 1; i >= index; i--)
            array[i + 1] = array[i];
        array[index] = newElem;
        length++;
    }

    @Override
    public A getByIndex(int index) {
        if (index < 0 || index >= length)
            return null;
        return (A) array[index];
    }

    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index >= length)
            return false;
        for (int i = index; i < length - 1; i++)
            array[i] = array[i + 1];
        length--;
        return true;
    }
}