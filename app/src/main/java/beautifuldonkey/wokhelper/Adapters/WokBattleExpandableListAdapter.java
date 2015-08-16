package beautifuldonkey.wokhelper.Adapters;

/**
 * provides a customized expandable list adapter for a battle
 * Created by beautifuldonkey on 8/14/2015.
 */
import java.util.List;
import java.util.Map;

import beautifuldonkey.wokhelper.Data.ArmySummary;
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
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String laptop = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.battle_army_details, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.test_name);

        Button delete = (Button) convertView.findViewById(R.id.btn_delete);
        delete.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to remove?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                List<String> child =
                                        laptopCollections.get(laptops.get(groupPosition));
                                child.remove(childPosition);
                                notifyDataSetChanged();
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        item.setText(laptop);
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
        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
