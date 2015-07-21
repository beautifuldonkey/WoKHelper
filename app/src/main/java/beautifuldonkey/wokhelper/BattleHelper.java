package beautifuldonkey.wokhelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;


public class BattleHelper extends ActionBarActivity {

    String[] selfAvailableUnitList;
    String[] opponentAvailableUnitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_helper);

        List<House> houses = HouseData.getHouseList();
        String[] houseNames = new String[houses.size()];
        for(int i=0; i<houses.size(); i++){
            houseNames[i] = houses.get(i).getHouseName();
        }

        ArrayAdapter<String> houseArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, houseNames);
        final Spinner selfHouse = (Spinner) findViewById(R.id.self_house);
        selfHouse.setAdapter(houseArrayAdapter);
        selfHouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<Card> selfCards = DeckBuilder.buildHouseDeck(selfHouse.getItemAtPosition(position).toString());
                selfAvailableUnitList = new String[selfCards.size()];
                for (int i = 0; i < selfCards.size(); i++) {
                    selfAvailableUnitList[i] = selfCards.get(i).getName();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner oppHouse = (Spinner) findViewById(R.id.opponent_house);
        oppHouse.setAdapter(houseArrayAdapter);
        oppHouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<Card> oppCards = DeckBuilder.buildHouseDeck(oppHouse.getItemAtPosition(position).toString());
                opponentAvailableUnitList = new String[oppCards.size()];
                for(int i=0; i<oppCards.size(); i++){
                    opponentAvailableUnitList[i] = oppCards.get(i).getName();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ListView selfAvailableUnits = (ListView) findViewById(R.id.self_units);
        //ArrayAdapter<String> selfAvailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selfAvailableUnitList);
        //selfAvailableUnits.setAdapter(selfAvailAdapter);

        ListView opponentAvailableUnits = (ListView) findViewById(R.id.opponent_units);

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
