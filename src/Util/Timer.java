/*
 * 
 * Author: Johann Lee Jia Xuan
 * 
 */
package Util;

public class Timer {
    private long startTime;
    private long endTime;
    
    // Starts timer
    public Timer(){
        startTime = System.nanoTime();
    }
    
    public String stop(){
        endTime = System.nanoTime();
       double res = (double)  (endTime-startTime)/1000000;
        return String.format("%.4f milliseconds", res);
    }
    
    public double getElapsedTimeInMillis(){
        return (double)  (endTime-startTime)/1000000;
    }
}
