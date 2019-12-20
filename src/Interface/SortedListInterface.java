package Interface;

public interface SortedListInterface<T extends Comparable<T>> {

  public boolean add(T newEntry);
  /*
    description: Adds a new entry to the sorted list in its proper order.
    postcondition: newEntry the object to be added as a new entry
    return: true, if the addition is successful
  */
  
  // The following methods are described in ListInterface.java
  // as part of the ADT list:
  public T getEntry(int givenPosition);

  public boolean contains(T anEntry);

  public T remove(int givenPosition);
  /*
    description: Gets the position of an entry in the sorted list
    postcondition: anEntry the object to be found
    return: the position of the first or only occurrence of anEntry if it
    occurs in the list; otherwise returns the position where anEntry would
    occur in the list, but as a negative integer
  */
  
  public void clear();

  public int getLength();

  public boolean isEmpty();

  public boolean isFull();
} 

