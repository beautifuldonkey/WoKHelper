package beautifuldonkey.wokhelper;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;


public class HouseDetail extends ActionBarActivity {

    protected String houseName;
    protected String houseDesc;
    protected String houseSummary;
    public Button units;
    public Button description;
    protected List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_details);
        Context context = getApplicationContext();
        cards = DeckBuilder.buildDeck();
        final ArrayAdapter<Card> cardArrayAdapter = new cardArrayAdapter(this, 0, cards);

        houseName = getIntent().getStringExtra(HouseChooser.HOUSE_NAME);
        TextView houseDetailTitle = (TextView) findViewById(R.id.houseDetailTitle);
        houseDetailTitle.setText(houseName);

        houseDesc = getIntent().getStringExtra(HouseChooser.HOUSE_DESC);
        final TextView houseDetailDesc = (TextView) findViewById(R.id.houseDescription);
        houseDetailDesc.setText(houseDesc);

        ImageView houseImage = (ImageView) findViewById(R.id.houseDetailImage);
        int houseId = getIntent().getIntExtra(HouseChooser.HOUSE_ID, 0);
        int res = context.getResources().getIdentifier("thmb_" + houseId,"drawable", context.getPackageName());
        houseImage.setImageResource(res);

        units = (Button) findViewById(R.id.btnUnits);
        units.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                houseDetailDesc.setText("");
                //TODO display units list
                ListView houseUnits = (ListView) findViewById(R.id.houseUnits);
                houseUnits.setAdapter(cardArrayAdapter);

            }
        });

        description = (Button) findViewById(R.id.btnDescription);
        description.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                houseDetailDesc.setText(houseDesc);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_house_detail, menu);
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

    class cardArrayAdapter extends ArrayAdapter<Card>{

        Context context;
        List<Card> objects;

        public cardArrayAdapter(Context context, int resource, List<Card> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Card card = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.unit_summary,null);

            TextView tvUnitName = (TextView) view.findViewById(R.id.unitName);
            tvUnitName.setText(card.getName());

            TextView tvUnitTitle = (TextView) view.findViewById(R.id.unitTitle);
            tvUnitTitle.setText(card.getTitle());

            ImageView unitImage = (ImageView) view.findViewById(R.id.unitSummaryImage);
            int res = context.getResources().getIdentifier("thmb_0","drawable",context.getPackageName());
            unitImage.setImageResource(res);

            return view;
        }
    }

}
