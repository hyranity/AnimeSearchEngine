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
    public void searchByGenres(String search) {
        List<Anime> results = new List();

        // If multiple found
        if (search.indexOf(',') != -1) {
            results = searchByGenres(search, null);

        } else {
            // Go through each one
            for (int i = 0; i < super.size; i++) {

                Anime anime = super.getRecord(i);

                // Adds the anime to the results if found
                if (anime.getGenres().isExists(search)) {
                    results.add(anime);
                }
            }
        }
        System.out.println(results);
    }

    // FILTER ALGORITHM by JOHANN LEE JIA XUAN (Filter by Multiple Genres)
    public List<Anime> searchByGenres(String search, AnimeList results) {
        List<Anime> finalResults = new List();

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
            for (int i = 0; i < super.size; i++) {

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

    // Filter by Voice Actor
    private boolean searchByVoiceActor(VoiceActor va) {
        
        AnimeList results = new AnimeList();

        // Loop each anime
        animeLoop:
        for (int i = 0; i < this.size; i++) {
            Anime anime = this.getRecord(i);

            // Loop each cast
            castLoop:
            for (int j = 0; j < anime.getCast().size; j++) {
                // If match, break the loop and move on to next anime
                if (va.equals(anime.getCast().getRecord(j).getVoiceActor())) {
                    results.add(anime);
                    break castLoop;
                }
            }
        }
        
        System.out.println(results);

        if(results.size==0)
            return false;
        else
            return true;
    }
    
    // Filter by Voice Actor (accessed from outside)
     public boolean searchByVoiceActor(VoiceActorList vaList){
        //Search all voice actors with this name
        String[] voiceActorList = new String[vaList.size];
        
        // Fill in the choices with all voice actors
        for (int i = 0; i < vaList.size; i++) {
            voiceActorList[i] = vaList.getRecord(i).toString();
        }
        
        
        
        int choice = Display.showMenuChoice("Select voice actor", voiceActorList);
        
        if(!searchByVoiceActor(vaList.getRecord(choice-1)))
            return false;
        else
            return true;
    }
     
     public String toString(){
         return String.format("%-50s%-50s%-50s\n", "Name ", "Cast", "Genres") + String.format("%-50s%-50s%-50s\n", "------- ", "----------------- ", "----------") + super.toString();
     }
}
