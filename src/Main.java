import Interface.SortedListInterface;
import Interface.*;
import Model.*;
import Util.*;
import java.util.Calendar;

public class Main {

    static Util.List<Anime> animeList = new Util.List();

    public static void main(String[] args) {
        Main main = new Main();
        main.setData();
        main.searchByGenres("Slice of Life");
        main.sortedList();
        //System.out.println(animeList.getRecord(0).getGenres());
        // System.out.println(animeList.getRecord(0).getGenres().isExists("romance"));
    }

    // Sets data
    public void setData() {
        createAnime();
    }

    // SEARCH BY GENRES
    public void searchByGenres(String search) {
        List<Anime> results = new List();
        
        
        // If multiple found
        if (search.indexOf(',') != -1) {
            results = searchByGenres(search, null);
            
        } else {
            // Go through each one
            for (int i = 0; i < animeList.size; i++) {

                Anime anime = animeList.getRecord(i);

                // Adds the anime to the results if found
                if (anime.getGenres().isExists(search)) {
                    results.add(anime);
                }
            }
        }
        System.out.println(results);
    }

    // Utilizes recursion
    public List<Anime> searchByGenres(String search, List<Anime> results) {
        List<Anime> finalResults = new List();
        
        // If one remaining, go back to original method
         if (search.indexOf(',') == -1){
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
         }
         else{
            // Take the first genre out of the search query
            int indexToBeCut = search.indexOf(',');
            String query = search.substring(0, indexToBeCut);
            
            //Remove the first genre from original query
            search = search.substring(indexToBeCut+2, search.length());
            
            // Hold temporary results
            List<Anime> tempList = new List();
            
            // If this is the first search, then search the whole list
            if(results == null)
                tempList = animeList;
            else
                tempList = results; // If not first search, set the search domain to the previous results
            
            // Reset the results list to hold new results only
            results = new List();
            
            // Go through each one
            for (int i = 0; i < animeList.size; i++) {

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

    public void createAnime() {
        // Get voice actors
        List<VoiceActor> vaList = createVoiceActors();

        // Anime : Karakai
        Anime karakai = new Anime("Karakai Jouzu no Takagi-san");
        karakai.addCast(new Model.Character("Takagi", vaList.getRecord(0)));

        karakai.addCast(new Model.Character("Nishikata", vaList.getRecord(1)));

        karakai.getGenres().add("Romance");
        karakai.getGenres().add("School");
        animeList.add(karakai);

        //Anime: anohana
        Anime anohana = new Anime("Anohana");
        anohana.addCast(new Model.Character("Meiko Honma", vaList.getRecord(0)));

        anohana.getGenres().add("Slice of Life");
        anohana.getGenres().add("Drama");
        anohana.getGenres().add("Supernatural");
        animeList.add(anohana);

        //Anime: Attack on Titan
        Anime titan = new Anime("Attack on Titan");
        titan.addCast(new Model.Character("Eren Jaegar", vaList.getRecord(0)));

        titan.addCast(new Model.Character("Mikasa Ackerman", vaList.getRecord(1)));

        titan.getGenres().add("Action");
        titan.getGenres().add("Shounen");
        titan.getGenres().add("Fantasy");
        animeList.add(titan);

        //Anime: Bleach
        Anime bleach = new Anime("Bleach");
        bleach.addCast(new Model.Character("Ichigo Kurosaki", vaList.getRecord(0)));

        bleach.addCast(new Model.Character("Rukia Kuchiki", vaList.getRecord(1)));

        bleach.getGenres().add("Action");
        bleach.getGenres().add("Shounen");
        bleach.getGenres().add("Supernatural");
        animeList.add(bleach);

        //Anime: Heroaca
        Anime heroaca = new Anime("Boku no Hero Academia");
        heroaca.addCast(new Model.Character("Izuku Midoriya", vaList.getRecord(0)));

        heroaca.addCast(new Model.Character("Katsuki Bakugo", vaList.getRecord(1)));

        heroaca.getGenres().add("Action");
        heroaca.getGenres().add("School");
        heroaca.getGenres().add("Shounen");
        animeList.add(heroaca);

        //Anime: codegeass
        Anime codegeass = new Anime("Code Geass");
        codegeass.addCast(new Model.Character("Lelouch Lamperouge", vaList.getRecord(0)));

        codegeass.getGenres().add("Action");
        codegeass.getGenres().add("Military");
        codegeass.getGenres().add("Sci-Fi");
        animeList.add(codegeass);

        //Anime: conan
        Anime conan = new Anime("Detective Conan");
        conan.addCast(new Model.Character("Conan Edogawa", vaList.getRecord(0)));

        conan.addCast(new Model.Character("Shinichi Kudo", vaList.getRecord(1)));

        conan.getGenres().add("Mystery");
        conan.getGenres().add("Shounen");
        conan.getGenres().add("Action");
        animeList.add(conan);

        //Anime: DB
        Anime db = new Anime("Dragon Ball");
        db.addCast(new Model.Character("Goku Son", vaList.getRecord(0)));

        db.addCast(new Model.Character("Krillin", vaList.getRecord(1)));

        db.getGenres().add("Action");
        db.getGenres().add("Shounen");
        db.getGenres().add("Supernatural");
        animeList.add(db);

        //Anime: fairytail
        Anime fairy = new Anime("Fairy Tail");
        fairy.addCast(new Model.Character("Natsu Dragneel", vaList.getRecord(0)));

        fairy.addCast(new Model.Character("Lucy Heartfilia", vaList.getRecord(1)));

        fairy.getGenres().add("Action");
        fairy.getGenres().add("Adventure");
        fairy.getGenres().add("Magic");
        animeList.add(fairy);

        //Anime: FMAB
        Anime fmab = new Anime("Fullmetal Alchemist: Brotherhood");
        fmab.addCast(new Model.Character("Edward Elric", vaList.getRecord(0)));

        fmab.addCast(new Model.Character("Alphonse Elric", vaList.getRecord(1)));

        fmab.getGenres().add("Action");
        fmab.getGenres().add("Shounen");
        fmab.getGenres().add("Military");
        animeList.add(fmab);

        //Anime: fate
        Anime fate = new Anime("Fate/Stay Night");
        fate.addCast(new Model.Character("Saber", vaList.getRecord(0)));
        fate.addCast(new Model.Character("Shiro Emiya", vaList.getRecord(1)));
        fate.addCast(new Model.Character("Rin Toosaka", vaList.getRecord(2)));

        fate.getGenres().add("Supernatural");
        fate.getGenres().add("Fantasy");
        fate.getGenres().add("Magic");
        animeList.add(fate);

        //Anime: Gintama
        Anime gintama = new Anime("Gintama");
        gintama.addCast(new Model.Character("Gintoki Sakata", vaList.getRecord(0)));
        gintama.addCast(new Model.Character("Shinpachi Shimura", vaList.getRecord(1)));
        gintama.addCast(new Model.Character("Kagura", vaList.getRecord(2)));

        gintama.getGenres().add("Comedy");
        gintama.getGenres().add("Historical");
        gintama.getGenres().add("Action");
        animeList.add(gintama);

        //Anime: Inuyasha
        Anime inu = new Anime("Inuyasha");
        inu.addCast(new Model.Character("Inuyasha", vaList.getRecord(0)));
        inu.addCast(new Model.Character("Kagome Higurashi", vaList.getRecord(1)));

        inu.getGenres().add("Adventure");
        inu.getGenres().add("Supernatural");
        inu.getGenres().add("Romance");
        animeList.add(inu);

        //Anime: KnY
        Anime kimetsu = new Anime("Kimetsu no Yaiba");
        kimetsu.addCast(new Model.Character("Tanjiro Kamado", vaList.getRecord(0)));
        kimetsu.addCast(new Model.Character("Nezuko Kamado", vaList.getRecord(1)));

        kimetsu.getGenres().add("Action");
        kimetsu.getGenres().add("Historical");
        kimetsu.getGenres().add("Shounen");
        animeList.add(kimetsu);

        //Anime: kiminonawa
        Anime na = new Anime("Kimi no Na wa");
        na.addCast(new Model.Character("Taki", vaList.getRecord(0)));
        na.addCast(new Model.Character("Mitsuha", vaList.getRecord(0)));

        na.getGenres().add("Supernatural");
        na.getGenres().add("School");
        na.getGenres().add("Romance");
        animeList.add(na);

        //Anime: Magic Kaito
        Anime kaito = new Anime("Magic Kaito 1412");
        kaito.addCast(new Model.Character("Kaito Kuroba", vaList.getRecord(0)));

        kaito.getGenres().add("Adventure");
        kaito.getGenres().add("Comedy");
        kaito.getGenres().add("Shounen");

        animeList.add(kaito);

        //Anime: Melancholy of Haruhi Suzumiya
        Anime haruhi = new Anime("Melancholy of Haruhi Suzumiya");
        haruhi.addCast(new Model.Character("Haruhi Suzumiya", vaList.getRecord(0)));
        haruhi.addCast(new Model.Character("Kyon", vaList.getRecord(1)));

        haruhi.getGenres().add("Comedy");
        haruhi.getGenres().add("Slice of Life");
        haruhi.getGenres().add("School");
        animeList.add(haruhi);

        //Anime: Nanatsu no Taizai
        Anime taizai = new Anime("Nanatsu no Taizai");
        taizai.addCast(new Model.Character("Meliodas", vaList.getRecord(0)));

        taizai.getGenres().add("Action");
        taizai.getGenres().add("Adventure");
        taizai.getGenres().add("Supernatural");

        animeList.add(taizai);

        //Anime: One Piece
        Anime onep = new Anime("One Piece");
        onep.addCast(new Model.Character("Monkey D Luffy", vaList.getRecord(0)));
        onep.addCast(new Model.Character("Zoro Roronoa", vaList.getRecord(1)));

        onep.getGenres().add("Adventure");
        onep.getGenres().add("Shounen");
        onep.getGenres().add("Comedy");

        animeList.add(onep);

        //Anime: SAO
        Anime sao = new Anime("Sword Art Online");
        sao.addCast(new Model.Character("Kazuto Kirigaya", vaList.getRecord(0)));
        sao.addCast(new Model.Character("Asuna Yuuki", vaList.getRecord(1)));

        sao.getGenres().add("Action");
        sao.getGenres().add("Fantasy");
        sao.getGenres().add("Romance");

        animeList.add(sao);

        //Tenki no Ko
        Anime tenki = new Anime("Tenki no Ko");
        tenki.addCast(new Model.Character("Hodaka", vaList.getRecord(0)));
        tenki.addCast(new Model.Character("Hina", vaList.getRecord(1)));

        tenki.getGenres().add("Fantasy");
        tenki.getGenres().add("Slice of Life");
        tenki.getGenres().add("Romance");
        animeList.add(tenki);

        //Anime: Violet Evergarden
        Anime violet = new Anime("Violet Evergarden");
        violet.addCast(new Model.Character("Violet Evergarden", vaList.getRecord(0)));

        violet.getGenres().add("Fantasy");
        violet.getGenres().add("Slice of Life");
        violet.getGenres().add("Drama");

        animeList.add(violet);

        //Anime: kimiuso
        Anime kimiuso = new Anime("Your Lie on April");
        kimiuso.addCast(new Model.Character("Kousei Arima", vaList.getRecord(0)));
        kimiuso.addCast(new Model.Character("Kaori Miyazono", vaList.getRecord(1)));

        kimiuso.getGenres().add("Music");
        kimiuso.getGenres().add("School");
        kimiuso.getGenres().add("Romance");
        animeList.add(kimiuso);

    }

    // Create all voice actors here
    public List<VoiceActor> createVoiceActors() {

        List<VoiceActor> vaList = new List();
        Quick quick = new Quick();
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Rie Takahashi", Quick.getDate(27, 2, 1994)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Yuki Kaji", Quick.getDate(3, 9, 1985)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Ai Kayano", Quick.getDate(13, 9, 1987)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Yui Ishikawa", Quick.getDate(30, 5, 1989)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Masakazu Morita", Quick.getDate(21, 10, 1972)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Fumiko Orikasa", Quick.getDate(27, 12, 1974)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Daiki Yamashita", Quick.getDate(7, 9, 1989)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Nobuhiko Okamoto", Quick.getDate(24, 10, 1986)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Jun Fukuyama", Quick.getDate(26, 11, 1978)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Minami Takayama", Quick.getDate(5, 5, 1964)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Kappei Yamaguchi", Quick.getDate(23, 5, 1965)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Masako Nozawa", Quick.getDate(25, 10, 1936)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Mayumi Tanaka", Quick.getDate(15, 1, 1955)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Tetsuya Kakihara", Quick.getDate(24, 12, 1982)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Aya Hirano", Quick.getDate(8, 10, 1987)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Romi Park", Quick.getDate(22, 1, 1972)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Rie Kugimiya", Quick.getDate(30, 5, 1979)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Ayako Kawasumi", Quick.getDate(30, 3, 1976)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Noriaki Sugiyama", Quick.getDate(9, 3, 1974)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Kana Ueda", Quick.getDate(9, 6, 1980)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Tomokazu Sugita", Quick.getDate(11, 10, 1980)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Daisuke Sakaguchi", Quick.getDate(11, 10, 1973)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Satsuki Yukino", Quick.getDate(25, 5, 1970)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Natsuki Hanae", Quick.getDate(26, 6, 1991)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Akari Kito", Quick.getDate(16, 10, 1994)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Mone Kamishiraishi", Quick.getDate(27, 1, 1998)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Ryuunosuke Kamiki", Quick.getDate(19, 5, 1993)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Kazuya Nakai", Quick.getDate(25, 11, 1967)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Yoshitsugu Matsuoka", Quick.getDate(17, 9, 1986)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Haruka Tomatsu", Quick.getDate(4, 2, 1990)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Kotaro Daigo", Quick.getDate(1, 9, 2000)));
        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Nana Mori", Quick.getDate(31, 8, 2001)));

        vaList.add(new VoiceActor(quick.generateListId("VA", 5), "Risa Taneda", Quick.getDate(12, 7, 1988)));

        return vaList;
    }

    // Johann's algorithm
    public void searchFilter() {

    }
    
    //Kelvin's algorithm
    public void sortedList(){
        
        SortedListInterface<Anime> l1 = new SortedList<Anime>();
        for (int i = 0; i < animeList.size; i++) {
            l1.add(animeList.getRecord(i));
        
        }
        System.out.println("Total Anime: " + l1.getLength());
        System.out.println("\nAnime List(A-Z): ");
        System.out.printf("%-50s%-50s%-50s\n", "Name ", "Cast", "Genres");
        System.out.printf("%-50s%-50s%-50s\n", "------- ", "----------------- ", "----------");
        System.out.println(l1);
    }

}
