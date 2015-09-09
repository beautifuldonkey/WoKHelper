package beautifuldonkey.wokhelper.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Ability;
import beautifuldonkey.wokhelper.Data.AbilityList;
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
    private List<Card> cards;

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

        cards = DeckBuilder.buildArmyDeck(summary.getName(), summary.getUnits());

        ListView listArmyName = (ListView) convertView.findViewById(R.id.armyUnits);
        ArrayAdapter<Card> cardArrayAdapter = new CardArrayAdapter(context, 0, cards, childPosition);
        listArmyName.setAdapter(cardArrayAdapter);
        listArmyName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("POPUP","making popup");
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.battle_tracker_popup, null);

                Card card = cards.get(childPosition);
                List<Ability> abilities = AbilityList.getAbilitiesById(card.getAbilities());

                Log.d("POPUP", "popup card name: "+card.getName());
                if(!abilities.isEmpty()){
                    Log.d("POPUP", "popup ability name: "+abilities.get(0).getName());
                }
                ListView abilityList = (ListView) popupView.findViewById(R.id.abilityList);
                ArrayAdapter<Ability> abilityAdapter = new AbilityArrayAdapter(context, 0, abilities);
                abilityList.setAdapter(abilityAdapter);

                Log.d("POPUP", "displaying popup");
                PopupWindow abilityPopup = new PopupWindow(popupView,400,400);
                abilityPopup.showAtLocation(view, Gravity.CENTER, 50, 50);


            }
        });


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
//            defOne.setText("1: "+card.getDefOne());
            defOne.setText("1: ");
            ImageView defOneIcon = (ImageView) view.findViewById(R.id.defOneIcon);
            int defOneRes = context.getResources().getIdentifier(
                    "icon_"+card.getDefOne().toLowerCase(),"drawable",context.getPackageName());
            defOneIcon.setImageResource(defOneRes);

            TextView defTwo = (TextView) view.findViewById(R.id.defTwo);
//            defTwo.setText("2: "+card.getDefTwo());
            defTwo.setText("2: ");
            ImageView defTwoIcon = (ImageView) view.findViewById(R.id.defTwoIcon);
            int defTwoRes = context.getResources().getIdentifier(
                    "icon_"+card.getDefTwo().toLowerCase(),"drawable",context.getPackageName());
            defTwoIcon.setImageResource(defTwoRes);

            TextView defThree = (TextView) view.findViewById(R.id.defThree);
//            defThree.setText("3: "+card.getDefThree());
            defThree.setText("3: ");
            ImageView defThreeIcon = (ImageView) view.findViewById(R.id.defThreeIcon);
            int defThreeRes = context.getResources().getIdentifier(
                    "icon_"+card.getDefThree().toLowerCase(),"drawable",context.getPackageName());
            defThreeIcon.setImageResource(defThreeRes);

            TextView defFour = (TextView) view.findViewById(R.id.defFour);
//            defFour.setText("4: "+card.getDefFour());
            defFour.setText("4: ");
            ImageView defFourIcon = (ImageView) view.findViewById(R.id.defFourIcon);
            int defFourRes = context.getResources().getIdentifier(
                    "icon_"+card.getDefFour().toLowerCase(),"drawable",context.getPackageName());
            defFourIcon.setImageResource(defFourRes);

            TextView defFive = (TextView) view.findViewById(R.id.defFive);
//            defFive.setText("5: "+card.getDefFive());
            defFive.setText("5: ");
            ImageView defFiveIcon = (ImageView) view.findViewById(R.id.defFiveIcon);
            int defFiveRes = context.getResources().getIdentifier(
                    "icon_"+card.getDefFive().toLowerCase(),"drawable",context.getPackageName());
            defFiveIcon.setImageResource(defFiveRes);

//            TextView defSix = (TextView) view.findViewById(R.id.defSix);
////            defSix.setText("6: "+card.getDefSix());
//            defSix.setText("6: ");
//            ImageView defSixIcon = (ImageView) view.findViewById(R.id.defSixIcon);
//            int defSixRes = context.getResources().getIdentifier(
//                    "icon_"+card.getDefSix().toLowerCase(),"drawable",context.getPackageName());
//            defSixIcon.setImageResource(defSixRes);
//
//            TextView defSeven = (TextView) view.findViewById(R.id.defSeven);
////            defSeven.setText("7: "+card.getDefSeven());
//            defSeven.setText("7: ");
//            ImageView defSevenIcon = (ImageView) view.findViewById(R.id.defSevenIcon);
//            int defSevenRes = context.getResources().getIdentifier(
//                    "icon_"+card.getDefSeven().toLowerCase(),"drawable",context.getPackageName());
//            defSevenIcon.setImageResource(defSevenRes);
//
//            TextView defEight = (TextView) view.findViewById(R.id.defEight);
////            defEight.setText("8: "+card.getDefEight());
//            defEight.setText("8: ");
//            ImageView defEightIcon = (ImageView) view.findViewById(R.id.defEightIcon);
//            int defEightRes = context.getResources().getIdentifier(
//                    "icon_"+card.getDefEight().toLowerCase(),"drawable",context.getPackageName());
//            defEightIcon.setImageResource(defEightRes);
//
//            TextView defNine = (TextView) view.findViewById(R.id.defNine);
////            defNine.setText("9: " + card.getDefNine());
//            defNine.setText("9: ");
//            ImageView defNineIcon = (ImageView) view.findViewById(R.id.defNineIcon);
//            int defNineRes = context.getResources().getIdentifier(
//                    "icon_"+card.getDefNine().toLowerCase(),"drawable",context.getPackageName());
//            defNineIcon.setImageResource(defNineRes);

            TextView defTen = (TextView) view.findViewById(R.id.defTen);
//            defTen.setText("10: "+card.getDefTen());
//            defTen.setText("10: ");
//            ImageView defTenIcon = (ImageView) view.findViewById(R.id.defTenIcon);
//            int defTenRes = context.getResources().getIdentifier(
//                    "icon_"+card.getDefTen().toLowerCase(),"drawable",context.getPackageName());
//            defTenIcon.setImageResource(defTenRes);

            return view;
        }
    }
}
