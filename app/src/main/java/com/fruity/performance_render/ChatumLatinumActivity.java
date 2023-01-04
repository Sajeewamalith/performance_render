package com.fruity.performance_render;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Displays a fragment that contains a ListView holding several Chat objects. Used in this lesson
 * to show a) how to reduce overdraws, and b) how to flatten needlessly nested hierarchies.
 */
public class ChatumLatinumActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatum_latinum);

        getWindow().setBackgroundDrawable(null);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_chatum_latinum_container, new ChatsFragment())
                    .commit();
        }
    }
}
