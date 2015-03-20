//Brenna Pavlinchak 3/16/15

package com.example.ravenmargret.java1project3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{
    Context mContext;
    TextView nameOfVacation;
    TextView location;
    ListView listView;
    Spinner horizontalSpinner;
    ArrayAdapter<String> spinnerAdapter;
    ArrayList <String> showing = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        listView = (ListView)findViewById(R.id.listView);
        nameOfVacation = (TextView)findViewById(R.id.vacationText);
        location = (TextView)findViewById(R.id.locationText);

        final ArrayList<Vacations> vacation = new ArrayList<Vacations>();
        if(vacation !=null)
        {
            vacation.add(new Vacations("Yasawa Island", "Fiji", "Spa", "Island"));
            vacation.add(new Vacations("Lizard Island", "Australia", "Luxury", "Island"));
            vacation.add(new Vacations("Kahala", "Oahu", "Luxury", "Island"));
            vacation.add(new Vacations("The Sebastian-Vail", "Colorado", "Ski Resort", "Mountains"));
            vacation.add(new Vacations("Royal Pacific Resort", "Florida", "Family-Friendly resort", "Beach"));
            vacation.add(new Vacations("Jade Mountain", "St. Lucia", "Sanctuary", "Beach"));
            vacation.add(new Vacations("The Edgewater", "Wisconsin", "Luxury", "Lake"));
            vacation.add(new Vacations("Lotus Pond", "Thailand", "Luxury", "Beach"));
            vacation.add(new Vacations("Samoset Resort", "Portland", "Casual", "Golf Course"));
            vacation.add(new Vacations("La Valencia", "Hotel in La Jolla", "Luxury", "Beach"));
            vacation.add(new Vacations("The Royal Park Hotel", "Hyde Park", "Getaway", "City"));
            vacation.add(new Vacations("Disney World", "Florida", "Family-Fun Theme Park", "Theme Park"));
            vacation.add(new Vacations("Discovery Cove", "Florida", "Water Discovery", "Theme Park"));
        }

        ListView theListView = (ListView)findViewById(R.id.listView);
        Adapter theAdaptor = new Adapter(MainActivity.this, vacation);
        theListView.setAdapter(theAdaptor);

        LinearLayout portrait = (LinearLayout)findViewById(R.id.landscapeView); //Setting for the hide or view
        RelativeLayout landscape = (RelativeLayout)findViewById(R.id.portraitView);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            portrait.setVisibility(View.VISIBLE);
            landscape.setVisibility(View.GONE);
            horizontalSpinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerArray, android.R.layout.simple_dropdown_item_1line);
            horizontalSpinner.setAdapter(spinnerAdapter);

            horizontalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    nameOfVacation.setText(vacation.get(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            portrait.setVisibility(View.GONE);
            landscape.setVisibility(View.VISIBLE);

            theListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    String selectedItem = vacation.get(position).toString();
                    location.setText(selectedItem + "");
                }
            });
        }

    }

}

