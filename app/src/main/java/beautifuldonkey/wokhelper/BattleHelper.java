package beautifuldonkey.wokhelper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;


public class BattleHelper extends ActionBarActivity {

    ArrayList<String> selfAvailableUnitList;
    ArrayList<String> selfSelectedUnitList;
    ArrayList<String> opponentAvailableUnitList;
    ArrayList<String> opponentSelectedUnitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_helper);
        final Context context = this;

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
                selfAvailableUnitList = new ArrayList<>();
                for (int i = 0; i < selfCards.size(); i++) {
                    selfAvailableUnitList.add(selfCards.get(i).getName());
                }

                final Spinner selfAvailableUnits = (Spinner) findViewById(R.id.self_avail_units);
                ArrayAdapter<String> selfAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, selfAvailableUnitList);
                selfAvailableUnits.setAdapter(selfAvailAdapter);
                selfAvailableUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(selfSelectedUnitList == null){
                            selfSelectedUnitList = new ArrayList<>();
                        }
                        selfSelectedUnitList.add(selfAvailableUnits.getItemAtPosition(position).toString());
                        ListView selfSelectedUnits = (ListView) findViewById(R.id.self_units);
                        ArrayAdapter<String> selfSelectedUnitsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, selfSelectedUnitList);
                        selfSelectedUnits.setAdapter(selfSelectedUnitsAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
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
                opponentAvailableUnitList = new ArrayList<>();
                for (int i = 0; i < oppCards.size(); i++) {
                    opponentAvailableUnitList.add(oppCards.get(i).getName());
                }

                final Spinner opponentAvailableUnits = (Spinner) findViewById(R.id.opponent_avail_units);
                ArrayAdapter<String> oppAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, opponentAvailableUnitList);
                opponentAvailableUnits.setAdapter(oppAvailAdapter);
                opponentAvailableUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(opponentSelectedUnitList == null){
                            opponentSelectedUnitList = new ArrayList<>();
                        }
                        opponentSelectedUnitList.add(opponentAvailableUnits.getItemAtPosition(position).toString());
                        ListView opponentSelectedUnits = (ListView) findViewById(R.id.opponent_units);
                        ArrayAdapter<String> opponentSelectedUnitsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, opponentSelectedUnitList);
                        opponentSelectedUnits.setAdapter(opponentSelectedUnitsAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
