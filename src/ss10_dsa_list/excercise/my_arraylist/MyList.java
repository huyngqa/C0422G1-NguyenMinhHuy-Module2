package ss10_dsa_list.excercise.my_arraylist;

public class MyList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bound");
    }

    public E remove(int index) {
        checkIndex(index);

        E e = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public void add(int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    //    public E clone(){
//
//    }
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity();  // Increments modCount!!
        elements[size++] = e;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
