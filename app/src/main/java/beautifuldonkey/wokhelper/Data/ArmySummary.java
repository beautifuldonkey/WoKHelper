package beautifuldonkey.wokhelper.Data;

/**
 * used for data displayed for army summary
 * Created by beautifuldonkey on 8/16/2015.
 */
public class ArmySummary {

    private String name;
    private String motivation;
    private String units;

    public ArmySummary (String armyName, String armyMotivation, String armyUnits){
        this.name = armyName;
        this.motivation = armyMotivation;
        this.units = armyUnits;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
