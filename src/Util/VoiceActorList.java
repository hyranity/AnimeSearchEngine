/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.VoiceActor;

/**
 *
 * @author mast3
 */
public class VoiceActorList extends List<VoiceActor>{
    
    public VoiceActor getByActorId(String actorId){
        VoiceActor va = null;
        
        for (int i = 0; i < size; i++) {
            if(this.getRecord(i).getActorId().equalsIgnoreCase(actorId))
                va = this.getRecord(i);
        }
        
       return va;
    }
    
}
