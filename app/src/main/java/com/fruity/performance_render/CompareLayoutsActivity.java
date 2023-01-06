package com.fruity.performance_render;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class CompareLayoutsActivity extends AppCompatActivity {

    protected static final String TAG = "CompareLayoutActivity";

    ImageView chat_author_avatar1;
    ImageView chat_author_avatar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_layouts);
    }
}