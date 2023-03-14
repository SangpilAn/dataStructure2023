package implement_structures.list.linked;

import interface_form.List;

import java.util.NoSuchElementException;

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
        }else{
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x;
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
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
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

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);

        Node<E> preNode = search(index-1);
        Node<E> nextNode = preNode.next;

        preNode.next = newNode;
        newNode.prev = preNode;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }

    public E remove(){
        Node<E> headNode = head;

        if(headNode == null){
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        Node<E> nextNode = headNode.next;

        headNode.data = null;
        headNode.next = null;

        if (nextNode != null){
            nextNode.prev = null;
        }

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

        Node<E> targetNode = search(index);
        Node<E> preNode = targetNode.prev;
        Node<E> nextNode = targetNode.next;

        E element = targetNode.data;

        targetNode.data = null;
        targetNode.next = null;
        targetNode.prev = null;

        preNode.next = nextNode;

        if(nextNode == null){
            tail = preNode;
        }else{
            nextNode.prev = preNode;
        }

        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> x = head;

        for (;x != null; x = x.next){
            if(value.equals(x.data)){
                break;
            }
        }

        if(x == null){
            return false;
        }

        if (x.equals(head)){
            remove();
        }else {
            Node<E> preNode = x.prev;
            Node<E> nextNode = x.next;

            x.data = null;
            x.next = null;
            x.prev = null;

            preNode.next = nextNode;

            if(nextNode == null){
                tail = preNode;
            }else {
                nextNode.prev = preNode;
            }
            size--;
        }

        return true;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        search(index).data = value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for (Node<E> i = head; i != null; i = i.next){
            if(value.equals(i.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object value){
        int index = size;

        for (Node<E> i = tail; i != null; i = i.prev){
            index--;
            if(value.equals(i.data)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (Node<E> i = head; i != null;){
            Node<E> nextNode = i.next;
            i.data = null;
            i.next = null;
            i.prev = null;
            i = nextNode;
        }
        head = tail = null;
        size = 0;
    }
}
