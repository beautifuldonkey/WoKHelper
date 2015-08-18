package beautifuldonkey.wokhelper.Adapters;

/**
 * provides a customized expandable list adapter for a battle
 * Created by beautifuldonkey on 8/14/2015.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beautifuldonkey.wokhelper.Data.ArmySummary;
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
        final String laptop = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.battle_army_details, null);
        }

        List<House> houses = HouseData.getHouseList();
        final String[] houseNames = new String[houses.size()];
        for(int i=0; i<houses.size(); i++){
            houseNames[i] = houses.get(i).getHouseName();
        }
        ArrayAdapter<String> houseArrayAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, houseNames);
        Spinner selfHouse = (Spinner) convertView.findViewById(R.id.house);
        selfHouse.setAdapter(houseArrayAdapter);
        selfHouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterParent, View view, int position, long id) {
//                String selfCurrentHouse = selfHouse.getItemAtPosition(position).toString();
                String selfCurrentHouse = houseNames[position];
                summary.setName(selfCurrentHouse);

                TextView txtName = (TextView) parent.findViewById(R.id.houseName);
                txtName.setText(summary.getName());

//                expListAdapter = new WokBattleExpandableListAdapter(thisActivity, groupList, laptopCollection, battleSummary);
//                expListView.setAdapter(expListAdapter);

//                motivations.clear();
//                availMotivationList.clear();
//                motivations = MotiviationList.getHouseMotivations(selfCurrentHouse);
//                for(int i=0; i<motivations.size(); i++){
//                    availMotivationList.add(motivations.get(i).getName());
//                }
//                motivationAdapter.notifyDataSetChanged();
//                selfSummary.setMotivation(availMotivationList.get(0));
//
//                selfCards = DeckBuilder.buildHouseDeck(selfCurrentHouse);
//                selfAvailableUnitList = new ArrayList<>();
//                for (int i = 0; i < selfCards.size(); i++) {
//                    selfAvailableUnitList.add(selfCards.get(i).getName());
//                }
//                selfAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, selfAvailableUnitList);
//                selfAvailableUnits.setAdapter(selfAvailAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<Motivation> motivations = MotiviationList.getMotivations();
        final ArrayList<String> availMotivationList = new ArrayList<>();
        for(int i=0; i<motivations.size(); i++){
            availMotivationList.add(motivations.get(i).getName());
        }
        Spinner spinnerMotivations = (Spinner) convertView.findViewById(R.id.motivation);
        ArrayAdapter<String> motivationAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, availMotivationList);
        spinnerMotivations.setAdapter(motivationAdapter);
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
