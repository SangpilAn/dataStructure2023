package interface_form.list.linked;

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
