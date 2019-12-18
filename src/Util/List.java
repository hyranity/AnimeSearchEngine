package Util;

// The following is a custom implementation of the List class

import Interface.ListInterface;


/* Coding made possible thanks to the following references:
* https://howtodoinjava.com/data-structure/list-implementation-example-in-java/
* https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
 */
public class List<E> implements ListInterface<E> {

    public int size; // Size of list
    protected E[] records;

    // Constructor
    public List() {

        // Default capacity is 10
        records = (E[]) new Object[10];

        // Default size is 0
        size = 0;
    }

    // Parameterized Constructor
    public List(int capacity) {

        // Default capacity is set by the user
        records = (E[]) new Object[capacity];

        // Default size is 0
        size = 0;
    }

    // Getter
    public E getRecord(int index) {
        return records[index];
    }

    // Add record
    public void add(E e) {
        // Add to list
        records[size] = e;

        // Increase size
        size++;
        validateSize();
    }

    // Make sure size is adequate
    public void validateSize() {

        // If current/new size is more than actual array length
        // Note: it is -1 because index starts at 0
        if (size > records.length-1) {
            // Extend
            E[] oldArray = records;
            records = copyArray(oldArray, (E[]) new Object[records.length + 5]);
        }
    }

    // Allows copy of arrays
    public E[] copyArray(E[] oldArray, E[] newArray) {
        int count = 0;

        for (E obj : oldArray) {
            // Copy current element into the new array
            newArray[count] = obj;
            count++;
        }

        return newArray;
    }

    // Removes from list
    public void remove(int index) {

        // remove the current index
        records[index] = null;

        // Shift all content up
        for (int i = index; i < size; i++) {
            // Replace current record with next one
            records[i] = records[i + 1];
            records[i + 1] = null;
        }

        // reduce the size
        size--;
    }

    public String toString() {
        String str = "";
        
        if (size != 0) {
            
            int index = 0;

            for (int i = 0; i < size; i++) {
                str += "\n" + (i+1) + ". " + records[i].toString();
                index++;
            }
            
            
            return str;
        } else {
            return "No record available";
        }
    }
    
    public String toStringWithCommas(){
        String str = "";
        for (int i = 0; i < size; i++) {
            str += getRecord(i);
            if(getRecord(i+1)!= null)
                str +=", ";
        }
        return str;
    
    }
    
   public boolean isExists(E e){
       boolean exists = false;
       int counter = 0;
       // Loops through each element
        while(records[counter] != null){
            if(records[counter].equals(e))
                exists = true;
            
            counter++;
        }
        
       
        return exists;
    }
   

    public int indexOf(E e) {
       //Search
       
       return 0;
    }
    
    
    public void clear(){
        records = (E[]) new Object[10];
    }

    @Override
    public E find(E e) {
        for (int i = 0; i < size; i++) {
            if(e.equals(records[i]))
                return e;
        }
        
        return null;
    }
    
    public E search(E e){
        for (int i = 0; i < size; i++) {
            if(getRecord(i).equals(e))
                return getRecord(i);
                
        }
        
        return null;
    }

}
