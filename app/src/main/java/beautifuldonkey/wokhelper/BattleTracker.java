package beautifuldonkey.wokhelper;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.wokhelper.Adapters.BattleTrackerExpandableListAdapter;
import beautifuldonkey.wokhelper.Data.ArmySummary;

public class BattleTracker extends ActionBarActivity {

    ExpandableListView expListView;
    BattleTrackerExpandableListAdapter expListAdapter;
    List<ArmySummary> battleSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_tracker);
        Activity activity = this;

        battleSummary = new ArrayList<>();
        battleSummary.add((ArmySummary) getIntent().getParcelableExtra("selfSummary"));
        battleSummary.add((ArmySummary) getIntent().getParcelableExtra("oppSummary"));

        expListView = (ExpandableListView) findViewById(R.id.armyList);
        expListAdapter = new BattleTrackerExpandableListAdapter(activity, battleSummary);
        expListView.setAdapter(expListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle_tracker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
