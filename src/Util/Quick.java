/**
 * The purpose of this class is to shorten code in a customized fashion.
 * The functions are already possible in the current version of Java; however, we just want to shorten the code to allow for faster typing.
 **/
package Util;

import java.util.Calendar;

public class Quick {
    public int counter; // This is for loop util methods only
    
    public Quick(){
        counter = 0;
    }
    
    
    public static void print(String str){
        System.out.println(str);
    }
    /*
    description: Prints a string; Shorter to type than System.out.println()
    precondition: none
    postcondition: none
    return: none
    */
    
    public static String toPrice(String currency, double price){
        return String.format(currency + "%.2f", price);
    }
    /*
    description: Formats double into a price string
    precondition: none
    postcondition: none
    return: String
    */
    
    public static String generateId(String prefix, int size, int idLength){
         size++;
        
        String id = "" + size;
         int numberOfZeroes = idLength-prefix.length() - id.length();
         
        for(int i=0;i<numberOfZeroes;i++){
            id = "0" + id;
        }
        
        return prefix + id;
    }
    /*
    description: Generates ID based on how many records there are now and with what prefix it should have and how long the ID should be in characters (eg. customer would be C00000001)
    precondition: none
    postcondition: none
    return: String
    */
    
    // Note: The following method works similarly to the above one, but autogenerates ID based on counter
    public  String generateListId(String prefix, int idLength){
         counter++;
        
        String id = "" + counter;
         int numberOfZeroes = idLength-prefix.length() - id.length();
         
        for(int i=0;i<numberOfZeroes;i++){
            id = "0" + id;
        }
        
        return prefix + id;
    }
    
    public static Calendar getDate(int day, int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        
        return cal;
    }
}
