package Model;

import Util.*;
import java.util.Calendar;

public class Studio {
    private String name;
    private AnimeList animeList;
    
    // Constructor
    public Studio() {
    }

    public Studio(String name, AnimeList animeList) {
        this.name = name;
        this.animeList = animeList;
    }
    
    // Setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getAnimeList() {
        return animeList;
    }

    public void setAnimeList(AnimeList animeList) {
        this.animeList = animeList;
    }
    
    
    
}
