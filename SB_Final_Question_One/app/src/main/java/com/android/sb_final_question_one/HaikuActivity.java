package com.android.sb_final_question_one;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HaikuActivity extends AppCompatActivity {

    // establish syllable arrays for word #1
    private ArrayList<String> word1_one_syllable = new ArrayList<String>();
    private ArrayList<String> word1_two_syllable = new ArrayList<String>();
    private ArrayList<String> word1_three_syllable = new ArrayList<String>();
    private ArrayList<String> word1_four_syllable = new ArrayList<String>();
    private ArrayList<String> word1_five_syllable = new ArrayList<String>();
    private ArrayList<String> word1_six_syllable = new ArrayList<String>();
    private ArrayList<String> word1_seven_syllable = new ArrayList<String>();

    // establish syllable arrays for word #2
    private ArrayList<String> word2_one_syllable = new ArrayList<String>();
    private ArrayList<String> word2_two_syllable = new ArrayList<String>();
    private ArrayList<String> word2_three_syllable = new ArrayList<String>();
    private ArrayList<String> word2_four_syllable = new ArrayList<String>();
    private ArrayList<String> word2_five_syllable = new ArrayList<String>();
    private ArrayList<String> word2_six_syllable = new ArrayList<String>();
    private ArrayList<String> word2_seven_syllable = new ArrayList<String>();

    // establish syllable arrays for word #3
    private ArrayList<String> word3_one_syllable = new ArrayList<String>();
    private ArrayList<String> word3_two_syllable = new ArrayList<String>();
    private ArrayList<String> word3_three_syllable = new ArrayList<String>();
    private ArrayList<String> word3_four_syllable = new ArrayList<String>();
    private ArrayList<String> word3_five_syllable = new ArrayList<String>();
    private ArrayList<String> word3_six_syllable = new ArrayList<String>();
    private ArrayList<String> word3_seven_syllable = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haiku);

        Button genHaiku = (Button) findViewById(R.id.haiku);

        // Get the data
        Bundle b = getIntent().getExtras();
        // receive word1 data
        word1_one_syllable = b.getStringArrayList("word1_one_syllable");
        word1_two_syllable = b.getStringArrayList("word1_two_syllable");
        word1_three_syllable = b.getStringArrayList("word1_three_syllable");
        word1_four_syllable = b.getStringArrayList("word1_four_syllable");
        word1_five_syllable = b.getStringArrayList("word1_five_syllable");
        word1_six_syllable = b.getStringArrayList("word1_six_syllable");
        word1_seven_syllable = b.getStringArrayList("word1_seven_syllable");

        // receive word2 data
        word2_one_syllable = b.getStringArrayList("word2_one_syllable");
        word2_two_syllable = b.getStringArrayList("word2_two_syllable");
        word2_three_syllable = b.getStringArrayList("word2_three_syllable");
        word2_four_syllable = b.getStringArrayList("word2_four_syllable");
        word2_five_syllable = b.getStringArrayList("word2_five_syllable");
        word2_six_syllable = b.getStringArrayList("word2_six_syllable");
        word2_seven_syllable = b.getStringArrayList("word2_seven_syllable");

        // receive word3 data
        word3_one_syllable = b.getStringArrayList("word3_one_syllable");
        word3_two_syllable = b.getStringArrayList("word3_two_syllable");
        word3_three_syllable = b.getStringArrayList("word3_three_syllable");
        word3_four_syllable = b.getStringArrayList("word3_four_syllable");
        word3_five_syllable = b.getStringArrayList("word3_five_syllable");
        word3_six_syllable = b.getStringArrayList("word3_six_syllable");
        word3_seven_syllable = b.getStringArrayList("word3_seven_syllable");

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
