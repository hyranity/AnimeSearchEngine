package Util;

import Interface.SortedListInterface;
public class SortedList<T extends Comparable<T>> implements SortedListInterface<T> {

  private T[] list; 
  private int length; //Length of list

  
  //Constructor
  public SortedList() {
    length = 0;
    list = (T[]) new Comparable[10];
  }

  //Parameterized Constructor
  public SortedList(int initialCapacity) {
    //Default length is 0
    length = 0;
    list = (T[]) new Comparable[initialCapacity];
  }
  
  @Override
  public boolean add(T newEntry) {
    int i = 0;
    if(isArrayFull()){
        doubleArray();
        i = 0;
    }
    while (i < length && newEntry.compareTo(list[i]) > 0) {
      i++;
    }
    makeRoom(i + 1);
    list[i] = newEntry;
    length++;
    return true;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = list[givenPosition - 1];
      if (givenPosition < length) {
        removeGap(givenPosition);
      }
      length--;
    }

    return result;
  }
  
  @Override
  public void clear() {
    length = 0;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = list[givenPosition];

    return result;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(list[index])) {
        found = true;
      }
    }

    return found;
  }

  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    return length == 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += (index+1) + ". " + list[index] + "\n";
    }

    return outputStr;
  }

  //Extend the array
  private boolean isArrayFull() {
    return length == list.length;
  }

  private void doubleArray() {
    T[] oldList = list;
    int oldSize = oldList.length;

    list = (T[]) new Comparable[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      list[index] = oldList[index];
    }
  }

  //Give new position when there a new entry
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      list[index + 1] = list[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      list[index] = list[index + 1];
    }
  }
  
  //Swap index for selection sort
  public void swap(int firstIndex, int secondIndex){
      // The current position{1,2}
      // Get first Index : 1 
     T temp = this.getEntry(firstIndex);
      
     // {2.2} Putt second index into first index
     this.set(list[secondIndex], firstIndex);
     
     // {2,1} Put Temp:1 which is first index then put to second index
     this.set(temp, secondIndex);
  }
  
  //Save the data
  public void set(T t, int index){
      this.list[index] = t;
  }
  
}

