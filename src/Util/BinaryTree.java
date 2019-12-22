/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import Model.*;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;
    
    public boolean search(E e){
        if(binaryTreeSearch(e, null) != null)
            return true;
        else
            return false;
    }
    
    public E binaryTreeSearch(E animeTitle, Node current){
        Node<E> node = new Node(animeTitle);
        // set the current as root
        if(current == null)
            current = root;

        // if correct, return
        if(node.compareTo(current) == 0){
            return (E) current.getData();
        }
        
        // else, check should go left or not
        if(node.compareTo(current) < 0 && current.getLeft() != null){
            return binaryTreeSearch(node.getData(), current.getLeft());
            
        }
        
        // else, check should go right or not 
        else if (node.compareTo(current)>0 && current.getRight() != null)
            return binaryTreeSearch(node.getData(), current.getRight());
        
        // else, no where to go; item is not found
        else
            return null;
    }
    
    public BinaryTree(){
    }
    
    public void insert(E e){
        root = add(root, e);
    }
    
    // Reference = https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    public void inorderTraversal(Node node){
        if(node == null)
            return;
        
        // First left
        inorderTraversal(node.left);
        
        // Then root (the data itself)
        System.out.println(node.getData() + " ");
        
        // Then right
        inorderTraversal(node.right);
    }
    
    // Code reference : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    public Node add(Node<E> root, E data){
        if(root==null){
            root = new Node(data);
            return root;
        }
        
        // check if data is before root
        if(data.compareTo(root.getData()) < 0){
            root.setLeft(add(root.left, data));
        }
        else{
            // data is equal/after root
            root.setRight(add(root.right, data));
        }
        
        return root;
    }
    
    public class Node<E extends Comparable<E>> implements Comparable<Node <E>>{
        public E data;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E e){
            this.data = e;
        }
        
        @Override
        public int compareTo(Node<E> node){
            return this.data.compareTo(node.getData());
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
        
        public String toString(){
            return data.toString();
        }
        
    }
}
