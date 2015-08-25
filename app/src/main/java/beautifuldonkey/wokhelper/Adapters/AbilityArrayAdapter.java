package beautifuldonkey.wokhelper.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Ability;
import beautifuldonkey.wokhelper.R;

/**
 * added to provide an array adapter for the ability class
 * Created by beautifuldonkey on 8/24/2015.
 */
public class AbilityArrayAdapter extends ArrayAdapter<Ability> {

//    private Activity activity;
    private Context context;
    private List<Ability> abilities;

    public AbilityArrayAdapter(Context context, int resource, List<Ability> objects) {
        super(context, resource, objects);
//        this.activity = activity;
        this.context = context;
        this.abilities = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Ability ability = abilities.get(position);

        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.ability_item, null);

        TextView tvAbilityName = (TextView)view.findViewById(R.id.abilityName);
        tvAbilityName.setText(ability.getName());
        TextView tvAbilityType = (TextView)view.findViewById(R.id.abilityType);
        tvAbilityType.setText(ability.getType());
        TextView tvAbilityDice = (TextView)view.findViewById(R.id.abilityDice);
        tvAbilityDice.setText(ability.getDice());
        TextView tvAbilityRange = (TextView)view.findViewById(R.id.abilityRange);
        tvAbilityRange.setText(ability.getRange());
        TextView tvAbilityDescription = (TextView)view.findViewById(R.id.abilityDescription);
        String descText;
        if(ability.getSubName()!= null){
            descText = ability.getSubName() + " "+ ability.getDesc();
        }else{
            descText = ability.getDesc();
        }
        tvAbilityDescription.setText(descText);


        return view;
    }
}
