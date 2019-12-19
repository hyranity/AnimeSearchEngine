/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
