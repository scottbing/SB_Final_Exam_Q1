package com.android.sb_final_question_one;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText word1;
    private EditText word2;
    private EditText word3;
    private Button submit;
    private String output;
    private String reqUrl = "http://rhymebrain.com/talk?";    // call rhymebrain
    private static final String REQUEST_METHOD_GET = "GET";
    private static final String TAG_HTTP_URL_CONNECTION = "HTTP_URL_CONNECTION";
    private static final int MAX_RESULTS = 100;

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

    // establish syllable arrays for word #2
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
        setContentView(R.layout.activity_main);

        // connect XML to code
        word1 = (EditText) findViewById(R.id.word1);
        word2 = (EditText) findViewById(R.id.word2);
        word3 = (EditText) findViewById(R.id.word3);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                processWords();

            }
        });

    }

    private void processWords() {
        String word01, word02, word03;

        // get user input
        word01 = word1.getText().toString();
        startSendHttpRequestThread(word01, '1');
        //parseJSON(output,'1');

        /*word02 = word2.getText().toString();
        startSendHttpRequestThread(word02);
        parseJSON(output,'2');

        word03 = word3.getText().toString();
        startSendHttpRequestThread(word03);
        parseJSON(output,'3');*/

        // words successfully acquired - verified in debugger - sbing


    }

    /* Start a thread to send http request to web server use HttpURLConnection object. */
    private void startSendHttpRequestThread(final String word, char whichWord)
    {
        final char which = whichWord;
        Thread sendHttpRequestThread = new Thread()
        {
            @Override
            public void run() {
                // using Panel 7.2.21 as a model- The Movie API

                //make empty URL and connection
                URL url;
                HttpURLConnection ur1Connection = null; //HttpsURLConnection aiso avaitab1e
                try {

                    String service = "https://rhymebrain.com/talk?";    // call rhymebrain
                    //String parm = "getRhymes&word=" + word;
                    //String queryString = URLEncoder.encode(parm, "UTF-8");
                    String queryString = "getRhymes&word=" + word + "&maxResults=" + String.valueOf(MAX_RESULTS);
                    //try to process url and connect to it
                    url = new  URL( service +  "function=" + queryString);
                    ur1Connection = (HttpURLConnection)url.openConnection();
                    ur1Connection.setRequestMethod("GET");

                    // Set connection timeout and read timeout value.
                    ur1Connection.setConnectTimeout(70000);
                    ur1Connection.setReadTimeout(70000);

                    //create an input stream and stream reader from the connection
                    InputStream inputStream = ur1Connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                    //get some data from the stream
                    int data = inputStreamReader.read();
                    //string for collecting all output
                    output = "";
                    //if the stream is not empty
                    while(data != -1) {
                        //turn what we read into a char and print it
                        char current = (char) data;
                        output += current;
                        data = inputStreamReader.read();

                        //Log.d("Network", output);
                    }
                    Log.d("Network", output);
                    parseJSON(output, which);
                    int i =0;
                }catch (Exception e) {
                    Log.d( "Network", e.toString());
                }finally {
                    if (ur1Connection != null) {
                        ur1Connection.disconnect();
                        ur1Connection = null;
                    }
                }
            }

        };
        // Start the child thread to request web page.
        sendHttpRequestThread.start();
    }

    private void parseJSON(String rhymeJSON, char whichWord) {
        try {
            String word;
            String numOfSyllables;

            // process JSON rhyming word list
            JSONArray jsonArray = new JSONArray(rhymeJSON);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject wordListObject = jsonArray.getJSONObject(i);
                word = wordListObject.getString("word");
                numOfSyllables = wordListObject.getString("syllables");

                // word1?
                if (whichWord == '1') {
                    switch (numOfSyllables) {
                        case "1":
                            word1_one_syllable.add(word);
                            break;
                        case "2":
                            word1_two_syllable.add(word);
                            break;
                        case "3":
                            word1_three_syllable.add(word);
                            break;
                        case "4":
                            word1_four_syllable.add(word);
                            break;
                        case "5":
                            word1_five_syllable.add(word);
                            break;
                        case "6":
                            word1_six_syllable.add(word);
                            break;
                        case "7":
                            word1_seven_syllable.add(word);
                            break;
                        default:
                            // throw it away
                            break;
                    }

                }

                // word2 ?
                if (whichWord == '2') {
                    switch (numOfSyllables) {
                        case "1":
                            word2_one_syllable.add(word);
                            break;
                        case "2":
                            word2_two_syllable.add(word);
                            break;
                        case "3":
                            word2_three_syllable.add(word);
                            break;
                        case "4":
                            word2_four_syllable.add(word);
                            break;
                        case "5":
                            word2_five_syllable.add(word);
                            break;
                        case "6":
                            word2_six_syllable.add(word);
                            break;
                        case "7":
                            word2_seven_syllable.add(word);
                            break;
                        default:
                            // throw it away
                            break;
                    }
                }

                // word3 ?
                if (whichWord == '3') {
                    switch (numOfSyllables) {
                        case "1":
                            word3_one_syllable.add(word);
                            break;
                        case "2":
                            word3_two_syllable.add(word);
                            break;
                        case "3":
                            word3_three_syllable.add(word);
                            break;
                        case "4":
                            word3_four_syllable.add(word);
                            break;
                        case "5":
                            word3_five_syllable.add(word);
                            break;
                        case "6":
                            word3_six_syllable.add(word);
                            break;
                        case "7":
                            word3_seven_syllable.add(word);
                            break;
                        default:
                            // throw it away
                            break;
                    }

                }
            }
            int i = 0;
            makeHaiku();
            Intent passData = new Intent(getApplicationContext(), HaikuActivity.class);
            Bundle b = new Bundle();
            b.putStringArrayList("word3_four_syllable", word3_four_syllable);
            //b.putDouble("longitude", longitude);
            passData.putExtras(b);
            startActivity(passData);

        } catch (JSONException e) {
            Log.d("MainActivity", e.toString());
            int i =0;
        }
    }

    private void makeHaiku() {

        int two_size = word1_two_syllable.size();
        int three_size = word1_three_syllable.size();
        int four_size = word1_four_syllable.size();
        int five_size = word1_five_syllable.size();

    }
}