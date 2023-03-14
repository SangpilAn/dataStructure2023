package interface_form.list.linked;

import interface_form.List;

public class DoubleLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<E> search(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x;

        if(index + 1 > size / 2){
            x = tail;
            for (int i = size - 1; i > index ; i++) {
                x = x.prev;
            }
            return x;
        }else{
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<>(value);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<>(value);

        if(size == 0){
            addFirst(value);
            return;
        }else {

        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {

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
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {

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
