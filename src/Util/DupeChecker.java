// by ryan

package Util;

import Interface.*;

public class DupeChecker<E> implements DupeCheckerInterface<E> {

    @Override
    public boolean hasDupes(List<E> list) {
        for (int i = 0; i < list.size; i++) {
            for (int j = 0; j < list.size; j++) {
                if (i != j) {
                    if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String listDupes(List<E> list) {
        String str = "";
        List<Integer> indexes = new List();
        boolean i_has_j = false;
        
        for (int i = 0; i < list.size; i++) {
            if (!indexes.isExists(i)) {
                for (int j = 0; j < list.size; j++) {
                    if (!indexes.isExists(j)) {
                        if (i != j) {
                            if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                                str += "First occurrence: '" + list.getRecord(i).toString() + "' at Index [" + i + "]\n";
                                str += "Duplicate occurrence: '" + list.getRecord(j).toString() + "' at Index [" + j + "]\n\n";
                                
                                indexes.add(j);
                                i_has_j = true;
                            }
                        }
                    }
                }
            }
            if (i_has_j) {
                indexes.add(i);
                i_has_j = false;
            }
        }
        return str;
    }

    @Override
    public List<E> removeDupes(List<E> list) {
        for (int i = 0; i < list.size; i++) {
            for (int j = 0; j < list.size; j++) {
                if (i != j) {
                    if (list.getRecord(i) == list.getRecord(j) || list.getRecord(i).equals(list.getRecord(j))) {
                        list.remove(j);
                    } 
                }
            }
        }
        return list;
    }
    
}
