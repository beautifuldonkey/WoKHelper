package beautifuldonkey.wokhelper.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * List of motivations and description of each
 * Created by user on 7/22/2015.
 */
public class MotiviationList {

    private static List<Motivation> motivations = new ArrayList<>();
    private static List<Motivation> intrigueMotivations = new ArrayList<>();
    private static List<Motivation> treacheryMotivations = new ArrayList<>();
    private static List<Motivation> greedMotivations = new ArrayList<>();
    private static List<Motivation> vengeanceMotivations = new ArrayList<>();
    private static List<Motivation> dutyMotivations = new ArrayList<>();

    public static List<Motivation> getMotivations(){
        motivations.addAll(dutyMotivations);
        motivations.addAll(intrigueMotivations);
        motivations.addAll(treacheryMotivations);
        motivations.addAll(greedMotivations);
        motivations.addAll(vengeanceMotivations);
        return motivations;
    }

    public static List<Motivation> getHouseMotivations(String house){
        switch(house){
            case "Teknes":
                motivations.addAll(greedMotivations);
                motivations.addAll(treacheryMotivations);
                break;
            case "Shael Han":
                motivations.addAll(dutyMotivations);
                motivations.addAll(intrigueMotivations);
                break;
            case "Nasier":
                motivations.addAll(dutyMotivations);
                motivations.addAll(vengeanceMotivations);
                break;
            case "Hadross":
                motivations.addAll(greedMotivations);
                motivations.addAll(vengeanceMotivations);
                break;
            case "Goritsi":
                motivations.addAll(intrigueMotivations);
                motivations.addAll(treacheryMotivations);
                break;
        }

        return motivations;
    }

    static{
        intrigueMotivations.add(new Motivation("Disrupt Supply Line","desc"));
        intrigueMotivations.add(new Motivation("Gather Intelligence","desc"));
        intrigueMotivations.add(new Motivation("No Confidence","desc"));

        treacheryMotivations.add(new Motivation("Capture Prisoner","desc"));
        treacheryMotivations.add(new Motivation("Silence The Tongue","desc"));
        treacheryMotivations.add(new Motivation("Steal Intel","desc"));

        greedMotivations.add(new Motivation("Land Grab","desc"));
        greedMotivations.add(new Motivation("Treasure Hunt","desc"));
        greedMotivations.add(new Motivation("Personal Gain","desc"));

        vengeanceMotivations.add(new Motivation("Sever The Head","desc"));
        vengeanceMotivations.add(new Motivation("Burn It Down","desc"));
        vengeanceMotivations.add(new Motivation("Unstoppable Advance","desc"));

        dutyMotivations.add(new Motivation("Call To Glory","desc"));
        dutyMotivations.add(new Motivation("Escort Civilians","desc"));
        dutyMotivations.add(new Motivation("Stand Your Ground","desc"));
    }
}
