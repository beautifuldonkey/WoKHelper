package beautifuldonkey.wokhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.wokhelper.Adapters.AbilityArrayAdapter;
import beautifuldonkey.wokhelper.Data.Ability;
import beautifuldonkey.wokhelper.Data.AbilityList;
import beautifuldonkey.wokhelper.Data.Card;

/**
 * added to display a selected ard
 * Created by beautifuldonkey on 5/19/2015.
 */
public class CardDetail extends ActionBarActivity {

    public static final String CARD_ID = "card_id";

    TextView unitName;
    TextView unitTitle;
    TextView unitMovement;
    TextView unitAttack;
    TextView unitDefense;
    TextView unitWounds;
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
        setContentView(R.layout.activity_unit_details);
        Context context = getApplicationContext();

        //List<Ability> abilities = AbilityList.getAbilities();

        Card card = getIntent().getParcelableExtra("CARD");
        List<Ability> abilities = AbilityList.getAbilitiesById(card.getAbilities());
        displayCard(card);

        ListView unitAbilities = (ListView) findViewById(R.id.abilityList);
        ArrayAdapter<Ability> abilityArrayAdapter = new AbilityArrayAdapter(this,0, abilities);
        unitAbilities.setAdapter(abilityArrayAdapter);
    }

    protected void displayCard(Card card){

        unitName = (TextView) findViewById(R.id.unitName);
        unitName.setText(card.getName());

        unitTitle = (TextView) findViewById(R.id.unitTitle);
        unitTitle.setText(card.getTitle());

        //Log.d("MOVEMENT:", card.getMovement());
        unitMovement = (TextView) findViewById(R.id.unitMove);
        unitMovement.setText(String.valueOf(card.getMovement()));

        unitAttack = (TextView) findViewById(R.id.unitAttack);
        unitAttack.setText(String.valueOf(card.getAttack()));

        unitDefense = (TextView) findViewById(R.id.unitDefense);
        unitDefense.setText(String.valueOf(card.getDefense()));

        unitWounds = (TextView) findViewById(R.id.unitWounds);
        unitWounds.setText(String.valueOf(card.getWounds()));

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