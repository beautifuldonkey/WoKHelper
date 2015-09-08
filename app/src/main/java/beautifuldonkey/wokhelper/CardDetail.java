package beautifuldonkey.wokhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        displayCard(card, context);

        ListView unitAbilities = (ListView) findViewById(R.id.abilityList);
        ArrayAdapter<Ability> abilityArrayAdapter = new AbilityArrayAdapter(this,0, abilities);
        unitAbilities.setAdapter(abilityArrayAdapter);
    }

    protected void displayCard(Card card, Context context){

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
//        defOne.setText(card.getDefOne());
        defOne.setText("1: ");
        ImageView iconOne = (ImageView) findViewById(R.id.defOneIcon);
        int iconOneRes = context.getResources().getIdentifier(
                "icon_"+card.getDefOne().toLowerCase(),"drawable",context.getPackageName());
        iconOne.setImageResource(iconOneRes);

        defTwo = (TextView) findViewById(R.id.defTwo);
//        defTwo.setText(card.getDefTwo());
        defTwo.setText("2: ");
        ImageView iconTwo = (ImageView) findViewById(R.id.defTwoIcon);
        int iconTwoRes = context.getResources().getIdentifier(
                "icon_"+card.getDefTwo().toLowerCase(),"drawable",context.getPackageName());
        iconTwo.setImageResource(iconTwoRes);

        defThree = (TextView) findViewById(R.id.defThree);
//        defThree.setText(card.getDefThree());
        defThree.setText("3: ");
        ImageView iconThree = (ImageView) findViewById(R.id.defThreeIcon);
        int iconThreeRes = context.getResources().getIdentifier(
                "icon_"+card.getDefThree().toLowerCase(),"drawable",context.getPackageName());
        iconThree.setImageResource(iconThreeRes);

        defFour = (TextView) findViewById(R.id.defFour);
//        defFour.setText(card.getDefFour());
        defFour.setText("4: ");
        ImageView iconFour = (ImageView) findViewById(R.id.defFourIcon);
        int iconFourRes = context.getResources().getIdentifier(
                "icon_"+card.getDefFour().toLowerCase(),"drawable",context.getPackageName());
        iconFour.setImageResource(iconFourRes);

        defFive = (TextView) findViewById(R.id.defFive);
//        defFive.setText(card.getDefFive());
        defFive.setText("5: ");
        ImageView iconFive = (ImageView) findViewById(R.id.defFiveIcon);
        int iconFiveRes = context.getResources().getIdentifier(
                "icon_"+card.getDefFive().toLowerCase(),"drawable",context.getPackageName());
        iconFive.setImageResource(iconFiveRes);

        defSix = (TextView) findViewById(R.id.defSix);
//        defSix.setText(card.getDefSix());
        defSix.setText("6: ");
        ImageView iconSix = (ImageView) findViewById(R.id.defSixIcon);
        int iconSixRes = context.getResources().getIdentifier(
                "icon_"+card.getDefSix().toLowerCase(),"drawable",context.getPackageName());
        iconSix.setImageResource(iconSixRes);

        defSeven = (TextView) findViewById(R.id.defSeven);
//        defSeven.setText(card.getDefSeven());
        defSeven.setText("7: ");
        ImageView iconSeven = (ImageView) findViewById(R.id.defSevenIcon);
        int iconSevenRes = context.getResources().getIdentifier(
                "icon_"+card.getDefSeven().toLowerCase(),"drawable",context.getPackageName());
        iconSeven.setImageResource(iconSevenRes);

        defEight = (TextView) findViewById(R.id.defEight);
//        defEight.setText(card.getDefEight());
        defEight.setText("8: ");
        ImageView iconEight = (ImageView) findViewById(R.id.defEightIcon);
        int iconEightRes = context.getResources().getIdentifier(
                "icon_"+card.getDefEight().toLowerCase(),"drawable",context.getPackageName());
        iconEight.setImageResource(iconEightRes);

        defNine = (TextView) findViewById(R.id.defNine);
//        defNine.setText(card.getDefNine());
        defNine.setText("9: ");
        ImageView iconNine = (ImageView) findViewById(R.id.defNineIcon);
        int iconNineRes = context.getResources().getIdentifier(
                "icon_"+card.getDefNine().toLowerCase(),"drawable",context.getPackageName());
        iconNine.setImageResource(iconNineRes);

        defTen = (TextView) findViewById(R.id.defTen);
//        defTen.setText(card.getDefTen());
        defTen.setText("10: ");
        ImageView iconTen = (ImageView) findViewById(R.id.defTenIcon);
        int iconTenRes = context.getResources().getIdentifier(
                "icon_"+card.getDefTen().toLowerCase(),"drawable",context.getPackageName());
        iconTen.setImageResource(iconTenRes);
    }
}