package beautifuldonkey.wokhelper;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;
import beautifuldonkey.wokhelper.Data.HouseData;


public class HouseChooser extends ActionBarActivity {

    protected List<House> houses;
    public static final int HOUSE_DETAIL_REQUEST_CODE = 01;
    public static final String HOUSE_NAME = "houseName";
    public static final String HOUSE_DESC = "houseDesc";
    public static final String HOUSE_SUMMARY = "houseSummary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_chooser);

        //List<Card> deck = DeckBuilder.buildDeck();

        houses = HouseData.getHouseList();

        ArrayAdapter<House> houseArrayAdapter = new ArrayAdapter<House>(this, android.R.layout.simple_list_item_1, houses);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(houseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                House house = houses.get(position);
                displayHouseDetail(house);
            }
        });
//        Iterator<House> houseIterator = houses.iterator();
//        Iterator<Card> cardIterator  = deck.iterator();
//
//        StringBuilder builder = new StringBuilder();
//
//        while(houseIterator.hasNext()){
//            House house = houseIterator.next();
//            builder.append(house.getHouseName()+":"+house.getHouseSummary())
//                    .append("\n");
//        }
//
//        TextView tv = (TextView) findViewById(R.id.cards);
//        tv.setText(builder.toString());
    }

    private void displayHouseDetail(House house) {
        Log.d("MainActivity", "Displaying house: " + house.getHouseName());

        Intent intent = new Intent(this, HouseDetail.class );
        intent.putExtra(HOUSE_NAME,house.getHouseName());
        intent.putExtra(HOUSE_DESC,house.getHouseDescription());
        intent.putExtra(HOUSE_SUMMARY,house.getHouseSummary());
        startActivityForResult(intent, HOUSE_DETAIL_REQUEST_CODE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_house_chooser, menu);
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

    public void houseClick(View view) {
        //TODO display house details for the selected house


    }
}
