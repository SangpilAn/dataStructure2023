package interface_form.list;

import interface_form.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size;

    Object[] array;

    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){
        int array_capacity = array.length;

        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if(size == array_capacity){
            int new_capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        if(size < (array_capacity / 2)){
            int new_capacity = array_capacity / 2;

            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public boolean add(E value) {
        return false;
    }

    @Override
    public boolean add(int index, E value) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E value) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
