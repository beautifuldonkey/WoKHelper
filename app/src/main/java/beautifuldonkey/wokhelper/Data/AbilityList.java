package beautifuldonkey.wokhelper.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/10/2015.
 */
public class AbilityList {

    private static List<Ability> abilities = new ArrayList();
    public static List<Ability> getAbilities() {return abilities;}

    static {
        //Ability (id, name, subName, type, dice, range, desc)
        abilities.add(new Ability(1,"Greatsword","Follow-Through(1)","Melee","1","00",
                "Replace(1) X on the defender's chart with BOLT."));

        abilities.add(new Ability(2,"Rescue",null,"Action",null,null,
                "Target 1 engaged friendly model within 3in. Place that model in contact with this model."+
        "You May then place this model anywhere in contact with an enemy the friendly model was engaged with."));

    }
}
