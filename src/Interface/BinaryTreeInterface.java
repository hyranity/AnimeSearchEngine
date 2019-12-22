package Interface;

import Util.BinaryTree;
import Util.BinaryTree.Node;

public interface BinaryTreeInterface<E extends Comparable<E>> {
    
    boolean search (E e);
    /*  
        description: to search for an element on the list
        return: it the element is not equal to null, then return true. (vice versa)
    */
    
    E binaryTreeSearch(E animeTitle, Node current); 
    /*
        description: to search 
    */
    
    void insert (E e);
    
    void inorderTraversal (Node node);

    Node add(BinaryTree<E>.Node<E> root, E data);
    
    BinaryTree<E>.Node<E> getRoot();
    
    
    /*
    E getRootData();
        description: 
    
    
    boolean isEmpty();
     
    
    
    void clear();
     
    
    
    void insert(E e);
      
    
    */
}
