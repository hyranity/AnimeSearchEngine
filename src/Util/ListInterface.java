/**
 * ListInterface ADT
 * 
 * DESCRIPTION
 * This is the interface for the custom List class, which allows the storing of objects on a list structure.
 * It contains all necessary functions, allowing user to add, remove, and retrieve elements of the list.
 * Certain methods such as validateSize() and copyArray() are used by the List class itself to ensure that all functions work as expected. 
 * Detailed explanation of each method will be listed below
 * 
 * E = Element of the list
 */

package Util;

public interface ListInterface<E> {

    E getRecord(int index);
    /*
    description: Returns an element based on the given index
    precondition: Item must exist in the list
    postcondition: none
    return: E
    */

    void add(E e);
     /*
    description: Adds an element
    precondition: none
    postcondition: List size is increased
    return: none
    */
    
    void validateSize();
     /*
    description: Ensures that the list has enough space. It will increase the actual size 
    if the current size (just a size pointer, not the actual size) exceeds the actual size.
    This is used when adding an item.
    
    precondition: none
    postcondition: List actual size will be increased if not enough space.
    return: none
    */
    
    public E[] copyArray(E[] oldArray, E[] newArray);
     /*
    description: Copies oldArray elements to newArray, and returns the newArray
    precondition: none
    postcondition: newArray now has same elements as oldArray
    return: An array of E
    */
    
    void remove(int index);
     /*
    description: Removes an element
    precondition: list must not be empty, indexed item must exist
    postcondition: List size is decreased
    return: none
    */
    
    int indexOf(E e);
    /*
    description: Finds an item and returns its index. Returns -1 if not found
    precondition: 
    postcondition: none
    return: index of the item, or -1 if not found
    */
    
    String toString();
     /*
    description: Displays all elements in a string
    precondition: none
    postcondition: none
    return: a String
    */
    

}
