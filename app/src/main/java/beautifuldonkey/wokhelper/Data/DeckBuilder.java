package beautifuldonkey.wokhelper.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 4/29/2015.
 */
public class DeckBuilder {

    private static List<Card> deck = new ArrayList();
    public static List<Card> buildDeck() { return deck;}

    static {

        //Card(id, house, name, title, type, rank, base, size, dz)
        deck.add(new Card(1, "Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B",1));
        deck.add(new Card(2, "Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C",3));
        deck.add(new Card(3, "Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C",2));
        deck.add(new Card(4, "Teknes", "The Zaalak", null, "Specialist", 1,50,2,"C",1));
        deck.add(new Card(5, "Teknes", "Galvanic Defender", null, "Specialist", 1,40,3,"A",3));
        deck.add(new Card(5, "Teknes", "Defender Lineman Controller", "Citizen", "Leader", 1,30,2,"B",3));

    }
}
