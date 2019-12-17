// by ryan

package Interface;

import Util.*;

public interface DupeCheckerInterface<E> {
    boolean hasDupes(List<E> list);
    String listDupes(List<E> list);
    List<E> removeDupes(List<E> list);
}
