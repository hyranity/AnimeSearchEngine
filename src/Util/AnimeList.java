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

    // FILTER ALGORITHM by JOHANN LEE JIA XUAN (Filter by Single Genre)
    public AnimeList searchByGenres(String search) {
        AnimeList results = new AnimeList();

        // If multiple found
        if (search.indexOf(',') != -1) {
            results = searchByGenres(search, null);

        } else {
            // Go through each one
            for (int i = 0; i < this.size; i++) {

                Anime anime = this.getRecord(i);

                // Adds the anime to the results if found
                if (anime.getGenres().isExists(search)) {
                    results.add(anime);
                }
            }
        }
        return results;
    }

    // FILTER ALGORITHM by JOHANN LEE JIA XUAN (Filter by Multiple Genres)
    public AnimeList searchByGenres(String search, AnimeList results) {
        AnimeList finalResults = new AnimeList();

        // If one remaining, go back to original method
        if (search.indexOf(',') == -1) {
            // Only one genre left
            // Go through each one
            for (int i = 0; i < results.size; i++) {

                Anime anime = results.getRecord(i);

                // Adds the anime to the final results if found
                if (anime.getGenres().isExists(search)) {
                    finalResults.add(anime);
                }
            }

            // End search
            return finalResults;
        } else {
            // Take the first genre out of the search query
            int indexToBeCut = search.indexOf(',');
            String query = search.substring(0, indexToBeCut);

            //Remove the first genre from original query
            search = search.substring(indexToBeCut + 2, search.length());

            // Hold temporary results
            AnimeList tempList = new AnimeList();

            // If this is the first search, then search the whole list
            if (results == null) {
                tempList = this;
            } else {
                tempList = results; // If not first search, set the search domain to the previous results
            }
            // Reset the results list to hold new results only
            results = new AnimeList();

            // Go through each one
            for (int i = 0; i < this.size; i++) {

                Anime anime = tempList.getRecord(i);

                // Adds the anime to the results if found
                if (anime.getGenres().isExists(query)) {
                    results.add(anime);
                }
            }
            // Perform recursion
            return searchByGenres(search, results);
        }
    }

    // Filter by Voice Actor name (accessed from outside)
    public AnimeList searchByVoiceActor(String name, VoiceActorList vaList) {
        VoiceActorList vaResults = new VoiceActorList();

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

    public AnimeList searchByName(String name) {
        AnimeList results = new AnimeList();

        // Find the anime with this name
        for (int i = 0; i < this.size; i++) {
            if (this.getRecord(i).getName().contains(name)) {
                results.add(this.getRecord(i));
            }
        }
        
        return results;
    }

    public AnimeList search(String name, String voiceActor, String genres, VoiceActorList vaList) {
        boolean hasResults = false;

        // Get all
        AnimeList results = this;

        // Keep filtering
        if (name != null) {
            results = results.searchByName(name);
            hasResults = true;
        }
        if (voiceActor != null) {
            System.out.println("VA is not null");
            results = results.searchByVoiceActor(voiceActor, vaList);
            hasResults = true;
        }
        if (genres != null) {
            results = results.searchByGenres(genres);
            hasResults = true;
        }

        if (!hasResults) {
            return null;
        } else {
            return results;
        }
    }

    public String toString() {
        return String.format("%-50s%-50s%-50s\n", "Name ", "Cast", "Genres") + String.format("%-50s%-50s%-50s\n", "------- ", "----------------- ", "----------") + super.toString();
    }
}
