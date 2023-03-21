package implement_structures.heap;

import java.util.Comparator;

public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Object[] array;

    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index){
        return index / 2;
    }

    private int getLeftChild(int index){
        return index * 2;
    }

    private int getRightChild(int index){
        return index * 2 + 1;
    }

    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];

        for (int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        this.array = newArray;
    }

    public void add(E value){
        if(size + 1 == array.length){
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target) {

        if(comparator != null){
            siftUpComparator(idx, target, comparator);
        }else {
            siftUpComparable(idx, target);
        }
    }



    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

        while (idx > 1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if (comp.compare(target, (E) parentVal) >= 0){
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    private void siftUpComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0){
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        // comparator 가 null 인 array 안은 무조건 comparable한 객체가 담기게 된다.
        array[idx] = comp;
    }
}
