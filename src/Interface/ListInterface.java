/**
 * ListInterface ADT by Johann Lee Jia Xuan
 * 
 * DESCRIPTION
 * This is the interface for the custom List class, which allows the storing of objects on a list structure.
 * It contains all necessary functions, allowing user to add, remove, and retrieve items of the list.
 * Certain methods such as validateSize() are used by the List class itself to ensure that all functions work as expected. 
 * Detailed explanation of each method will be listed below
 * 
 * E = Element of the list
 */

package Interface;

public interface ListInterface<E> {
    
    E search(E e);
    /*
    description: Searches the list for an item and returns the item
    return: E (null if not found), which is the searched item
    */

    E getRecord(int index);
    /*
    description: Returns an item based on the given index
    precondition: Item must exist in the list
    return: E, which is the item at the specified index. If the index is incorrect (eg. Out of bounds), null will be returned.
    */
    
    boolean isExists(E e);
     /*
    description: Searches for an item to see if it exists. If so, return true. Else, return false.
    return: boolean (true if item exists; false if not)
    */

    void add(E e);
     /*
    description: Adds an item
    postcondition: List size is increased
    */
    
    
    void remove(int index);
     /*
    description: Removes an item
    postcondition: List size is decreased
    */
    
    int indexOf(E e);
    /*
    description: Finds an item and returns its index. Returns -1 if not found
    return: index of the item, or -1 if not found
    */
    
    String toString();
     /*
    description: Displays all items in a string
    return: String containing all the items in a "list" format.
    */
    
    void clear();
     /*
    description: Clears all items
    */

}
