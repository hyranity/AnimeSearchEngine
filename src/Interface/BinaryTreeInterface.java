package Interface;

import Util.BinaryTree;
import Util.BinaryTree.Node;
//Author: Jane
public interface BinaryTreeInterface<E extends Comparable<E>> {
    
    boolean search (E e);
    /*  
        description: search for an element in binary tree
        return: E, if it is not equal to null, then return true. (vice versa)
    */
    
    E binaryTreeSearch(E animeTitle, Node current); 
    /*
        description: search for an element (in this case, it's animeTitle) input by the 
                    user via Binary Search Tree to check whether it exists 
        return: the searched element, E.
    */
    
    void insert (E e);
    /*
        description: insert or add new element to a node in general; if root is not null, it will 
                    go to either left/right node, else the element will be filled into root.
        precondition: at least a node must be empty (no element inside)
        postcondition: a new element has been inserted into a node
        
    */
    
    void inorderTraversal (Node node);
    /*
        description: traverse tree  from its left node, root, and lastly to right node
    */

    Node add(BinaryTree<E>.Node<E> root, E data);
    /*
        description: add new data entry into a node
        precondition: a node must be empty in order to be filled in with the new data
        postcondition: a node filled in with the new data entry
        return: root/entire tree
    */
    
    BinaryTree<E>.Node<E> getRoot();
    /*
        description: to get/retrieve a root from a binary tree
        return: root retrieved.
    */
    
}
