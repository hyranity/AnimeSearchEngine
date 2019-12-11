/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mast3
 */
public class Character {
    private String name;
    private VoiceActor voiceActor;

    // Constructor
    public Character(String name, VoiceActor voiceActor) {
        this.name = name;
        this.voiceActor = voiceActor;
    }
    
    // Setters & Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VoiceActor getVoiceActor() {
        return voiceActor;
    }

    public void setVoiceActor(VoiceActor voiceActor) {
        this.voiceActor = voiceActor;
    }
    
    
}
