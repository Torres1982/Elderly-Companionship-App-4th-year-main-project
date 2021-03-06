package com.torres.companionshipapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Name: Map <br>
 * THIS CLASS IS ADDED TO THE FUTURE WORK part.
 * This class allows the user to choose the Event to be shown on Google Map.
 * @author B00073668 Artur Sukiennik
 * @version 1, date: 22.02.2017
 */
public class Map extends AppCompatActivity {

    // Declare global variables and objects
    String spinnerValue;
    Spinner spinner;
    Button showOnMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_places);

        // Get reference of the objects from the friends_finder_hobby_hobby.xml file
        showOnMapButton = (Button)findViewById(R.id.button_show_map);
        spinner = (Spinner) findViewById(R.id.map_spinner);

        // Call the supportive methods
        setUpActionBar();
        setUpSpinner();

        // Call the methods with associated Listeners
        addListenerToShowOnMapButton();
    }

    // *********************************************************************************************
    // ******************** Register Listener for the Show on Map Button ***************************
    // *********************************************************************************************
    public void addListenerToShowOnMapButton () {
        showOnMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {

                // Get the value from the selected dropdown list
                spinnerValue = String.valueOf(spinner.getSelectedItem());

                prepareIntent();
            }
        });
    }

    // *********************************************************************************************
    // ******************** Send intent with the Date Strings to next activity *********************
    // *********************************************************************************************
    public void prepareIntent() {

        String keyEventOnMap = "eventOnMap";

        // Prepare the intent and send the event name to next activity
        Intent eventIntent = new Intent (getApplicationContext(), MapPlaces.class);
        eventIntent.putExtra(keyEventOnMap, spinnerValue);
        startActivity(eventIntent);
        finish();
    }

    // *********************************************************************************************
    // ******************** Set up custom Action Bar title *****************************************
    // ******************** Add a logo to the Action Bar *******************************************
    // *********************************************************************************************
    public void setUpActionBar() {

        ActionBar myCustomActionBar = getSupportActionBar();

        // Disable default Action Bar settings
        myCustomActionBar.setDisplayShowHomeEnabled(false);
        myCustomActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater myLayoutInflater = LayoutInflater.from(this);
        View myCustomView = myLayoutInflater.inflate(R.layout.custom_action_bar, null);

        // Get reference of the object from the action_bar_title.xml file
        TextView myTitleTextView = (TextView) myCustomView.findViewById(R.id.action_bar_title);

        // Set up custom Action Bar
        String actionBarTitle = "Elderly Companionship";
        myTitleTextView.setText(actionBarTitle);
        myCustomActionBar.setCustomView(myCustomView);
        myCustomActionBar.setDisplayShowCustomEnabled(true);
    }

    // *********************************************************************************************
    // ******************** Set up custom Spinner **************************************************
    // ******************** Edit Spinner text size and colors **************************************
    // *********************************************************************************************
    public void setUpSpinner() {

        ArrayAdapter spinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.map_array, R.layout.spinner_edit);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}
