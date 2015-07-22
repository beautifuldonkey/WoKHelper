package beautifuldonkey.wokhelper.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 4/30/2015.
 */
public class HouseData {

    private static List<House> houses = new ArrayList();

    public static List<House> getHouseList() {return houses;}

    static {
        houses.add(new House(1,"Hadross", "Hadross short summary", "looong description", "Greed,Vengeance"));
        houses.add(new House(2,"Teknes", "Teknes short summary", "description", "Greed,Treachery"));
        houses.add(new House(3,"Nasier", "Nasier short summary", "description", "Duty,Vengeance"));
        houses.add(new House(4,"Goritsi", "Goritsi short summary", "description", "Intrigue,Treachery"));
        houses.add(new House(5,"ShaelHan", "ShaelHan short summary", "description", "Duty,Intrigue"));
    }
}
