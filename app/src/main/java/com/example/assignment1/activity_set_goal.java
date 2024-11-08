package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class activity_set_goal extends AppCompatActivity {



    Spinner goalSpinner;
    EditText inputField ;
    RadioGroup intensityGroup;
    Button saveGoalButton;
   ListView GoalsListView;

    ArrayList<Goal> goalsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        goalSpinner = findViewById(R.id.goalSpinner);
        inputField = findViewById(R.id.inputField);
        intensityGroup = findViewById(R.id.IntensityGroup);
        saveGoalButton = findViewById(R.id.saveGoalButton);
        GoalsListView = findViewById(R.id.GoalsListView);
        goalsList = new ArrayList<>();
        //intilize
        goalsList.add(new Goal("Meditation", 30, "Intense"));



        String[] goals = {"Exercise", "Meditation", "Water"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, goals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setAdapter(adapter);

    saveGoalButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String selectedGoalType = goalSpinner.getSelectedItem().toString();

            String inputAmount = inputField.getText().toString();
            int numberAmount = inputAmount.isEmpty() ? 0 : Integer.parseInt(inputAmount);

            String selectedIntensity = "None"; // Default value for Water Intake
            if (selectedGoalType.equals("Exercise") || selectedGoalType.equals("Meditation")) {
                int selectedRadioButtonId = intensityGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                selectedIntensity = selectedRadioButton.getText().toString();
            }

            Goal newGoal = new Goal(selectedGoalType, numberAmount, selectedIntensity);

            goalsList.add(newGoal);

            Toast.makeText(activity_set_goal.this, "Goal Saved" , Toast.LENGTH_SHORT).show();


            ArrayList<String> Goals = new ArrayList<>();

            for (Goal goal : goalsList) {
                String unit = goal.getType().equalsIgnoreCase("Water") ? "cups" : "mins";
                Goals.add(goal.getType() + " - " + goal.getNumber() + " " + unit + " - " + goal.getIntensity());
            }

            ArrayAdapter<String> goalsAdapter = new ArrayAdapter<>(activity_set_goal.this, android.R.layout.simple_list_item_1, Goals);

            GoalsListView.setAdapter(goalsAdapter);





        }
    });





    }









}