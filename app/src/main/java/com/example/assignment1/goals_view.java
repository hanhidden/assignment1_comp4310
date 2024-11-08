package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class goals_view extends AppCompatActivity {

    private ListView goalTypesListView;
    private ListView filteredGoalsListView;
    private ArrayList<Goal> goalsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_view);

        goalTypesListView = findViewById(R.id.goalTypesListView);
        filteredGoalsListView = findViewById(R.id.filteredGoalsListView);

        initializeGoalsList();

        String[] goalTypes = {"Exercise", "Meditation", "Water", "All"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, goalTypes);
        goalTypesListView.setAdapter(adapter);

        goalTypesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedGoalType = goalTypes[position];
                displayFilteredGoals(selectedGoalType);
            }
        });
    }

    private void initializeGoalsList() {
        goalsList = new ArrayList<>();
        goalsList.add(new Goal("Exercise", 30, "Easy"));
        goalsList.add(new Goal("Meditation", 20, "Medium"));
        goalsList.add(new Goal("Water", 8, "None"));
        goalsList.add(new Goal("Exercise", 70, "Easy"));
        goalsList.add(new Goal("Meditation", 30, "Intense"));
        goalsList.add(new Goal("Water", 3, "None"));
    }

    private void displayFilteredGoals(String goalType) {
        ArrayList<String> filteredGoals = new ArrayList<>();

        for (Goal goal : goalsList) {
            if (goalType.equals("All") || goal.getType().equalsIgnoreCase(goalType)) {
                String unit = goal.getType().equalsIgnoreCase("Water") ? "cups" : "mins";
                filteredGoals.add(goal.getType() + " - " + goal.getNumber() + " " + unit + " - " + goal.getIntensity());
            }
        }

        ArrayAdapter<String> filteredAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredGoals);
        filteredGoalsListView.setAdapter(filteredAdapter);
    }

}
