package beautifuldonkey.wokhelper.Data;

/**
 * Created by user on 5/10/2015.
 */
public class Ability {
    private int id;
    private String name;
    private String subName;
    private String type;
    private String dice;
    private String range;
    private String desc;

    public Ability(int id, String name, String subName, String type, String dice, String range, String desc){
        this.id = id;
        this.name = name;
        this.subName = subName;
        this.type = type;
        this.dice = dice;
        this.range = range;
        this.desc = desc;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
