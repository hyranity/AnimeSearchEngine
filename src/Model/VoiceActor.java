/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Util.Quick;
import java.util.*;
/**
 *
 * @author mast3
 */
public class VoiceActor {
    private String actorId;
    private String name;
    private Calendar dateOfBirth;

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

    public VoiceActor(String actorId, String name, Calendar dateOfBirth) {
        this.actorId = actorId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    
    public VoiceActor(){
        
    }
    
   
    
    
}
