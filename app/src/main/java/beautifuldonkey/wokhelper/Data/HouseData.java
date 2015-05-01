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
        houses.add(new House("Hadross", "Hadross short summary", "looong description"));
        houses.add(new House("Teknes", "Teknes short summary", " description"));
        houses.add(new House("Nasier", "Nasier short summary", " description"));
        houses.add(new House("Goritsi", "Goritsi short summary", " description"));
        houses.add(new House("ShaelHan", "ShaelHan short summary", " description"));
    }
}
