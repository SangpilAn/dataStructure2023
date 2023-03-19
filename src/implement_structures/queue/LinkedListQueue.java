package implement_structures.queue;

import interface_form.Queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

    Node<E> head;
    Node<E> tail;
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<>(value);

        if(size == 0){
            head = newNode;
        }else{
            tail.next = newNode;
        }

        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {

        if(size == 0){
            return null;
        }

        E element = head.data;

        head = head.next;
        size--;

        return element;
    }

    public E remove(){
        E element = poll();

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {

        if(size == 0){
            return null;
        }

        return head.data;
    }

    public E element(){
        E element = peek();

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object value){

        for (Node<E> x = head; x != null; x = x.next){
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
            x = nextNode;
        }

        size = 0;
        head = tail = null;
    }
}
