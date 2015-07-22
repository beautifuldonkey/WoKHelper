package beautifuldonkey.wokhelper.Data;

/**
 * Created by Jed on 4/29/2015.
 */
public class House {

    private int houseId;
    private String houseName;
    private String houseSummary;
    private String houseDescription;
    private String houseMotivation;


    public House (int id, String name,String summary, String desc, String motivation){
        this.houseId = id;
        this.houseName = name;
        this.houseSummary = summary;
        this.houseDescription = desc;
        this.houseMotivation = motivation;
    }

    public int getId(){return houseId;}
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
    public String getHouseSummary() {
        return houseSummary;
    }
    public void setHouseSummary(String houseSummary) {
        this.houseSummary = houseSummary;
    }

    public String getHouseMotivation() {
        return houseMotivation;
    }

    public void setHouseMotivation(String houseMotivation) {
        this.houseMotivation = houseMotivation;
    }

    @Override
    public String toString() {
        return houseName + " : " + houseSummary;
    }
}
