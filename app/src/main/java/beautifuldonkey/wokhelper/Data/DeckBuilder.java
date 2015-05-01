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
        deck.add(new Card(1, "Hadross", "name", "title", "rank", 5));
        deck.add(new Card(2, "Teknes", "name2", "title2", "rank2", 5));
    }
}
