package implement_structures.queue;

public class Node<E> {

    E data;
    Node<E> next;
    Node<E> prev;

    Node(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
