package beautifuldonkey.wokhelper.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.wokhelper.Data.ArmySummary;
import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;
import beautifuldonkey.wokhelper.Data.Motivation;
import beautifuldonkey.wokhelper.Data.MotiviationList;
import beautifuldonkey.wokhelper.R;

/**
 * expandable list adapter class for managing a battle after setup
 * Created by beautifuldonkey on 8/20/2015.
 */
public class BattleTrackerExpandableListAdapter extends BaseExpandableListAdapter{
    private Activity context;
    private List<ArmySummary> battleSummary;

    public BattleTrackerExpandableListAdapter(Activity context, List<ArmySummary> battleSummary) {
        this.context = context;
        this.battleSummary = battleSummary;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return battleSummary.get(groupPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, final ViewGroup parent) {
        ArmySummary summary = (ArmySummary)getGroup(groupPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.battle_tracker, null);
        }

        List<Card> cards = DeckBuilder.buildArmyDeck(summary.getName(), summary.getUnits());

        ListView txtArmyName = (ListView) convertView.findViewById(R.id.armyUnits);
        ArrayAdapter<Card> cardArrayAdapter = new CardArrayAdapter(context, 0, cards, childPosition);
        txtArmyName.setAdapter(cardArrayAdapter);


        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        String [] units =  battleSummary.get(groupPosition).getUnits().split(",");
        return units.length;
    }

    public Object getGroup(int groupPosition) {
        return battleSummary.get(groupPosition);
    }

    public int getGroupCount() {
        return battleSummary.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //this is where current incoming data mapping is displayed ont he screen
        ArmySummary summary = (ArmySummary)getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.battle_army_summary,
                    null);
        }
        TextView txtName = (TextView) convertView.findViewById(R.id.houseName);
        txtName.setTypeface(null, Typeface.BOLD);
        txtName.setText(summary.getName());

        TextView txtMotivation= (TextView) convertView.findViewById(R.id.motivation);
        txtMotivation.setText(summary.getMotivation());

        TextView txtUnits = (TextView) convertView.findViewById(R.id.units);
        txtUnits.setText(summary.getUnits());

        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class CardArrayAdapter extends ArrayAdapter<Card>{

        Context context;
        List<Card> objects;
        int childPosition;

        public CardArrayAdapter(Context context, int resource, List<Card> objects, int childPosition){
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
            this.childPosition = childPosition;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //TODO bind layout elements

            Card card = objects.get(childPosition);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.battle_unit, null);

            TextView txtName = (TextView) view.findViewById(R.id.unitName);
            txtName.setText(card.getName());

            TextView txtRank = (TextView) view.findViewById(R.id.unitRank);
            txtRank.setText(String.valueOf(card.getRank()));

            TextView txtType = (TextView) view.findViewById(R.id.unitType);
            txtType.setText(card.getType());

            TextView txtDz = (TextView) view.findViewById(R.id.unitDz);
            txtDz.setText(card.getDz());

            TextView txtWounds = (TextView) view.findViewById(R.id.unitWounds);
            txtWounds.setText(String.valueOf(card.getWounds()));

            TextView txtResiliance = (TextView) view.findViewById(R.id.unitDefense);
            txtResiliance.setText(String.valueOf(card.getDefense()));

            TextView txtWill = (TextView) view.findViewById(R.id.unitAttack);
            txtWill.setText(String.valueOf(card.getAttack()));

            TextView txtMove = (TextView) view.findViewById(R.id.unitMove);
            txtMove.setText(String.valueOf(card.getMovement()));

            TextView defOne = (TextView) view.findViewById(R.id.defOne);
            defOne.setText("1: "+card.getDefOne());

            TextView defTwo = (TextView) view.findViewById(R.id.defTwo);
            defTwo.setText("2: "+card.getDefTwo());

            TextView defThree = (TextView) view.findViewById(R.id.defThree);
            defThree.setText("3: "+card.getDefThree());

            TextView defFour = (TextView) view.findViewById(R.id.defFour);
            defFour.setText("4: "+card.getDefFour());

            TextView defFive = (TextView) view.findViewById(R.id.defFive);
            defFive.setText("5: "+card.getDefFive());

            TextView defSix = (TextView) view.findViewById(R.id.defSix);
            defSix.setText("6: "+card.getDefSix());

            TextView defSeven = (TextView) view.findViewById(R.id.defSeven);
            defSeven.setText("7: "+card.getDefSeven());

            TextView defEight = (TextView) view.findViewById(R.id.defEight);
            defEight.setText("8: "+card.getDefEight());

            TextView defNine = (TextView) view.findViewById(R.id.defNine);
            defNine.setText("9: "+card.getDefNine());

            TextView defTen = (TextView) view.findViewById(R.id.defTen);
            defTen.setText("10: "+card.getDefTen());

            return view;
        }
    }
}
