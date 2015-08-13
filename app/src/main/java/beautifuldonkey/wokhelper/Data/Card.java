package beautifuldonkey.wokhelper.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Defines Card class - used for data of individual cards
 * Created by Jed on 4/29/2015.
 */
public class Card implements Parcelable{
    
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
    private int resiliance;
    private int willpower;
    private int mobility;
    private String defOne;
    private String defTwo;
    private String defThree;
    private String defFour;
    private String defFive;
    private String defSix;
    private String defSeven;
    private String defEight;
    private String defNine;
    private String defTen;

    public Card(String house, String name, String title, String type, int rank, int base, int size, String dz, int wounds,
                int resiliance, int willpower, int mobility, String defOne, String defTwo, String defThree, String defFour, String defFive,
                String defSix, String defSeven, String defEight, String defNine, String defTen, String abilities){
        this.house = house;
        this.name = name;
        this.title = title;
        this.type = type;
        this.rank = rank;
        this.base = base;
        this.size = size;
        this.dz = dz;
        this.wounds = wounds;
        this.resiliance = resiliance;
        this.willpower = willpower;
        this.mobility = mobility;
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

    public Card (Parcel source){
        house = source.readString();
        name = source.readString();
        title = source.readString();
        type = source.readString();
        rank = source.readInt();
        base = source.readInt();
        size = source.readInt();
        dz = source.readString();
        abilities = source.readString();

        //STATS
        wounds = source.readInt();
        resiliance = source.readInt();
        willpower = source.readInt();
        mobility = source.readInt();
        defOne = source.readString();
        defTwo = source.readString();
        defThree = source.readString();
        defFour = source.readString();
        defFive = source.readString();
        defSix = source.readString();
        defSeven = source.readString();
        defEight = source.readString();
        defNine = source.readString();
        defTen = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(house);
        dest.writeString(name);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeInt(rank);
        dest.writeInt(base);
        dest.writeInt(size);
        dest.writeString(dz);
        dest.writeString(abilities);
        dest.writeInt(wounds);
        dest.writeInt(resiliance);
        dest.writeInt(willpower);
        dest.writeInt(mobility);
        dest.writeString(defOne);
        dest.writeString(defTwo);
        dest.writeString(defThree);
        dest.writeString(defFour);
        dest.writeString(defFive);
        dest.writeString(defSix);
        dest.writeString(defSeven);
        dest.writeString(defEight);
        dest.writeString(defNine);
        dest.writeString(defTen);
    }

    public static final Creator<Card> CREATOR = new Creator<Card>(){

        @Override
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

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
        return resiliance;
    }

    public void setDefense(int resiliance) {
        this.resiliance = resiliance;
    }

    public int getAttack() {
        return willpower;
    }

    public void setAttack(int willpower) {
        this.willpower = willpower;
    }

    public int getMovement() {
        return mobility;
    }

    public void setMovement(int mobility) {
        this.mobility = mobility;
    }

    public String getDefOne() {
        return defOne;
    }

    public void setDefOne(String defOne) {
        this.defOne = defOne;
    }

    public String getDefTwo() {
        return defTwo;
    }

    public void setDefTwo(String defTwo) {
        this.defTwo = defTwo;
    }

    public String getDefThree() {
        return defThree;
    }

    public void setDefThree(String defThree) {
        this.defThree = defThree;
    }

    public String getDefFour() {
        return defFour;
    }

    public void setDefFour(String defFour) {
        this.defFour = defFour;
    }

    public String getDefFive() {
        return defFive;
    }

    public void setDefFive(String defFive) {
        this.defFive = defFive;
    }

    public String getDefSix() {
        return defSix;
    }

    public void setDefSix(String defSix) {
        this.defSix = defSix;
    }

    public String getDefSeven() {
        return defSeven;
    }

    public void setDefSeven(String defSeven) {
        this.defSeven = defSeven;
    }

    public String getDefEight() {
        return defEight;
    }

    public void setDefEight(String defEight) {
        this.defEight = defEight;
    }

    public String getDefNine() {
        return defNine;
    }

    public void setDefNine(String defNine) {
        this.defNine = defNine;
    }

    public String getDefTen() {
        return defTen;
    }

    public void setDefTen(String defTen) {
        this.defTen = defTen;
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