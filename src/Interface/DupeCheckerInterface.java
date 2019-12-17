/*
    DuplicateCheckerInterface.java
    by Ryan Koroh,
    RSD2 G8.
*/

package Interface;

import Util.*;

public interface DupeCheckerInterface<E> {
    boolean hasDupes(List<E> list);
    /*
    description: Returns a boolean value indicating whether a given list contains duplicates.
    precondition: The list must not be null.
    postcondition: None.
    return: A boolean value: 'true' if the list contains duplicates; 'false' if the list doesn't contain duplicates.
    */
    String listDupes(List<E> list);
    /*
    description: Returns a string that lists all occurrences of duplicates in a given list.
    precondition: The list must not be null;
    postcondition: None.
    return: An output string.
    */
    List<E> removeDupes(List<E> list);
    /*
    description: Removes all duplicate items in a given list, and returns a modified list.
    precondition: The list must not be null.
    postcondition: If the list contained duplicate items, then the list's size is now smaller and all duplicate items have been removed.
    return: A modified List of E.
    */
}
