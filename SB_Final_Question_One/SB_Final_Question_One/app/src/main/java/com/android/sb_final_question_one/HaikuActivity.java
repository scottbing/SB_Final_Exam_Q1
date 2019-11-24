package com.android.sb_final_question_one;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HaikuActivity extends AppCompatActivity {

    private ArrayList<String> word1_four_syllable = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haiku);

        Button genHaiku = (Button) findViewById(R.id.haiku);

        // Get the data
        Bundle b = getIntent().getExtras();
        word1_four_syllable = b.getStringArrayList("word1_four_syllable");
        /*double lat = b.getDouble("latitude");
        double lon = b.getDouble("longitude");*/

        genHaiku.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                generateHaiku();

            }
        });
    }

    // display the haiku on hte sreen
    private void generateHaiku() {

    }

}
