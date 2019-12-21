/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Anime;
import Model.VoiceActor;

// This is a List of Anime
public class AnimeList extends List<Anime> {

    public AnimeList() {

    }

    // FILTER ALGORITHM by JOHANN LEE JIA XUAN 
    public AnimeList filterByGenres(String search, AnimeList results) {
        String query = "";

        int indexToBeCut = search.indexOf(',');

        // If only a single genre left
        if (indexToBeCut == -1) {
            query = search;
        } else {
            // Take the first genre out of the search query
            query = search.substring(0, indexToBeCut);

            //Remove the first genre from original query
            search = search.substring(indexToBeCut + 2, search.length());
        }
        // List that is to be filtered
        AnimeList tobeFiltered = new AnimeList();

        // If this is the first search, then search the whole list
        if (results == null) {
            tobeFiltered = this;
            
        } else {
            tobeFiltered = results; // If not first search, set the search domain to the previous results
        }
        // Reset the results list to hold new results only
        results = new AnimeList();
        
        // Go through each one
        for (int i = 0; i < tobeFiltered.size; i++) {

            Anime anime = tobeFiltered.getRecord(i);
            // Adds the anime to the results if found
            if (anime.getGenres().isExists(query)) {
                results.add(anime);
            }
        }
        
        // If there's only 1 remaining genre, no need to perform recursion.
        if (indexToBeCut == -1) {
            return results;
        }

        // Perform recursion
        return filterByGenres(search, results);
    }

    // Filter by Voice Actor name (accessed from outside)
    public AnimeList filterByVoiceActor(String name, List<VoiceActor> vaList) {
        List<VoiceActor> vaResults = new List();

        // Get all voice actors that match the name
        for (int i = 0; i < vaList.size; i++) {
            VoiceActor va = vaList.getRecord(i);

            if (va.getName().contains(name)) {
                vaResults.add(va);
            }
        }

        AnimeList results = new AnimeList();

        // Loop each anime
        animeLoop:
        for (int i = 0; i < this.size; i++) {
            Anime anime = this.getRecord(i);

            // Loop each cast
            castLoop:
            for (int j = 0; j < anime.getCast().size; j++) {
                for (int k = 0; k < vaResults.size; k++) {
                    // Search if any of the voice actors (that previously resulted from the voice actor search) are in the anime
                    VoiceActor va = vaResults.getRecord(k);

                    // If match to any voice actor, break the loop and move on to next anime
                    if (va.equals(anime.getCast().getRecord(j).getVoiceActor())) {
                        results.add(anime);
                        break castLoop;
                    }
                }
            }
        }

        return results;
    }

    public AnimeList filter(String voiceActor, String genres, List<VoiceActor> vaList) {
        boolean hasResults = false;

        // Get all
        AnimeList results = this;

        // Keep filtering
        if (voiceActor != null) {
            results = results.filterByVoiceActor(voiceActor, vaList);
            hasResults = true;
        }
        if (genres != null) {
            results = results.filterByGenres(genres, null);
            hasResults = true;
        }

        if (!hasResults) {
            // return all records
            return this;
        } else {
            return results;
        }
    }

    public String toString() {
        return String.format("%-50s%-50s%-50s\n", "Name ", "Cast", "Genres") + String.format("%-50s%-50s%-50s\n", "------- ", "----------------- ", "----------") + super.toString();
    }
}
