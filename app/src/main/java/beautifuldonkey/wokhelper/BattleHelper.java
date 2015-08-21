package beautifuldonkey.wokhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;
import beautifuldonkey.wokhelper.Adapters.BattleSetupExpandableListAdapter;
import beautifuldonkey.wokhelper.Data.ArmySummary;
import beautifuldonkey.wokhelper.Data.WokConstants;


public class BattleHelper extends ActionBarActivity {

    BattleSetupExpandableListAdapter expListAdapter;
    List<ArmySummary> battleSummary;
    ArmySummary selfSummary;
    ArmySummary oppSummary;

    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_helper);
        final Context context = this;
        final Activity thisActivity = this;
        selfSummary = new ArmySummary("","","");
        oppSummary = new ArmySummary("","","");
        battleSummary = new ArrayList<>();
        battleSummary.add(selfSummary);
        battleSummary.add(oppSummary);

        expListView = (ExpandableListView) findViewById(R.id.sectionHolder);
        expListAdapter = new BattleSetupExpandableListAdapter(thisActivity, battleSummary);
        expListView.setAdapter(expListAdapter);

        Button btn_startBattle = (Button) findViewById(R.id.btn_start);
        btn_startBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BattleTracker.class);
                intent.putExtra("selfSummary", battleSummary.get(0));
                intent.putExtra("oppSummary", battleSummary.get(1));
                startActivityForResult(intent, WokConstants.BATTLE_TRACKER_REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle_helper, menu);
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
