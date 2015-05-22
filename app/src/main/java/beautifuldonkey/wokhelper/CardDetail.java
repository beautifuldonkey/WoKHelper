package beautifuldonkey.wokhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import beautifuldonkey.wokhelper.Data.Card;

/**
 * Created by Jed on 5/19/2015.
 */
public class CardDetail extends ActionBarActivity {

    public static final String CARD_ID = "card_id";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_details);
        Context context = getApplicationContext();

        //int cardId = getIntent().getIntExtra(CardDetail.CARD_ID, 0);
        Card card = getIntent().getParcelableExtra("CARD");

        TextView dispUnitName = (TextView) findViewById(R.id.unitName);
        dispUnitName.setText("id:"+card.getId()+" name:"+card.getName()+" title:"+card.getTitle());

    }
}
