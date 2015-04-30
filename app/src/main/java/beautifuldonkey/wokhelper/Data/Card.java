package beautifuldonkey.wokhelper.Data;

/**
 * Created by Jed on 4/29/2015.
 */
public class Card {
    
    private int id;
    private String house;
    private String unitName;
    private String unitTitle;
    private String unitRank;
    private int wounds;

    public Card(int id, String house, String unitName, String unitTitle, String unitRank, int wounds){
        this.id = id;
        this.house = house;
        this.unitName = unitName;
        this.unitTitle = unitTitle;
        this.unitRank = unitRank;
        this.wounds = wounds;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getUnitTitle() {
        return unitTitle;
    }
    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }
    public String getUnitRank() {
        return unitRank;
    }
    public void setUnitRank(String unitRank) {
        this.unitRank = unitRank;
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
