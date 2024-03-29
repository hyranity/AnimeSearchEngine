/** Utility class by Johann Lee Jia Xuan
 * The purpose of this class is to shorten code in a customized fashion.
 * The functions are already possible in the current version of Java; however, we just want to shorten the code to allow for faster typing.
 * */
package Util;

import java.util.Calendar;

public class Quick {

    public int counter; // This is for loop util methods only

    public Quick() {
        counter = 0;
    }

    // Generates ID based on how many records there are now and with what prefix it should have and how long the ID should be in characters (eg. customer would be C00000001)
    // If it tries to generate an ID, and the new ID precedes the specified ID length, null is returned
    public String generateListId(String prefix, int idLength) {
        
        counter++;

        String id = "" + counter;
        int numberOfZeroes = idLength - prefix.length() - id.length();

        for (int i = 0; i < numberOfZeroes; i++) {
            id = "0" + id;
        }
        
        String newId = prefix+id;
        
        // If the new ID is longer than intended length, return null
        if(newId.length()>idLength){
            counter--;
            return null;
        }

        return prefix + id;
    }

    // Returns a Java Calendar based on the entered date in integers
    public static Calendar getDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        return cal;
    }

    // Formats a String to TitleCase
    public static String toTitleCase(String str) {
        // Check if empty; return null if so
        if(str.isEmpty())
             return null;
        
        boolean hasCommas = false;

        str = str.toLowerCase();

        String[] strArr = null;

        if (str.indexOf(", ") != -1) {
            hasCommas = true;
        }

        if (hasCommas) {
            strArr = str.split(", ");
        } else {
            strArr = str.split(" ");
        }

        // Perform upper case conversion
        String result = "";
        for (int i = 0; i < strArr.length; i++) {
            result += Character.toUpperCase(strArr[i].charAt(0)) + strArr[i].substring(1, strArr[i].length());

            if (i+1 != strArr.length) {
                if (hasCommas) {
                    result += ", ";
                } else {
                    result += " ";
                }
            }
        }

        return result;
    }
    
    //Copies oldArray items to newArray, and returns the newArray
    // Allows copy of arrays
    public static <E> E[] extendArray(E[] oldArray) {
        int count = 0;
        
        E[] newArray = (E[]) new Object[oldArray.length + 5];

        for (E obj : oldArray) {
            // Copy current item into the new array
            newArray[count] = obj;
            count++;
        }

        return newArray;
    }
    

}
