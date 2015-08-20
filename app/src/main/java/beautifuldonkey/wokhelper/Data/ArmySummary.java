package beautifuldonkey.wokhelper.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * used for data displayed for army summary
 * Created by beautifuldonkey on 8/16/2015.
 */
public class ArmySummary implements Parcelable {

    private String name;
    private String motivation;
    private String units;

    public ArmySummary (String armyName, String armyMotivation, String armyUnits){
        this.name = armyName;
        this.motivation = armyMotivation;
        this.units = armyUnits;
    }

    public ArmySummary (Parcel source){
        name = source.readString();
        motivation = source.readString();
        units = source.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(motivation);
        parcel.writeString(units);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArmySummary> CREATOR = new Creator<ArmySummary>() {
        @Override
        public ArmySummary createFromParcel(Parcel parcel) {
            return new ArmySummary(parcel);
        }

        @Override
        public ArmySummary[] newArray(int i) {
            return new ArmySummary[i];
        }
    };

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
