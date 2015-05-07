package beautifuldonkey.wokhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
    public static final String HOUSE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_chooser);

        houses = HouseData.getHouseList();

        ArrayAdapter<House> houseArrayAdapter = new houseMenuArrayAdapter(this, 0, houses);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(houseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                House house = houses.get(position);
                displayHouseDetail(house);
            }
        });
    }

    private void displayHouseDetail(House house) {
        Intent intent = new Intent(this, HouseDetail.class );
        intent.putExtra(HOUSE_NAME,house.getHouseName());
        intent.putExtra(HOUSE_DESC,house.getHouseDescription());
        intent.putExtra(HOUSE_SUMMARY,house.getHouseSummary());
        intent.putExtra(HOUSE_ID, house.getId());
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

    class houseMenuArrayAdapter extends ArrayAdapter<House>{

        Context context;
        List<House> objects;

        public houseMenuArrayAdapter(Context context, int resource, List<House> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            House house = objects.get(position);

            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.house_menu_item, null);

            TextView tvHouseName = (TextView)view.findViewById(R.id.houseName);
            tvHouseName.setText(house.getHouseName());

            TextView tvHouseSummary = (TextView)view.findViewById(R.id.houseSummary);
            tvHouseSummary.setText(house.getHouseSummary());

            ImageView ivHouse = (ImageView)view.findViewById(R.id.imageView);
            //Log.d("houseResource","thmb_"+house.getId());
            int res = context.getResources().getIdentifier(
                    "thmb_" + house.getId(), "drawable", context.getPackageName()
            );
            ivHouse.setImageResource(res);

            return view;
        }
    }
}
