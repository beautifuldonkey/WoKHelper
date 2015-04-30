package beautifuldonkey.wokhelper.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 4/29/2015.
 */
public class DeckBuilder {

    private static List<Card> deck = new ArrayList();
    private static List<House> houses = new ArrayList();

    public static List<Card> buildDeck() { return deck;}
    public static List<House> getHouseList() {return houses;}

    static {
        deck.add(new Card(1, "house", "name", "title", "rank", 5));
        deck.add(new Card(2, "house", "name2", "title2", "rank2", 5));

        houses.add(new House("Hadross", "Hadross description"));
        houses.add(new House("Tekness", "Tekness description"));
    }
}
