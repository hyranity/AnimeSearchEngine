import Interface.*;
import Model.*;
import Util.*;
import java.util.Calendar;

// This Class is to test the code.

public class Testing {

    static AnimeList animeList = new Util.AnimeList();
    static List<VoiceActor> vaList = new Util.List();
    

    public static void main(String[] args) {
        Testing test = new Testing();
        test.setData();
        
        testFilter();
        testDupeChecker();
        testSearchAnime();
        testSortedList();
        testSelectionSort();
    }
    
    public static void testFilter(){
        System.out.println("TESTING: FILTER ALGORITHM\n");
        double[] times = new double[10];
        
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            
            // Main testing
            animeList.filter("a", "Romance, Action", vaList);
            
            String time = timer.stop();
            times[i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i+1) + " finished in " + time);
        }
        
        // calculate average
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += times[i];
        }
        
        System.out.println("Average execution time: " + sum/10 + " milliseconds.\n\n");
    }
    
    public static void testDupeChecker() {
        System.out.println("TESTING: DUPLICATE CHECKER ALGORITHM\n");
        double[][] times = new double[4][10];
        
        // Testing function 1: hasDupes()
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            DupeChecker checker = new DupeChecker();
            checker.hasDupes(animeList);
            String time = timer.stop();
            times[0][i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i + 1) + " for hasDupes() finished in " + time);
        }
        System.out.println("\n");
        // Testing function 2: hasDupesBinarySearch()
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            DupeChecker checker = new DupeChecker();
            checker.hasDupesBinarySearch(animeList);
            String time = timer.stop();
            times[1][i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i + 1) + " for hasDupesBinarySearch() finished in " + time);
        }
        System.out.println("\n");
        // Testing function 3: listDupes()
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            DupeChecker checker = new DupeChecker();
            checker.listDupes(animeList);
            String time = timer.stop();
            times[2][i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i + 1) + " for listDupes() finished in " + time);
        }
        System.out.println("\n");
        // Testing function 4: removeDupes()
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            DupeChecker checker = new DupeChecker();
            checker.removeDupes(animeList);
            String time = timer.stop();
            times[3][i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i + 1) + " for removeDupes() finished in " + time);
        }
        
        // Average results
        double[] sums = new double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                sums[i] += times[i][j];
            }
        }
        
        // Display results
        System.out.println("Average exeuction time for hasDupes(): " + sums[0] + " milliseconds.");
        System.out.println("Average exeuction time for hasDupesBinarySearch(): " + sums[1] + " milliseconds.");
        System.out.println("Average exeuction time for listDupes(): " + sums[2] + " milliseconds.");
        System.out.println("Average exeuction time for removeDupes(): " + sums[3] + " milliseconds.\n\n");
    }
     
    public static void testSearchAnime(){

         System.out.println("TESTING: BINARY SEARCH TREE ALGORITHM\n");
         double [] times = new double [10];

         BinaryTree<Anime> tree = new BinaryTree();

         for (int i = 0; i < 10; i++) {
             Timer timer = new Timer(); // start timer
             tree.insert(animeList.getRecord(i));
             
            String time = timer.stop();
            times[i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i+1) + " finished in " + time);   
         }

         double sum = 0;
         for (int i = 0; i < 10; i++) {
            sum += times[i];
        }
         System.out.println("Average execution time: " + sum/10 + " milliseconds");
     }
     
    //KELVIN'S SORT LIST ALGORITHM
    public static void testSortedList(){
        System.out.println("TESTING: SORTING ALGORITHM\n");
        double[] times = new double[10];
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();     
            SortedList sort = new SortedList();
            for (int j = 0; j < animeList.size; j++) {
                sort.add(animeList.getRecord(i));
            }
            String time = timer.stop();
            times[i] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (i + 1) + " for sortedList() finished in " + time);
        }
        // calculate average
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += times[i];
        }
        System.out.println("Average execution time: " + sum/10 + " milliseconds.\n\n");
    }
    
    //KELVIN'S SELECTION SORT ALGORITHM
    public static void testSelectionSort(){
        System.out.println("TESTING: SELECTION SORT ALGORITHM\n");
        double[] times = new double[10];
        // Testing selection sort function
        for (int k = 0; k < 10; k++) {
            // Start timer
            Timer timer = new Timer();
            SortedList<Anime> arr = new SortedList();
            for (int i = 0; i < animeList.size; i++) {
                arr.add(animeList.getRecord(i));
            }
            for (int i = 0; i < arr.getLength()-1; i++) {
                int smallestNumber = i;

                for (int j = i+1; j < arr.getLength(); j++) {
                    if(arr.getEntry(smallestNumber).compareTo(arr.getEntry(j))>0)
                        smallestNumber = j;
                }
               arr.swap(i, smallestNumber);
            }
            //end time
            String time = timer.stop();
            times[k] = timer.getElapsedTimeInMillis();
            System.out.println("Round " + (k + 1) + " for selectionSort() finished in " + time);
        }
        // calculate average
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += times[i];
        }
        
        System.out.println("Average execution time: " + sum/10 + " milliseconds.\n\n");
    }
    
    // Sets data
    public void setData() {
        createAnime();
    }

    public void createAnime() {

        createVoiceActors();
        // Anime : Karakai
        Anime karakai = new Anime("Karakai Jouzu no Takagi-san");
        karakai.addCast(new Model.Character("Takagi", vaList.getRecord(0)));

        karakai.addCast(new Model.Character("Nishikata", vaList.getRecord(1)));

        karakai.getGenres().add("Romance");
        karakai.getGenres().add("School");
        animeList.add(karakai);

        //Anime: anohana
        Anime anohana = new Anime("Anohana");
        anohana.addCast(new Model.Character("Meiko Honma", vaList.getRecord(2)));

        anohana.getGenres().add("Slice of Life");
        anohana.getGenres().add("Drama");
        anohana.getGenres().add("Supernatural");
        animeList.add(anohana);

        //Anime: Attack on Titan
        Anime titan = new Anime("Attack on Titan");
        titan.addCast(new Model.Character("Eren Jaegar", vaList.getRecord(1)));

        titan.addCast(new Model.Character("Mikasa Ackerman", vaList.getRecord(3)));

        titan.getGenres().add("Action");
        titan.getGenres().add("Shounen");
        titan.getGenres().add("Fantasy");
        animeList.add(titan);

        //Anime: Bleach
        Anime bleach = new Anime("Bleach");
        bleach.addCast(new Model.Character("Ichigo Kurosaki", vaList.getRecord(4)));

        bleach.addCast(new Model.Character("Rukia Kuchiki", vaList.getRecord(5)));

        bleach.getGenres().add("Action");
        bleach.getGenres().add("Shounen");
        bleach.getGenres().add("Supernatural");
        animeList.add(bleach);

        //Anime: Heroaca
        Anime heroaca = new Anime("Boku no Hero Academia");
        heroaca.addCast(new Model.Character("Izuku Midoriya", vaList.getRecord(6)));

        heroaca.addCast(new Model.Character("Katsuki Bakugo", vaList.getRecord(7)));

        heroaca.getGenres().add("Action");
        heroaca.getGenres().add("School");
        heroaca.getGenres().add("Shounen");
        animeList.add(heroaca);

        //Anime: codegeass
        Anime codegeass = new Anime("Code Geass");
        codegeass.addCast(new Model.Character("Lelouch Lamperouge", vaList.getRecord(8)));

        codegeass.getGenres().add("Action");
        codegeass.getGenres().add("Military");
        codegeass.getGenres().add("Sci-Fi");
        animeList.add(codegeass);

        //Anime: conan
        Anime conan = new Anime("Detective Conan");
        conan.addCast(new Model.Character("Conan Edogawa", vaList.getRecord(9)));

        conan.addCast(new Model.Character("Shinichi Kudo", vaList.getRecord(10)));

        conan.getGenres().add("Mystery");
        conan.getGenres().add("Shounen");
        conan.getGenres().add("Action");
        animeList.add(conan);

        //Anime: DB
        Anime db = new Anime("Dragon Ball");
        db.addCast(new Model.Character("Goku Son", vaList.getRecord(11)));

        db.addCast(new Model.Character("Krillin", vaList.getRecord(12)));

        db.getGenres().add("Action");
        db.getGenres().add("Shounen");
        db.getGenres().add("Supernatural");
        animeList.add(db);

        //Anime: fairytail
        Anime fairy = new Anime("Fairy Tail");
        fairy.addCast(new Model.Character("Natsu Dragneel", vaList.getRecord(13)));

        fairy.addCast(new Model.Character("Lucy Heartfilia", vaList.getRecord(14)));

        fairy.getGenres().add("Action");
        fairy.getGenres().add("Adventure");
        fairy.getGenres().add("Magic");
        animeList.add(fairy);

        //Anime: FMAB
        Anime fmab = new Anime("Fullmetal Alchemist: Brotherhood");
        fmab.addCast(new Model.Character("Edward Elric", vaList.getRecord(15)));

        fmab.addCast(new Model.Character("Alphonse Elric", vaList.getRecord(16)));

        fmab.getGenres().add("Action");
        fmab.getGenres().add("Shounen");
        fmab.getGenres().add("Military");
        animeList.add(fmab);

        //Anime: fate
        Anime fate = new Anime("Fate/Stay Night");
        fate.addCast(new Model.Character("Saber", vaList.getRecord(17)));
        fate.addCast(new Model.Character("Shiro Emiya", vaList.getRecord(18)));
        fate.addCast(new Model.Character("Rin Toosaka", vaList.getRecord(19)));

        fate.getGenres().add("Supernatural");
        fate.getGenres().add("Fantasy");
        fate.getGenres().add("Magic");
        animeList.add(fate);

        //Anime: Gintama
        Anime gintama = new Anime("Gintama");
        gintama.addCast(new Model.Character("Gintoki Sakata", vaList.getRecord(20)));
        gintama.addCast(new Model.Character("Shinpachi Shimura", vaList.getRecord(21)));
        gintama.addCast(new Model.Character("Kagura", vaList.getRecord(16)));

        gintama.getGenres().add("Comedy");
        gintama.getGenres().add("Historical");
        gintama.getGenres().add("Action");
        animeList.add(gintama);

        //Anime: Inuyasha
        Anime inu = new Anime("Inuyasha");
        inu.addCast(new Model.Character("Inuyasha", vaList.getRecord(10)));
        inu.addCast(new Model.Character("Kagome Higurashi", vaList.getRecord(22)));

        inu.getGenres().add("Adventure");
        inu.getGenres().add("Supernatural");
        inu.getGenres().add("Romance");
        animeList.add(inu);

        //Anime: KnY
        Anime kimetsu = new Anime("Kimetsu no Yaiba");
        kimetsu.addCast(new Model.Character("Tanjiro Kamado", vaList.getRecord(23)));
        kimetsu.addCast(new Model.Character("Nezuko Kamado", vaList.getRecord(24)));

        kimetsu.getGenres().add("Action");
        kimetsu.getGenres().add("Historical");
        kimetsu.getGenres().add("Shounen");
        animeList.add(kimetsu);

        //Anime: kiminonawa
        Anime na = new Anime("Kimi no Na wa");
        na.addCast(new Model.Character("Taki", vaList.getRecord(26)));
        na.addCast(new Model.Character("Mitsuha", vaList.getRecord(25)));

        na.getGenres().add("Supernatural");
        na.getGenres().add("School");
        na.getGenres().add("Romance");
        animeList.add(na);
        
        //Anime: Maid-sama
        Anime maid = new Anime("Kaichou wa Maid Sama");
        maid.addCast(new Model.Character("Usui", vaList.getRecord(7)));
        
        maid.getGenres().add("School");
        maid.getGenres().add("Romance");
        maid.getGenres().add("Comedy");
        animeList.add(maid);

        //Anime: Magic Kaito
        Anime kaito = new Anime("Magic Kaito 1412");
        kaito.addCast(new Model.Character("Kaito Kuroba", vaList.getRecord(10)));

        kaito.getGenres().add("Adventure");
        kaito.getGenres().add("Comedy");
        kaito.getGenres().add("Shounen");

        animeList.add(kaito);

        //Anime: Melancholy of Haruhi Suzumiya
        Anime haruhi = new Anime("Melancholy of Haruhi Suzumiya");
        haruhi.addCast(new Model.Character("Haruhi Suzumiya", vaList.getRecord(14)));
        haruhi.addCast(new Model.Character("Kyon", vaList.getRecord(20)));

        haruhi.getGenres().add("Comedy");
        haruhi.getGenres().add("Slice of Life");
        haruhi.getGenres().add("School");
        animeList.add(haruhi);

        //Anime: Nanatsu no Taizai
        Anime taizai = new Anime("Nanatsu no Taizai");
        taizai.addCast(new Model.Character("Meliodas", vaList.getRecord(1)));
        taizai.addCast(new Model.Character("Escanor", vaList.getRecord(20)));

        taizai.getGenres().add("Action");
        taizai.getGenres().add("Adventure");
        taizai.getGenres().add("Supernatural");

        animeList.add(taizai);

        //Anime: One Piece
        Anime onep = new Anime("One Piece");
        onep.addCast(new Model.Character("Monkey D Luffy", vaList.getRecord(12)));
        onep.addCast(new Model.Character("Zoro Roronoa", vaList.getRecord(27)));

        onep.getGenres().add("Adventure");
        onep.getGenres().add("Shounen");
        onep.getGenres().add("Comedy");

        animeList.add(onep);

        //Anime: SAO
        Anime sao = new Anime("Sword Art Online");
        sao.addCast(new Model.Character("Kazuto Kirigaya", vaList.getRecord(28)));
        sao.addCast(new Model.Character("Asuna Yuuki", vaList.getRecord(29)));

        sao.getGenres().add("Action");
        sao.getGenres().add("Fantasy");
        sao.getGenres().add("Romance");

        animeList.add(sao);
        
        //Anime: Soma
        Anime soma = new Anime("Shokugeki no Soma");
        soma.addCast(new Model.Character("Soma Yukihira", vaList.getRecord(28)));
        soma.addCast(new Model.Character("Takumi Aldini", vaList.getRecord(23)));

        soma.getGenres().add("Drama");
        soma.getGenres().add("Romance");

        animeList.add(soma);

        //Tenki no Ko
        Anime tenki = new Anime("Tenki no Ko");
        tenki.addCast(new Model.Character("Hodaka", vaList.getRecord(30)));
        tenki.addCast(new Model.Character("Hina", vaList.getRecord(31)));

        tenki.getGenres().add("Fantasy");
        tenki.getGenres().add("Slice of Life");
        tenki.getGenres().add("Romance");
        animeList.add(tenki);

        //Anime: Violet Evergarden
        Anime violet = new Anime("Violet Evergarden");
        violet.addCast(new Model.Character("Violet Evergarden", vaList.getRecord(3)));

        violet.getGenres().add("Fantasy");
        violet.getGenres().add("Slice of Life");
        violet.getGenres().add("Drama");

        animeList.add(violet);

        //Anime: kimiuso
        Anime kimiuso = new Anime("Your Lie on April");
        kimiuso.addCast(new Model.Character("Kousei Arima", vaList.getRecord(23)));
        kimiuso.addCast(new Model.Character("Kaori Miyazono", vaList.getRecord(32)));

        kimiuso.getGenres().add("Music");
        kimiuso.getGenres().add("School");
        kimiuso.getGenres().add("Romance");
        animeList.add(kimiuso);

    }

    // Create all voice actors here
    public void createVoiceActors() {

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

    }

}
