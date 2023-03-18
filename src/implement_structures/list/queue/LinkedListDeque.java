package implement_structures.list.queue;

import interface_form.Queue;

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
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
