package interface_form.list.linked;

import interface_form.List;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<>(value);

        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    public void addLast(E value){
        Node<E> newNode = new Node<>(value);

        if(size == 0){
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            addFirst(value);
            return;
        }

        if(index == size){
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        Node<E> preNode = search(index-1);

        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;

    }

    public E remove(){
        Node<E> headNode = head;

        if(headNode == null){
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        Node<E> nextNode = headNode.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        if(size == 0){
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return remove();
        }

        Node<E> preNode = search(index-1);
        Node<E> targetNode = preNode.next;
        Node<E> nextNode = targetNode.next;

        E element = targetNode.data;

        preNode.next = nextNode;

        if(preNode.next == null){
            tail = preNode;
        }

        targetNode.data = null;
        targetNode.next = null;
        size--;

        return element;
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
