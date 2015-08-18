package beautifuldonkey.wokhelper.Adapters;

/**
 * provides a customized expandable list adapter for a battle
 * Created by beautifuldonkey on 8/14/2015.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beautifuldonkey.wokhelper.Data.ArmySummary;
import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;
import beautifuldonkey.wokhelper.Data.Motivation;
import beautifuldonkey.wokhelper.Data.MotiviationList;
import beautifuldonkey.wokhelper.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class WokBattleExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> laptopCollections;
    private List<String> laptops;
    private List<ArmySummary> battleSummary;

    public WokBattleExpandableListAdapter(Activity context, List<String> laptops, Map<String, List<String>> laptopCollections, List<ArmySummary> battleSummary) {
        this.context = context;
        this.laptopCollections = laptopCollections;
        this.laptops = laptops;
        this.battleSummary = battleSummary;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return laptopCollections.get(laptops.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, final ViewGroup parent) {
        final ArmySummary summary = (ArmySummary)getGroup(groupPosition);
//        final String laptop = (String) getChild(groupPosition, childPosition);
//        String currentHouse;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.battle_army_details, null);
        }

        List<Motivation> motivations;
        Boolean motivationSelected = false;
        int selectedMotivationIndex = 0;
        if(!summary.getName().equals("")){
            motivations = MotiviationList.getHouseMotivations(summary.getName());
        }else{
            motivations = MotiviationList.getMotivations();
        }
        final ArrayList<String> availMotivationList = new ArrayList<>();
        for(int i=0; i<motivations.size(); i++){
            availMotivationList.add(motivations.get(i).getName());
            if(summary.getMotivation().equals(availMotivationList.get(i))){
                motivationSelected = true;
                selectedMotivationIndex = i;
            }
        }
        final Spinner spinnerMotivations = (Spinner) convertView.findViewById(R.id.motivation);
        final ArrayAdapter<String> motivationAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, availMotivationList);
        spinnerMotivations.setAdapter(motivationAdapter);
        if(motivationSelected){
            spinnerMotivations.setSelection(selectedMotivationIndex);
        }
        spinnerMotivations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                selfSummary.setMotivation(availMotivationList.get(i));
//                battleSummary.clear();
//                battleSummary.add(selfSummary);
//                battleSummary.add(oppSummary);
//                expListAdapter = new WokBattleExpandableListAdapter(thisActivity, groupList, laptopCollection, battleSummary);
//                expListView.setAdapter(expListAdapter);
                TextView summaryMotivation = (TextView) parent.findViewById(R.id.motivation);
                summary.setMotivation(availMotivationList.get(i));
                summaryMotivation.setText(summary.getMotivation());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] selectedUnits = {""};
        if (!summary.getUnits().equals("")) {
            selectedUnits = summary.getUnits().split(",");
        }
//        selfSelectedUnitList.add(selfAvailableUnits.getItemAtPosition(position).toString());
        final ListView selfSelectedUnits = (ListView) convertView.findViewById(R.id.sel_units);
        final ArrayAdapter<String> selectedUnitsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, selectedUnits);
        selfSelectedUnits.setAdapter(selectedUnitsAdapter);
        selfSelectedUnits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(selectedUnitsAdapter != null && selectedUnitsAdapter != null){
//                    selectedUnitsAdapter.remove(selectedUnitsAdapter.getItem(i));
//                    selectedUnitsAdapter.notifyDataSetChanged();
                }

            }
        });

        List<Card> cards = DeckBuilder.buildHouseDeck(summary.getName());
        final ArrayList<String> availableUnitList = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            availableUnitList.add(cards.get(i).getName());
        }

        Spinner spinnerAvailableUnits = (Spinner) convertView.findViewById(R.id.avail_units);
        final ArrayAdapter<String> unitListAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, availableUnitList);
        spinnerAvailableUnits.setAdapter(unitListAdapter);
        spinnerAvailableUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(summary.getUnits().equals("")){
                    summary.setUnits(availableUnitList.get(position));
                }else{
                    summary.setUnits(summary.getUnits()+","+availableUnitList.get(position));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<House> houses = HouseData.getHouseList();
        Boolean houseSelected = false;
        int selectedHouseIndex = 0;
        final String[] houseNames = new String[houses.size()];
        for(int i=0; i<houses.size(); i++){
            houseNames[i] = houses.get(i).getHouseName();
            if(summary.getName().equals(houseNames[i])){
                houseSelected = true;
                selectedHouseIndex = i;
            }
        }
        ArrayAdapter<String> houseArrayAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, houseNames);
        Spinner spinnerHouse = (Spinner) convertView.findViewById(R.id.house);
        spinnerHouse.setAdapter(houseArrayAdapter);
        if(houseSelected){
            spinnerHouse.setSelection(selectedHouseIndex);
        }
        spinnerHouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterParent, View view, int position, long id) {
                summary.setName(houseNames[position]);
                summary.setUnits("");

                TextView txtName = (TextView) parent.findViewById(R.id.houseName);
                txtName.setText(summary.getName());

                List<Motivation> motivations;
                motivations = MotiviationList.getHouseMotivations(summary.getName());

                availMotivationList.clear();
                for(int i=0; i<motivations.size(); i++){
                    availMotivationList.add(motivations.get(i).getName());
                }
                motivationAdapter.notifyDataSetChanged();

                List<Card> cards = DeckBuilder.buildHouseDeck(summary.getName());
                availableUnitList.clear();
                for (int i = 0; i < cards.size(); i++) {
                    availableUnitList.add(cards.get(i).getName());
                }
                unitListAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        int childCount = 0;
        if(!laptopCollections.isEmpty()){
            childCount = laptopCollections.get(laptops.get(groupPosition)).size();
        }
        return childCount;
    }

    public Object getGroup(int groupPosition) {
//        return laptops.get(groupPosition);
        return battleSummary.get(groupPosition);
    }

    public int getGroupCount() {
        return laptops.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //this is where current incoming data mapping is displayed ont he screen
//        String laptopName = (String) getGroup(groupPosition);
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
}
