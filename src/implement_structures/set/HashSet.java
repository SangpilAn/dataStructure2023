package implement_structures.set;

import interface_form.Set;

public class HashSet<E> implements Set<E> {

    private final static int DEFAULT_CAPACITY = 1 << 4;
    private final static float LOAD_FACTOR = 0.75f;

    Node<E>[] table;
    private int size;

    public HashSet(){
        table = (Node<E>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static final int hash(Object key){
        int hash;
        if(key == null){
            return 0;
        }else {
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
        }
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
