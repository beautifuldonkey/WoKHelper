package beautifuldonkey.wokhelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import beautifuldonkey.wokhelper.Adapters.WokBattleExpandableListAdapter;
import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;
import beautifuldonkey.wokhelper.Data.Motivation;
import beautifuldonkey.wokhelper.Data.MotiviationList;


public class BattleHelper extends ActionBarActivity {

    ArrayList<String> selfAvailableUnitList;
    ArrayList<String> selfSelectedUnitList;
    ArrayList<String> opponentAvailableUnitList;
    ArrayList<String> opponentSelectedUnitList;
    String selfCurrentHouse = "";
    String oppCurrentHouse = "";
    WokBattleExpandableListAdapter expListAdapter;
    ArrayAdapter<String> motivationAdapter;
    Spinner spinnerMotivations;
    List<Motivation> motivations;
    ArrayList<String> availMotivationList;
    Spinner selfAvailableUnits;
    List<Card> selfCards;
    ArrayAdapter<String> selfAvailAdapter;

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_helper);
        final Context context = this;
        final Activity thisActivity = this;

        List<House> houses = HouseData.getHouseList();
        String[] houseNames = new String[houses.size()];
        for(int i=0; i<houses.size(); i++){
            houseNames[i] = houses.get(i).getHouseName();
        }

        createGroupList();
        createCollection();
        expListView = (ExpandableListView) findViewById(R.id.sectionHolder);

        expListAdapter = new WokBattleExpandableListAdapter(thisActivity, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG).show();
                return true;
            }
        });


        motivations = MotiviationList.getHouseMotivations(selfCurrentHouse);
        availMotivationList = new ArrayList<>();
        for(int i=0; i<motivations.size(); i++){
            availMotivationList.add(motivations.get(i).getName());
        }
        spinnerMotivations = (Spinner) findViewById(R.id.self_motivation);
        motivationAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, availMotivationList);
        spinnerMotivations.setAdapter(motivationAdapter);

        selfCards = DeckBuilder.buildHouseDeck(selfCurrentHouse);
        selfAvailableUnitList = new ArrayList<>();
        for (int i = 0; i < selfCards.size(); i++) {
            selfAvailableUnitList.add(selfCards.get(i).getName());
        }

        selfAvailableUnits = (Spinner) findViewById(R.id.self_avail_units);
        selfAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, selfAvailableUnitList);
        selfAvailableUnits.setAdapter(selfAvailAdapter);
        selfAvailableUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (selfSelectedUnitList == null) {
                    selfSelectedUnitList = new ArrayList<>();
                }
                selfSelectedUnitList.add(selfAvailableUnits.getItemAtPosition(position).toString());
                final ListView selfSelectedUnits = (ListView) findViewById(R.id.self_units);
                final ArrayAdapter<String> selfSelectedUnitsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, selfSelectedUnitList);
                selfSelectedUnits.setAdapter(selfSelectedUnitsAdapter);
                selfSelectedUnits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        selfSelectedUnitList.remove(i);
                        selfSelectedUnitsAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> houseArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, houseNames);
        final Spinner selfHouse = (Spinner) findViewById(R.id.self_house);
        selfHouse.setAdapter(houseArrayAdapter);
        selfHouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selfCurrentHouse = selfHouse.getItemAtPosition(position).toString();
                createGroupList();
                expListAdapter = new WokBattleExpandableListAdapter(thisActivity, groupList, laptopCollection);
                expListView.setAdapter(expListAdapter);

                motivations.clear();
                availMotivationList.clear();
                motivations = MotiviationList.getHouseMotivations(selfCurrentHouse);
                for(int i=0; i<motivations.size(); i++){
                    availMotivationList.add(motivations.get(i).getName());
                }
                motivationAdapter.notifyDataSetChanged();


                //TODO update available units
                selfCards = DeckBuilder.buildHouseDeck(selfCurrentHouse);
                selfAvailableUnitList = new ArrayList<>();
                for (int i = 0; i < selfCards.size(); i++) {
                    selfAvailableUnitList.add(selfCards.get(i).getName());
                }
                selfAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, selfAvailableUnitList);
                selfAvailableUnits.setAdapter(selfAvailAdapter);
//                selfAvailAdapter.notifyDataSetChanged();
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
                String currentHouse = oppHouse.getItemAtPosition(position).toString();
                List<Card> oppCards = DeckBuilder.buildHouseDeck(currentHouse);
                opponentAvailableUnitList = new ArrayList<>();
                for (int i = 0; i < oppCards.size(); i++) {
                    opponentAvailableUnitList.add(oppCards.get(i).getName());
                }

                List<Motivation> motivations = MotiviationList.getHouseMotivations(currentHouse);
                ArrayList<String> availMotivationList = new ArrayList<>();
                for (int i = 0; i < motivations.size(); i++) {
                    availMotivationList.add(motivations.get(i).getName());
                }
                Spinner spinnerMotivations = (Spinner) findViewById(R.id.opponent_motivation);
                ArrayAdapter<String> motivationAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, availMotivationList);
                spinnerMotivations.setAdapter(motivationAdapter);

                final Spinner opponentAvailableUnits = (Spinner) findViewById(R.id.opponent_avail_units);
                ArrayAdapter<String> oppAvailAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, opponentAvailableUnitList);
                opponentAvailableUnits.setAdapter(oppAvailAdapter);
                opponentAvailableUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (opponentSelectedUnitList == null) {
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

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add(selfCurrentHouse);
        groupList.add(oppCurrentHouse);
        groupList.add("Lenovo");
//        groupList.add("Sony");
//        groupList.add("HCL");
//        groupList.add("Samsung");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] hpModels = { "HP Pavilion G6-2014TX", "ProBook HP 4540",
                "HP Envy 4-1025TX" };
        String[] hclModels = { "HCL S2101", "HCL L2102", "HCL V2002" };
        String[] lenovoModels = { "IdeaPad Z Series", "Essential G Series",
                "ThinkPad X Series", "Ideapad Z Series" };
        String[] sonyModels = { "VAIO E Series", "VAIO Z Series",
                "VAIO S Series", "VAIO YB Series" };
        String[] dellModels = { "Inspiron", "Vostro", "XPS" };
        String[] samsungModels = { "NP Series", "Series 5", "SF Series" };

        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("HP")) {
                loadChild(hpModels);
            } else if (laptop.equals("Dell"))
                loadChild(dellModels);
            else if (laptop.equals("Sony"))
                loadChild(sonyModels);
            else if (laptop.equals("HCL"))
                loadChild(hclModels);
            else if (laptop.equals("Samsung"))
                loadChild(samsungModels);
            else
                loadChild(lenovoModels);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
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
