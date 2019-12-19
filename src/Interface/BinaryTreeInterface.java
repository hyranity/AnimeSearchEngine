/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author mast3
 */
public interface BinaryTreeInterface<E> {
    E getRootData();
    boolean isEmpty();
    void clear();
    void insert(E e);
}
