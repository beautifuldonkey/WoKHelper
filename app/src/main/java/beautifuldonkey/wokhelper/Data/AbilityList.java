package beautifuldonkey.wokhelper.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/10/2015.
 */
public class AbilityList {

    private static List<Ability> abilities = new ArrayList();

    public static List<Ability> getAbilities() {
        return abilities;
    }

    public static List<Ability> getAbilitiesById(String idString){
        List<Ability> unitAbilities = new ArrayList();
        if(idString.contains(",")){
            String [] id =  idString.split(",");
            for (int i = 0; i<idString.length(); i++){
                for (int j = 0; j<abilities.size(); j++) {
                    if (id[i] == String.valueOf(abilities.get(j).getId())){
                        unitAbilities.add(abilities.get(j));
                    }
                }
            }

        }
        return unitAbilities;
    }

    static {
        //Ability (id, name, subName, type, dice, range, desc)

        //STANDARD

        abilities.add(new Ability(1, "Greatsword", "Follow-Through(1)", "Melee", "1", "00",
                "Replace(1) X on the defender's chart with BOLT."));

        abilities.add(new Ability(2, "Galvanic Bolt", "Suppression(1)", "Magic", "1", "8",
                "Replace(1) STAR on the defender's chart with BOLT."));

        abilities.add(new Ability(3, "Galvanic Feedback", null, "Toggle", null, null,
                "Aura 6in, DOUGHNUT results on friendly models in the area cause Backlash against Magic attacks."));

        abilities.add(new Ability(4, "Reinforce Will", null, "Toggle", null, null,
                "Aura 6in, Friendly models in the area gain Strong Will."));

        abilities.add(new Ability(5, "Savage Blow", null, "Melee", "1", "00", null));

        abilities.add(new Ability(6, "Sword Strike", null, "Melee", "2", "00", null));

        abilities.add(new Ability(7, "Brutal Methods", null, "Melee", "3", "00", null));

        abilities.add(new Ability(8, "Hammer Time", "Knockback(2)", "Melee", "2", "00",
                "Before results are generated, each enemy targeted by this attack is forced 2in. away. "+
        "If that enemy's movement is stopped by another model the model stopping it suffers a 1 DICE melee attack."));

        abilities.add(new Ability(9, "Rescue", null, "Action", null, null,
                "Target 1 engaged friendly model within 3in. Place that model in contact with this model. " +
                        "You may then place this model anywhere in contact with an enemy the friendly model was engaged with."));


        //SPECIAL

        abilities.add(new Ability(40, "Pain Fueled", null, "Special", null, null,
                "While this model has 1 or more damage on it, it gains +1 MOVEMENT, and its melee attacks " +
                        "gain Unstoppable(1) and +1 DICE."));

        abilities.add(new Ability(41, "Unstoppable(1)", null, "Special", null, null,
                "Replace 1 Non-BOLT Non-SKULL on the defender's chart with BOLT"));

        abilities.add(new Ability(42, "Abomination", null, "Special", null, null,
                "Aura 6, enemies in the area suffer -2 to Command Values, to a minimum of 0."));

        abilities.add(new Ability(43, "Nimble", null, "Special", null, null,
                "During free movement, this model ignores the Rough keyword of terrain elements."));

        abilities.add(new Ability(44, "Unleashed", "Reaction", "Special", null, null,
                "For each SKULL result generated on this model make a Will Attack (1) against each enemy " +
                        "within 3in. For each success that enemy suffers 1 damage."));

        abilities.add(new Ability(45, "Ward Bearer", null, "Special", null, null,
                "Aura 6, enemies in the area lose Sundering(x)"));

        abilities.add(new Ability(46, "Strong Will", null, "Special", null, null,
                "When this model makes a Will Check or is the target of a Will Attack, it gains re-roll(+1)"));

        abilities.add(new Ability(47, "Bolster", null, "Special", null, null,
                "This model may make an assist action on a model up to 2 in. away."));

        abilities.add(new Ability(48, "Whip Into Frenzy", null, "Special", null, null,
                "When this model is part of a combined activation, any activating model with "+
        "Pain Fueled may suffer 1 damage at the start of its activation."));

        abilities.add(new Ability(49, "Counterattack DOUGHNUT (2)", "Reaction", "Special", null, null,null));

        abilities.add(new Ability(50, "Defensive Expertise", null, "Special", null, null,
                "When this model is the defender of an attack, before results are generated, it may force " +
                        "the attacker to re-roll up to 1 dice."));

        abilities.add(new Ability(51, "Counterattack(2)", "Reaction", "Special", null, null,
                "Once per attack, when a DOUGHNUT is generated against this model, and this model is not killed, " +
                        "this model may perform 1 of its melee attacks on an active enemy, replacing the attack's rate with (2)"));

        abilities.add(new Ability(52, "Iron Will", null, "Special", null, null,
                "When targeted by a Will Attack this model gains +2 ATTACK for the attack"));


        //COMMAND

        abilities.add(new Ability(70, "Inspire", "Union Boss", "Command", null, null,
                "While in contact with a friendly model, this model gains Offensive Expertise(+1)."));

        abilities.add(new Ability(71, "Offensive Expertise(1)", "Union Boss", "Command", null, null,
                "When this model performs an attack, before results are generated, it may re-roll up to 1 dice."));

        abilities.add(new Ability(72, "Training", "Union Boss", "Command", null, null,
                "Once per turn, if this model is unengaged, and an enemy kills a friendly model within 2in. "+
        "this model may move up to 2in. toward that enemy."));

        abilities.add(new Ability(73, "Inspire", "Defender Linemen Controller", "Command", null, null,
                "This model may perform the Rescue action after sprinting."));

        abilities.add(new Ability(74, "Training", "Defender Linemen Controller", "Command", null, null,
                "All friendly models gain Iron Will."));

    }
}
