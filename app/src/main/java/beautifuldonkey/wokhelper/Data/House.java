package beautifuldonkey.wokhelper.Data;

/**
 * Created by Jed on 4/29/2015.
 */
public class House {

    private String houseName;
    private String houseDescription;

    public House (String name, String desc){
        this.houseName = name;
        this.houseDescription = desc;
    }

    public String getHouseName() {
        return houseName;
    }
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
    public String getHouseDescription() {
        return houseDescription;
    }
    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }
}
