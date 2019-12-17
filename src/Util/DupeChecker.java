/*
    DuplicateChecker.java
    by Ryan Koroh,
    RSD2 G8.
*/

package Util;

import Interface.*;

public class DupeChecker<E> implements DupeCheckerInterface<E> {

    @Override
    public boolean hasDupes(List<E> list) {
        // Loop through every item in the list.
        for (int i = 0; i < list.size; i++) {
            // For each item in the list, compare it with every other item.
            for (int j = 0; j < list.size; j++) {
                // Ensure that it isn't the same item that is being compared with itself, before proceeding.
                if (i != j) {
                    // If a matching item (ie. duplicate) is found, then return true.
                    if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                        return true;
                    }
                }
            }
        }
        // If no matching items are found, then return false.
        return false;
    }

    @Override
    public String listDupes(List<E> list) {
        String str = "";                        // For storing the output.
        List<Integer> indexes = new List();     // For storing the indexes of records that have been marked as duplicate.
                                                /* Logical purpose: So that the program doesn't loop through items that have
                                                   already been marked as duplicate. */
        boolean i_has_j = false;                // For flagging whether a duplicate is detected.
        
        // Loop through every item in the list.
        for (int i = 0; i < list.size; i++) {
            // If the item at index 'i' is not flagged, proceed.
            if (!indexes.isExists(i)) {
                // Compare the item at index 'i' with every other item in the list.
                for (int j = 0; j < list.size; j++) {
                    // If the item at index 'j' is not flagged, proceed.
                    if (!indexes.isExists(j)) {
                        // Ensure that it isn't the same item that is being compared with itself, before proceeding.
                        if (i != j) {
                            // If a matching item (ie. duplicate) is found, proceed to execute the following.
                            if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                                // Append the duplicate occurrence to the output string.
                                str += "First occurrence: '" + list.getRecord(i).toString() + "' at Index [" + i + "]\n";
                                str += "Duplicate occurrence: '" + list.getRecord(j).toString() + "' at Index [" + j + "]\n\n";
                                // Mark the item at index 'j' as a duplicate.
                                indexes.add(j);
                                // Flag that the item at index 'j' has been detected to match the item at index 'i'.
                                i_has_j = true;
                            }
                        }
                    }
                }
            }
            // If 'i' matched 'j' in the previous loop, proceed to execute the following.
            if (i_has_j) {
                // Mark the item at index 'i' as a duplicate.
                indexes.add(i);
                // Reset the flag for the next loop.
                i_has_j = false;
            }
        }
        // If the output string is still empty (ie. no duplicate items have been detected), return an execption message.
        if (str.equals("")) {
            str = "There are no duplicates in this list.";
        }
        // If duplicate items have been detected, proceed to return the original output string.
        return str;
    }

    @Override
    public List<E> removeDupes(List<E> list) {
        // Loop through every item in the list.
        for (int i = 0; i < list.size; i++) {
            // For each item in the list, compare it with every other item.
            for (int j = 0; j < list.size; j++) {
                // Ensure that it isn't the same item that is being compared with itself, before proceeding.
                if (i != j) {
                    // If a matching item (ie. duplicate) is found, then remove it.
                    if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                        list.remove(j);
                    } 
                }
            }
        }
        // Return the updated list.
        return list;
    }
    
}
