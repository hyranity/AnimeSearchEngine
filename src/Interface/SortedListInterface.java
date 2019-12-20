package Interface;

public interface SortedListInterface<T extends Comparable<T>> {

  public boolean add(T newEntry);
  /*
    description: Adds a new entry to the sorted list in its proper order.
    postcondition: newEntry the object to be added as a new entry
    return: true, if the addition is successful
  */

  public T getEntry(int givenPosition);
  /*
    description: retrieves the entry at position givenPosition in the list
    precondition: newPosition must be between 1 to total entries
    Returns: The entry at position givenPosition.
  */

  public boolean contains(T anEntry);
  /*
    description: Determines whether the list contains anEntry
    return: true if anEntry is in the list, or false of not
  */

  public T remove(int givenPosition);
  /*
    description: Removes a specified entry from the sorted list.
    postcondition: anEntry the object to be removed
    return: true, if anEntry was located and removed
  */
  
  public void clear();
  /*
    description: Clear all items
  */
  
  public int getLength();
  /*
    description: Get the number of entries currently in the list
    return: the number of entries currently in the list
  */
  
  public boolean isEmpty();
  /*
    description: Check the list is empty or not
    return: true, if is empty
  */

  public boolean isFull();
  /*
    description: Check the list is full or not
    return: true of the list is full, or false if not full
  */
} 

