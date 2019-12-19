/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import Model.*;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;
    
    public static void main(String[] args){
        BinaryTree<Anime> tree = new BinaryTree();
        tree.insert(new Anime("Shokugeki"));
        tree.insert(new Anime("SAO"));
        tree.insert(new Anime("YLIA"));
        tree.insert(new Anime("Test"));
        tree.inorderTraversal(tree.root);
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
        private E data;
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
