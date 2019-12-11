package Model;

import java.util.Calendar;

public abstract class Person {
    private String name;
    private Calendar dateOfBirth;
    
    public Person(){
        
    }
    
    //Setters & Getters

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
    
}
