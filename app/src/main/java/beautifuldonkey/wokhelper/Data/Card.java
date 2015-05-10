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
    private int wounds;

    public Card(int id, String house, String name, String title, String type, int rank, int base, int size, String dz, int wounds){
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
