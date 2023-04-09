package implement_structures.tree;

import java.util.Comparator;

public class BinarySearchTree<E> {

    private Node<E> root;
    private int size;

    private final Comparator<? super E> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<? super E> comparator){
        this.comparator = comparator;
        this.root = null;
        size = 0;
    }
}
