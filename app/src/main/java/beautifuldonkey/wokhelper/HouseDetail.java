package beautifuldonkey.wokhelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HouseDetail extends ActionBarActivity {

    protected String houseName;
    protected String houseDesc;
    protected String houseSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_details);

        houseName = getIntent().getStringExtra(HouseChooser.HOUSE_NAME);
        TextView houseDetailTitle = (TextView) findViewById(R.id.houseDetailTitle);
        houseDetailTitle.setText(houseName);

        houseDesc = getIntent().getStringExtra(HouseChooser.HOUSE_DESC);
        TextView houseDetailDesc = (TextView) findViewById(R.id.houseDescription);
        houseDetailDesc.setText(houseDesc);
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
}
