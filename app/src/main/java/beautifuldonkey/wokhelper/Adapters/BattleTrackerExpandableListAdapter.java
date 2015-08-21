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
        final ArmySummary summary = (ArmySummary)getGroup(groupPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.battle_tracker, null);
        }
        //TODO bind layout elements

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return 1;
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
}
