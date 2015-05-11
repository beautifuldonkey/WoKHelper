package beautifuldonkey.wokhelper.Data;

/**
 * Created by Jed on 4/29/2015.
 */
public class Card {
    
    private int id;
    private String house;
    private String name;
    private String title;
    private String type;
    private int rank;
    private int base;
    private int size;
    private String dz;
    private String abilities;

    //STATS
    private int wounds;
    private int defense;
    private int attack;
    private int movement;
    private int defOne;
    private int defTwo;
    private int defThree;
    private int defFour;
    private int defFive;
    private int defSix;
    private int defSeven;
    private int defEight;
    private int defNine;
    private int defTen;

    public Card(int id, String house, String name, String title, String type, int rank, int base, int size, String dz, int wounds,
                int defense, int attack, int movement, int defOne, int defTwo, int defThree, int defFour, int defFive, int defSix,
                int defSeven, int defEight, int defNine, int defTen, String abilities){
        this.id = id;
        this.house = house;
        this.name = name;
        this.title = title;
        this.type = type;
        this.rank = rank;
        this.base = base;
        this.size = size;
        this.dz = dz;
        this.wounds = wounds;
        this.defense = defense;
        this.attack = attack;
        this.movement = movement;
        this.defOne = defOne;
        this.defTwo = defTwo;
        this.defThree = defThree;
        this.defFour = defFour;
        this.defFive = defFive;
        this.defSix = defSix;
        this.defSeven = defSeven;
        this.defEight = defEight;
        this.defNine = defNine;
        this.defTen = defTen;
        this.abilities = abilities;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getDefOne() {
        return defOne;
    }

    public void setDefOne(int defOne) {
        this.defOne = defOne;
    }

    public int getDefTwo() {
        return defTwo;
    }

    public void setDefTwo(int defTwo) {
        this.defTwo = defTwo;
    }

    public int getDefThree() {
        return defThree;
    }

    public void setDefThree(int defThree) {
        this.defThree = defThree;
    }

    public int getDefFour() {
        return defFour;
    }

    public void setDefFour(int defFour) {
        this.defFour = defFour;
    }

    public int getDefFive() {
        return defFive;
    }

    public void setDefFive(int defFive) {
        this.defFive = defFive;
    }

    public int getDefSix() {
        return defSix;
    }

    public void setDefSix(int defSix) {
        this.defSix = defSix;
    }

    public int getDefSeven() {
        return defSeven;
    }

    public void setDefSeven(int defSeven) {
        this.defSeven = defSeven;
    }

    public int getDefEight() {
        return defEight;
    }

    public void setDefEight(int defEight) {
        this.defEight = defEight;
    }

    public int getDefNine() {
        return defNine;
    }

    public void setDefNine(int defNine) {
        this.defNine = defNine;
    }

    public int getDefTen() {
        return defTen;
    }

    public void setDefTen(int defTen) {
        this.defTen = defTen;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String Title) {
        this.title = Title;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int Rank) {
        this.rank = Rank;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public int getWounds() {
        return wounds;
    }
    public void setWounds(int wounds) {
        this.wounds = wounds;
    }
}