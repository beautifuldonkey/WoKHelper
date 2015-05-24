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

    TextView unitName;
    TextView unitTitle;
    TextView defOne;
    TextView defTwo;
    TextView defThree;
    TextView defFour;
    TextView defFive;
    TextView defSix;
    TextView defSeven;
    TextView defEight;
    TextView defNine;
    TextView defTen;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_details);
        Context context = getApplicationContext();

        //int cardId = getIntent().getIntExtra(CardDetail.CARD_ID, 0);
        Card card = getIntent().getParcelableExtra("CARD");
        displayCard(card);
    }

    protected void displayCard(Card card){

        unitName = (TextView) findViewById(R.id.unitName);
        unitName.setText(card.getName());


        unitTitle = (TextView) findViewById(R.id.unitTitle);
        unitTitle.setText(card.getTitle());

        defOne = (TextView) findViewById(R.id.defOne);
        defOne.setText(card.getDefOne());

        defTwo = (TextView) findViewById(R.id.defTwo);
        defTwo.setText(card.getDefTwo());

        defThree = (TextView) findViewById(R.id.defThree);
        defThree.setText(card.getDefThree());

        defFour = (TextView) findViewById(R.id.defFour);
        defFour.setText(card.getDefFour());

        defFive = (TextView) findViewById(R.id.defFive);
        defFive.setText(card.getDefFive());

        defSix = (TextView) findViewById(R.id.defSix);
        defSix.setText(card.getDefSix());

        defSeven = (TextView) findViewById(R.id.defSeven);
        defSeven.setText(card.getDefSeven());

        defEight = (TextView) findViewById(R.id.defEight);
        defEight.setText(card.getDefEight());

        defNine = (TextView) findViewById(R.id.defNine);
        defNine.setText(card.getDefNine());

        defTen = (TextView) findViewById(R.id.defTen);
        defTen.setText(card.getDefTen());
    }
}
