/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Util.Quick;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * Author: Johann Lee Jia Xuan
 */
public class VoiceActor{
    private String actorId;
    private String name;
    private Calendar dateOfBirth;
    
    // Constructor
    public VoiceActor(String actorId, String name, Calendar dateOfBirth) {
        this.actorId = actorId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    
    public VoiceActor(){
        
    }

    // Setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }
    
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return name;
    }

    @Override
    public boolean equals(Object o){
        VoiceActor toCompare = new VoiceActor();
        //Cast object to voice actor
        if(o instanceof VoiceActor)
            toCompare = (VoiceActor) o;
        else
            return false; // Is not the correct object
        
        if(this.getActorId() == toCompare.actorId)
            return true;
        else
            return false;
    }
    
}
