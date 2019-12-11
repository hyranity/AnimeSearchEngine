package Model;

import Util.*;
import java.util.Calendar;

public class Studio {
    private String name;
    private String location;
    private Calendar dateFounded;
    private List<Anime> animeList;
    
    // Constructor
    public Studio() {
    }

    public Studio(String name, String location, Calendar dateFounded, List<Anime> animeList) {
        this.name = name;
        this.location = location;
        this.dateFounded = dateFounded;
        this.animeList = animeList;
    }
    
    // Setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(Calendar dateFounded) {
        this.dateFounded = dateFounded;
    }

    public List getAnimeList() {
        return animeList;
    }

    public void setAnimeList(List animeList) {
        this.animeList = animeList;
    }
    
    
    
}
