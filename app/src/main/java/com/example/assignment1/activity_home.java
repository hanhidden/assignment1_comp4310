package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class activity_home extends AppCompatActivity {

    Button setGoalButton;
    Button viewLogsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        setGoalButton = findViewById(R.id.setGoalButton);
        viewLogsButton = findViewById(R.id.viewLogsButton);

        setGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_set_goal.class);
                startActivity(intent);

            }
        });

        viewLogsButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, goals_view.class);
                startActivity(intent);

            }
        });

    }
}