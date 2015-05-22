package beautifuldonkey.wokhelper.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 4/29/2015.
 */
public class DeckBuilder{

    private static List<Card> deck = new ArrayList();
    private static List<Card> teknesDeck = new ArrayList();
    private static List<Card> hadrossDeck = new ArrayList();
    public static List<Card> buildDeck() { return deck;}

    public static List<Card> buildHouseDeck(String name) {
        List<Card> houseDeck = new ArrayList();

        switch(name){
            case "Hadross":
                houseDeck = hadrossDeck;
                break;
            case"Teknes":
                houseDeck = teknesDeck;
                break;
        }

        return houseDeck;
    }

    //Card(id, house, name, title, type, rank, base, size, dz
    // ,wounds, defense, attack, movement, def1-10, abilities )
    static {
        deck.add(new Card(1, "Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","X","SONIC","BOLT","BOLT","SKULL","1,9,51"));
        deck.add(new Card(2, "Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C"
                ,3,1,6,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","BOLT","SKULL","7,47,48,70,71,72"));
        deck.add(new Card(3, "Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C"
                ,2,1,4,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","BOLT","BOLT","BOLT","BOLT","SKULL","5,40,41"));
        deck.add(new Card(4, "Teknes", "The Zaalak", null, "Specialist", 1,50,2,"C"
                ,1,2,4,8,"SONIC","SONIC","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","SKULL","SKULL","6,42,43,44"));
        deck.add(new Card(5, "Teknes", "Galvanic Defender", null, "Specialist", 1,40,3,"A"
                ,3,1,6,7,"STAR","STAR","STAR","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","BOLT","SKULL","2,3,4,45,46"));
        deck.add(new Card(6, "Teknes", "Defender Lineman Controller", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));

        teknesDeck.add(new Card(1, "Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","X","SONIC","BOLT","BOLT","SKULL","1,9,51"));
        teknesDeck.add(new Card(2, "Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C"
                ,3,1,6,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","BOLT","SKULL","7,47,48,70,71,72"));
        teknesDeck.add(new Card(3, "Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C"
                ,2,1,4,5,"DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","BOLT","BOLT","BOLT","BOLT","SKULL","5,40,41"));
        teknesDeck.add(new Card(4, "Teknes", "The Zaalak", null, "Specialist", 1,50,2,"C"
                ,1,2,4,8,"SONIC","SONIC","DOUGHNUT","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","SKULL","SKULL","6,42,43,44"));
        teknesDeck.add(new Card(5, "Teknes", "Galvanic Defender", null, "Specialist", 1,40,3,"A"
                ,3,1,6,7,"STAR","STAR","STAR","DOUGHNUT","DOUGHNUT","BOLT","BOLT","BOLT","BOLT","SKULL","2,3,4,45,46"));
        teknesDeck.add(new Card(6, "Teknes", "Defender Lineman Controller", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));

        hadrossDeck.add(new Card(7, "Hadross", "Placeholder", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));
        hadrossDeck.add(new Card(8, "Hadross", "Placeholder", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"DOUGHNUT","DOUGHNUT","DOUGHNUT","DOUGHNUT","X","X","SONIC","BOLT","BOLT","SKULL","8,9,49,50,52"));

    }

}
