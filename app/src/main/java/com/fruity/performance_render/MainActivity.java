package com.fruity.performance_render;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * The main activity for the part of the course dealing with rendering performance. Works
 * simply as a table of contents: surfaces buttons that launch the ChatumLatinum and DroidCards
 * activities.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup activityContainer = (ViewGroup) findViewById(R.id.activity_main_container);

        addButton(ChatumLatinumActivity.class,
                getString(R.string.title_activity_chatum_latinum), activityContainer);
    }

    private void addButton(final Class destination, String description, ViewGroup parent) {
        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent problemIntent = new Intent(MainActivity.this, destination);
                startActivity(problemIntent);
            }
        });
        button.setText(description);
        parent.addView(button);
    }


}