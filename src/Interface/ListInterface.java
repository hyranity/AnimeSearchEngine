/**
 * ListInterface ADT
 * 
 * DESCRIPTION
 * This is the interface for the custom List class, which allows the storing of objects on a list structure.
 * It contains all necessary functions, allowing user to add, remove, and retrieve items of the list.
 * Certain methods such as validateSize() and copyArray() are used by the List class itself to ensure that all functions work as expected. 
 * Detailed explanation of each method will be listed below
 * 
 * E = Element of the list
 */

package Interface;

public interface ListInterface<E> {
    
    E search(E e);
    /*
    description: Searches the list for an item and returns the item
    precondition: none
    postcondition: none
    return: E (null if not found)
    */

    E getRecord(int index);
    /*
    description: Returns an item based on the given index
    precondition: Item must exist in the list
    postcondition: none
    return: E
    */
    
    boolean isExists(E e);
     /*
    description: Searches for an item to see if it exists. If so, return true. Else, return false.
    precondition: none
    postcondition: none
    return: boolean (true if item exists; false if not)
    */

    void add(E e);
     /*
    description: Adds an item
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
    
    
    void remove(int index);
     /*
    description: Removes an item
    precondition: none
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
    description: Displays all items in a string
    precondition: none
    postcondition: none
    return: String containing all the items in a "list" format.
    */
    
    String toStringWithCommas();
     /*
    description: Displays all items in a string, where each item is separated by another with a comma
    precondition: none
    postcondition: none
    return: String
    */
    
    void clear();
     /*
    description: Clears all items
    precondition: none
    postcondition: none
    return: none
    */

}
