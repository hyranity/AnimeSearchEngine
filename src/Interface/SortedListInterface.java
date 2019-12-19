package Interface;

public interface SortedListInterface<T extends Comparable<T>> {

  public boolean add(T newEntry);

  // The following methods are described in ListInterface.java
  // as part of the ADT list:
  public T getEntry(int givenPosition);

  public boolean contains(T anEntry);

  public T remove(int givenPosition);

  public void clear();

  public int getLength();

  public boolean isEmpty();

  public boolean isFull();
} 

