package implement_structures.linkedList;

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
