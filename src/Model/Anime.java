package Model;

import Util.Quick;
import Util.List;
//Author: Johann Lee Jia Xuan
public class Anime implements Comparable<Anime> {

    private String name;
    private List<Character> cast;
    private List<String> genres;

    // Constructor
    public Anime(String name, List<Character> cast, List<String> genres) {
        this.name = name;
        this.cast = cast;
        this.genres = genres;
    }

    public Anime(String name) {
        cast = new List();
        genres = new List();
        this.name = name;
    }

    // Add a cast member
    public void addCast(Character character) {
        cast.add(character);
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Character> getCast() {
        return cast;
    }

    public void setCast(List<Character> cast) {
        this.cast = cast;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String toString() {
        List<VoiceActor> actors = new List();
        for (int i = 0; i < cast.size; i++) {
            actors.add(cast.getRecord(i).getVoiceActor());
        }
        return String.format("%-50s", name) + String.format("%-50s", actors.toStringWithCommas()) + String.format("%-50s", genres.toStringWithCommas());

    }

    public boolean equals(Object other) {
        if (other instanceof Anime) {
            Anime otherName = (Anime) other;
            return (this.name.equals(otherName.name));
        }
        return false;
    }

    @Override
    public int compareTo(Anime t) {
        return this.getName().compareTo(t.getName());
    }
}
