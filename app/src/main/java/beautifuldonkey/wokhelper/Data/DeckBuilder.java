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

    public static List<Card> buildArmyDeck(String houseName, String unitName){
        String [] unitList = unitName.split(",");
        List<Card> currentHouseDeck = buildHouseDeck(houseName);
        List<Card> armyUnits = new ArrayList<>();
        for(int i=0; i<unitList.length; i++){
            for(int j=0; j<currentHouseDeck.size(); j++){
                if(unitList[i].equals(currentHouseDeck.get(j).getName())){
                    armyUnits.add(currentHouseDeck.get(j));
                }
            }
        }
        return armyUnits;
    }

    //Card(id, house, name, title, type, rank, base, size, dz
    // ,wounds, defense, attack, movement, def1-10, abilities )
    static {

        teknesDeck.add(new Card("Teknes", "Union Boss", "Union Member", "Leader", 1,40,3,"C"
                ,3,1,6,5,"ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","PARRY","STRIKE","STRIKE","STRIKE","OVERPOWER","7,47,48,70,71,72"));
        teknesDeck.add(new Card("Teknes", "Union Worker", "Union Member", "Infantry", 1,30,2,"C"
                ,2,1,4,5,"ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","5,40,41"));
        teknesDeck.add(new Card("Teknes", "The Ironward", "Union Member", "Leader Character", 2,40,3,"C"
                ,2,2,6,6,"ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","PARRY","PARRY","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "The Zaalak", null, "Specialist", 1,50,2,"C"
                ,1,2,4,8,"PARRY","PARRY","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","OVERPOWER","6,42,43,44"));
        teknesDeck.add(new Card("Teknes", "Galvanic Defender", null, "Specialist", 1,40,3,"A"
                ,3,1,6,7,"MAGIC","MAGIC","MAGIC","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","2,3,4,45,46"));
        teknesDeck.add(new Card("Teknes", "C.A.G.E.", null, "Specialist", 2,50,4,"B"
                ,3,2,6,6,"MAGIC","MAGIC","ARMOR","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Defender Lineman Controller", "Citizen", "Leader", 1,30,2,"B"
                ,3,1,6,6,"ARMOR","ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","PARRY","STRIKE","STRIKE","OVERPOWER","8,9,49,50,52"));
        teknesDeck.add(new Card("Teknes", "Defender Lineman", "Citizen", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","BLOCK","PARRY","STRIKE","STRIKE","OVERPOWER","1,9,51"));
        teknesDeck.add(new Card("Teknes", "Defender Raeth Sevisk", "Citizen", "Leader Character", 2,30,2,"B"
                ,3,3,7,6,"ARMOR","ARMOR","ARMOR","ARMOR","BLOCK","BLOCK","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Addanii Brood Warrior", "Addanii", "Infantry", 2,40,1,"B"
                ,3,1,5,7,"DODGE","DODGE","ARMOR","ARMOR","PARRY","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Addanii Brood Masterminds", "Addanii", "Leader", 1,40,1,"B"
                ,3,1,6,7,"DODGE","DODGE","DODGE","PARRY","PARRY","PARRY","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Timoshkin", "Addanii", "Leader Character", 2,40,1,"B"
                ,5,1,5,7,"PARRY","PARRY","DODGE","DODGE","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Sorik The Unfinished", null, "Specialist Character", 2,40,2,"A"
                ,2,2,6,6,"MAGIC","MAGIC","MAGIC","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "The Mighty Taur", null, "Specialist Character", 2,40,4,"A"
                ,3,2,6,6,"PARRY","PARRY","PARRY","DODGE","DODGE","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        teknesDeck.add(new Card("Teknes", "Lineman Boris", null, "Specialist Character", 2,40,2,"B"
                ,2,2,6,8,"PARRY","PARRY","PARRY","ARMOR","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills


        hadrossDeck.add(new Card("Hadross", "Deepman Gaurdian", "Deepman", "Infantry", 1,30,2,"A"
                ,1,1,6,5,"MAGIC","MAGIC","BLOCK","BLOCK","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Deepman Kaxes", "Deepman", "Leader", 1,40,3,"A"
                ,3,1,6,5,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Torvosh The Bannerman", "Deepman", "Leader Character", 2,30,2,"A"
                ,2,2,7,5,"MAGIC","MAGIC","MAGIC","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Sevirdan Gutter", "Sevirdan", "Infantry", 2,30,2,"B"
                ,1,2,6,6,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Gutter Friar", "Sevirdan", "Leader", 1,40,2,"B"
                ,2,2,6,6,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Ooroth of Sysor Deep", "Sevirdan", "Leader Character", 2,30,2,"B"
                ,2,2,6,6,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Sevirdan Frenzy", "Carcharian", "Infantry", 2,40,3,"B"
                ,2,1,5,5,"MAGIC","MAGIC","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","STRIKE","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Frenzy Charger", "Carcharian", "Leader", 1,40,3,"B"
                ,3,1,5,7,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Gar The Gladiator", "Carcharian", "Leader Character", 2,40,3,"B"
                ,2,2,6,6,"MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Deep Caller", null, "Specialist", 1,30,2,"A"
                ,3,1,7,5,"MAGIC","MAGIC","MAGIC","MAGIC","BLOCK","BLOCK","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Calith Reaver", null, "Specialist", 1,50,4,"B"
                ,2,2,5,6,"ARMOR","ARMOR","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Orsund Cavalier", null, "Specialist", 2,80,5,"B"
                ,3,2,6,6,"MAGIC","MAGIC","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "The Oracle of Ulloth", null, "Specialist Character", 2,30,2,"A"
                ,2,2,7,6,"MAGIC","MAGIC","MAGIC","BLOCK","BLOCK","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Ephramatti - the Deepcaller Lord", null, "Specialist Character", 2,30,2,"A"
                ,2,2,7,5,"MAGIC","MAGIC","MAGIC","MAGIC","MAGIC","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        hadrossDeck.add(new Card("Hadross", "Ilva - the Syran of Kaldeth Strait", null, "Specialist Character", 2,30,2,"A"
                ,2,2,7,6,"MAGIC","MAGIC","MAGIC","MAGIC","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills


        nasierDeck.add(new Card("Nasier", "Ashmen Swordsman", "Ashmen", "Infantry", 1,30,2,"B"
                ,1,1,5,7,"PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Ashmen Hakar", "Ashmen", "Leader", 1,30,2,"B"
                ,3,1,6,7,"PARRY","PARRY","PARRY","DODGE","DODGE","BLOCK","BLOCK","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Alayna Heska", "Ashmen", "Leader Character", 2,30,2,"B"
                ,2,2,6,7,"PARRY","PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Pelegarth Bloodmask", "Pelegarth", "Infantry", 1,30,2,"C"
                ,1,1,5,6,"PARRY","BLOCK","BLOCK","BLOCK","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Pelegarth Howl", "Pelegarth", "Leader", 1,30,2,"C"
                ,3,1,6,6,"PARRY","BLOCK","BLOCK","BLOCK","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Elsis Tagil - The Wail of War", "Pelegarth", "Leader Character", 2,30,2,"C"
                ,2,2,6,6,"PARRY","PARRY","PARRY","BLOCK","BLOCK","BLOCK","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Longhorn", null, "Specialist", 1,40,3,"C"
                ,3,1,5,7,"PARRY","PARRY","PARRY","BLOCK","BLOCK","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Rathor", null, "Specialist", 1,50,3,"B"
                ,3,1,6,6,"MAGIC","MAGIC","MAGIC","BLOCK","BLOCK","BLOCK","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Greathorn", null, "Specialist", 2,80,5,"B"
                ,3,2,6,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","PARRY","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "The Bloodchild", null, "Specialist Character", 2,50,3,"B"
                ,2,2,7,8,"MAGIC","MAGIC","PARRY","PARRY","BLOCK","BLOCK","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "Shadrus Arikim", null, "Specialist Character", 2,40,3,"B"
                ,5,1,6,7,"PARRY","PARRY","PARRY","DODGE","DODGE","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","")); //need to add skills
        nasierDeck.add(new Card("Nasier", "The Blind Hakar", null, "Specialist Character", 2,40,2,"C"
                ,2,2,7,7,"PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills


        goritsiDeck.add(new Card("Goritsi", "War Dancer", "Zeti", "Infantry", 1,30,2,"C"
                ,1,1,5,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Dancing Master", "Zeti", "Leader", 1,30,2,"C"
                ,3,1,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Hestra Nostrollo", "Zeti", "Leader Character", 1,30,2,"C"
                ,2,2,6,7,"MAGIC","MAGIC","MAGIC","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Skorza Skirmisher", "Skorza", "Infantry", 2,40,3,"B"
                ,2,1,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Skorza Alpha", "Skorza", "Leader", 1,50,3,"B"
                ,3,1,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Korrad Ungarash", "Skorza", "Leader Character", 2,50,3,"B"
                ,2,2,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Ravenscar Mercenary", "Ravenscar", "Infantry", 1,30,2,"C"
                ,1,1,5,6,"PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Ravenscar Sergeant", "Ravenscar", "Leader", 1,30,2,"C"
                ,3,1,6,6,"PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Lord Hob", "Ravenscar", "Leader Character", 2,30,2,"C"
                ,3,2,6,6,"PARRY","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Shield Breaker", null, "Specialist", 1,50,3,"B"
                ,3,1,6,6,"MAGIC","MAGIC","ARMOR","ARMOR","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Scourge Hound", null, "Specialist", 1,40,3,"B"
                ,2,1,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Blood Engine", null, "Specialist", 2,80,5,"B"
                ,6,1,5,6,"MAGIC","MAGIC","MAGIC","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Gregorio don Sissora", null, "Specialist Character", 2,40,3,"B"
                ,2,2,6,8,"MAGIC","MAGIC","PARRY","PARRY","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "The Dragonslayer", null, "Specialist Character", 2,30,2,"*"
                ,2,2,6,7,"PARRY","PARRY","PARRY","DODGE","DODGE","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        goritsiDeck.add(new Card("Goritsi", "Duke Anton don Genoria", null, "Specialist Character", 2,50,3,"B"
                ,6,1,6,6,"MAGIC","MAGIC","PARRY","DODGE","DODGE","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills


        shaelHanDeck.add(new Card("ShaelHan", "Dragon Legionnaire", "Dragon Gaurd", "Infantry", 1,30,2,"B"
                ,1,1,5,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Dragon Legion Keeper", "Dragon Gaurd", "Leader", 1,30,2,"B"
                ,3,1,6,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "The Winterhawk", "Dragon Gaurd", "Leader Character", 2,30,2,"B"
                ,5,1,7,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","PARRY","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "The Wrath", "The Children", "Infantry", 2,40,3,"C"
                ,2,1,6,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Big Sister", "The Children", "Leader", 1,40,3,"C"
                ,3,1,6,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "The Warchild", "The Children", "Leader Character", 2,50,4,"C"
                ,3,2,6,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","PARRY","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Iron Lotus Warrior", "Lotus Warrior", "Infantry", 1,30,2,"C"
                ,1,1,5,5,"MAGIC","MAGIC","DODGE","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Black Lotus", "Lotus Warrior", "Leader", 1,30,2,"C"
                ,3,1,6,7,"MAGIC","MAGIC","DODGE","DODGE","DODGE","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Madam Mui", "Lotus Warrior", "Leader Character", 2,30,2,"C"
                ,5,1,6,7,"MAGIC","MAGIC","PARRY","PARRY","DODGE","DODGE","DODGE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Shield of Taelfon", null, "Specialist", 1,30,2,"B"
                ,3,1,6,7,"MAGIC","MAGIC","MAGIC","MAGIC","MAGIC","STRIKE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Hammer of Heaven", null, "Specialist", 1,40,2,"C"
                ,3,1,5,6,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Fulung Devourer", null, "Specialist", 2,80,5,"A"
                ,3,2,7,6,"MAGIC","MAGIC","MAGIC","PARRY","ARMOR","ARMOR","STRIKE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "The Deathbloom", null, "Specialist Character", 2,30,2,"C"
                ,5,1,6,7,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","DODGE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "The Red Willow", null, "Specialist Character", 2,30,2,"C"
                ,2,2,6,7,"MAGIC","MAGIC","MAGIC","PARRY","PARRY","DODGE","DODGE","STRIKE","STRIKE","OVERPOWER","")); //need to add skills
        shaelHanDeck.add(new Card("ShaelHan", "Hong Yao", null, "Specialist Character", 2,30,2,"C"
                ,2,2,5,6,"MAGIC","MAGIC","PARRY","PARRY","ARMOR","ARMOR","ARMOR","STRIKE","STRIKE","OVERPOWER","")); //need to add skills

    }

}
