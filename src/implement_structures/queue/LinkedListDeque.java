package implement_structures.queue;

import interface_form.Queue;

import java.util.NoSuchElementException;

public class LinkedListDeque<E> implements Queue<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedListDeque(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E value) {
        return offerLast(value);
    }

    public boolean offerFirst(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        if(head != null){
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }

        return true;
    }

    public boolean offerLast(E value){

        if(size == 0){
            offerFirst(value);
        }

        Node<E> newNode = new Node<>(value);

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){

        if(size == 0){
            return null;
        }

        E element = head.data;
        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        if(nextNode != null){
            nextNode.prev = null;
        }

        head = nextNode;
        size--;

        if (size == 0){
            tail = null;
        }

        return element;
    }

    public E pollLast(){
        if (size == 0){
            return null;
        }

        Node<E> preNode = tail.prev;

        E element = tail.data;

        tail.data = null;
        tail.prev = null;

        if(preNode != null){
            preNode.next = null;
        }

        tail = preNode;
        size--;

        if(size == 0){
            head = null;
        }

        return element;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeFirst(){
        E element = poll();

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    public E removeLast(){
        E element = pollLast();

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if (size == 0){
            return null;
        }

        return head.data;
    }

    public E peekLast(){
        if(size == 0){
            return null;
        }

        return tail.data;
    }

    public E element(){
        return getFirst();
    }

    public E getFirst(){
        E item = peek();

        if(item == null){
            throw new NoSuchElementException();
        }

        return item;
    }

    public E getLast(){
        E item = peekLast();

        if(item == null){
            throw new NoSuchElementException();
        }

        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object value){
        for (Node<E> x = head; x != null ; x = x.next) {
            if(value.equals(x.data)){
                return true;
            }
        }

        return false;
    }

    public void clear(){
        for (Node<E> x = head; x != null;){
            Node<E> nextNode = x.next;

            x.data = null;
            x.next = null;
            x.prev = null;

            x = nextNode;
        }

        head = tail = null;
        size = 0;
    }
}
