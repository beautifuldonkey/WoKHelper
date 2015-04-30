package beautifuldonkey.wokhelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import beautifuldonkey.wokhelper.Data.Card;
import beautifuldonkey.wokhelper.Data.DeckBuilder;
import beautifuldonkey.wokhelper.Data.House;


public class HouseChooser extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_chooser);

        List<Card> deck = DeckBuilder.buildDeck();
        List<House> houses = DeckBuilder.getHouseList();

        Iterator<House> houseIterator = houses.iterator();
        Iterator<Card> cardIterator  = deck.iterator();

        StringBuilder builder = new StringBuilder();

        while(houseIterator.hasNext()){
            House house = houseIterator.next();
            builder.append(house.getHouseName()+":"+house.getHouseDescription())
                    .append("\n");
        }

        TextView tv = (TextView) findViewById(R.id.cards);
        tv.setText(builder.toString());
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
}
