package implement_structures.list.queue;

public class Node<E> {

    E data;
    Node<E> next;

    Node(E data){
        this.data = data;
        this.next = null;
    }
}
