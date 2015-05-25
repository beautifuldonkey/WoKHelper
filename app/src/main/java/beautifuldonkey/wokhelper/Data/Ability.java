package beautifuldonkey.wokhelper.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 5/10/2015.
 */
public class Ability implements Parcelable{
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

    public Ability(Parcel source){
        id = source.readInt();
        name = source.readString();
        subName = source.readString();
        type = source.readString();
        dice = source.readString();
        range = source.readString();
        desc = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(subName);
        dest.writeString(type);
        dest.writeString(dice);
        dest.writeString(range);
        dest.writeString(desc);
    }

    public static final Creator<Ability> CREATOR = new Creator<Ability>(){

        @Override
        public Ability createFromParcel(Parcel source) {
            return new Ability(source);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };

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
