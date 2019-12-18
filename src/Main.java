import Interface.*;
import Model.*;
import Util.*;
import java.util.Calendar;

public class Main {

    static AnimeList animeList = new Util.AnimeList();
    static VoiceActorList vaList = new Util.VoiceActorList();
    

    public static void main(String[] args) {
        Main main = new Main();
        main.setData();
        main.showMainMenu();
        //animeList.searchByVoiceActor(vaList);
        
        //System.out.println(animeList.getRecord(0).getGenres());
        // System.out.println(animeList.getRecord(0).getGenres().isExists("romance"));
        
        /* testing DupeChecker (Ryan)
        DupeChecker dc = new DupeChecker();
        System.out.println(dc.hasDupes(animeList));
        System.out.println(dc.listDupes(animeList));
        animeList = (AnimeList) dc.removeDupes(animeList);
        System.out.println(dc.hasDupes(animeList)); */
    }
    
   // Main navigation
     public static void showMainMenu(){
         Display.clear();
         
        // Create the options
       String[] options = {"Search anime", "Test sort", "Close"};
        
       // Show the menu2
        int choice = Display.showMenuChoice("Main Menu", options);
        
        // Add options here
        switch(choice){
            case 1:
                showSearch();
                break;
            case 2:
                sortedList();
            default:
                break;
        }
    }
     
     // JOHANN'S SEARCH ALGORITHM NAVIGATION
     public static void showSearch(){
         System.out.println("SEARCH ITEM (Leave blank to skip each filter)");
         String name = Quick.toTitleCase(Display.promptString("Name").trim());
         String genres =Quick.toTitleCase(Display.promptString("Genres to search (Capitalize first letter) \"EXAMPLE: Romance, Action\"").trim());
         String voiceActor = Quick.toTitleCase(Display.promptString("Voice Actor to search").trim());

         Display.clear();
         System.out.println(animeList.search(name, voiceActor, genres, vaList));
         
         Display.enterKeyToContinue();
         showMainMenu();
     }
//Kelvin's algorithm
    public static void sortedList(){
        
        SortedListInterface<Anime> l1 = new SortedList<Anime>();
        for (int i = 0; i < animeList.size; i++) {
            l1.add(animeList.getRecord(i));
        
        }
        System.out.println("Total Anime: " + l1.getLength());
        System.out.println("\nAnime List(A-Z): ");
        System.out.printf("%-3s %-50s %-50s %-50s\n", "No","Name ", "Cast", "Genres");
        System.out.printf("%-3s %-50s %-50s %-50s\n", "--", "------- ", "------- ", "------- ");
        System.out.println(l1);
        
        Display.enterKeyToContinue();
        showMainMenu();
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
