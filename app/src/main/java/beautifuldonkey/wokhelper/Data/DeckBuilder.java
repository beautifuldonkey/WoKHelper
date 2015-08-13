package beautifuldonkey.wokhelper.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * provides a deck for each house & a complete deck
 * Created by Jed on 4/29/2015.
 */
public class DeckBuilder{

    private static List<Card> deck          = new ArrayList<>();
    private static List<Card> teknesDeck    = new ArrayList<>();
    private static List<Card> hadrossDeck   = new ArrayList<>();
    private static List<Card> nasierDeck    = new ArrayList<>();
    private static List<Card> goritsiDeck   = new ArrayList<>();
    private static List<Card> shaelHanDeck  = new ArrayList<>();
    public static List<Card> buildDeck() {
        deck.addAll(teknesDeck);
        deck.addAll(hadrossDeck);
        deck.addAll(nasierDeck);
        deck.addAll(goritsiDeck);
        deck.addAll(shaelHanDeck);
        return deck;
    }

    public static List<Card> buildHouseDeck(String name) {
        List<Card> houseDeck = new ArrayList<>();

        switch(name){
            case "Hadross":
                houseDeck = hadrossDeck;
                break;
            case "Teknes":
                houseDeck = teknesDeck;
                break;
            case "Nasier":
                houseDeck = nasierDeck;
                break;
            case "Goritsi":
                houseDeck = goritsiDeck;
                break;
            case "ShaelHan":
                houseDeck = shaelHanDeck;
                break;
        }

        return houseDeck;
    }

    //Card(id, house, name, title, type, rank, base, size, dz
    // ,wounds, defense, attack, movement, def1-10, abilities )
    static {

        teknesDeck.add(new Card("Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C"
                ,3,1,6,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","BOLT","SKULL","7,47,48,70,71,72"));
        teknesDeck.add(new Card("Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C"
                ,2,1,4,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","BOLT","BOLT","BOLT","BOLT","SKULL","5,40,41"));
        teknesDeck.add(new Card("Teknes", "The Ironward", "Union Member", "Leader Character", 2,40,3,"C"
                ,2,2,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","SONIC","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "The Zaalak", null, "Specialist", 1,50,2,"C"
                ,1,2,4,8,"SONIC","SONIC","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","SKULL","SKULL","6,42,43,44"));
        teknesDeck.add(new Card("Teknes", "Galvanic Defender", null, "Specialist", 1,40,3,"A"
                ,3,1,6,7,"STAR","STAR","STAR","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","BOLT","SKULL","2,3,4,45,46"));
        teknesDeck.add(new Card("Teknes", "C.A.G.E.", null, "Specialist", 2,50,4,"B"
                ,3,2,6,6,"STAR","STAR","DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Defender Lineman Controller", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));
        teknesDeck.add(new Card("Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","X","SONIC","BOLT","BOLT","SKULL","1,9,51"));
        teknesDeck.add(new Card("Teknes", "Defender Raeth Sevisk", "Citizen", "Leader Character", 2,30,2,"B"
                ,3,3,7,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","BOLT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Addanii Brood Warrior", "Addanii", "Infantry", 2,40,1,"B"
                ,3,1,5,7,"ARROW","ARROW","DOUGHNUT","DOUGHNUT","SONIC","BOLT","BOLT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Addanii Brood Masterminds", "Addanii", "Leader", 1,40,1,"B"
                ,3,1,6,7,"ARROW","ARROW","ARROW","SONIC","SONIC","SONIC","BOLT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Timoshkin", "Addanii", "Leader Character", 2,40,1,"B"
                ,5,1,5,7,"SONIC","SONIC","ARROW","ARROW","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Sorik The Unfinished", null, "Specialist Character", 2,40,2,"A"
                ,2,2,6,6,"STAR","STAR","STAR","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "The Mighty Taur", null, "Specialist Character", 2,40,4,"A"
                ,3,2,6,6,"SONIC","SONIC","SONIC","ARROW","ARROW","DOUGHNUT","DOUGHNUT","BOLT","BOLT","SKULL","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Lineman Boris", null, "Specialist Character", 2,40,2,"B"
                ,2,2,6,8,"SONIC","SONIC","SONIC","DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","SKULL","")); //need to add skills

        hadrossDeck.add(new Card("Hadross", "Placeholder", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));
        hadrossDeck.add(new Card("Hadross", "Placeholder", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));

        nasierDeck.add(new Card("Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","X","SONIC","BOLT","BOLT","SKULL","1,9,51"));

        goritsiDeck.add(new Card("Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C"
                ,3,1,6,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","BOLT","SKULL","7,47,48,70,71,72"));

        shaelHanDeck.add(new Card("Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C"
                ,2,1,4,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","BOLT","BOLT","BOLT","BOLT","SKULL","5,40,41"));

    }

}
