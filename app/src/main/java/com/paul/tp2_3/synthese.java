package com.paul.tp2_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Paul on 28/02/2017.
 */

public class synthese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synthese);

        TextView test = (TextView)findViewById(R.id.textView);
        TextView test2 = (TextView)findViewById(R.id.textView2);

        String newString, newString2;

            Bundle extras = getIntent().getExtras();
                newString= extras.getString("nom");
                newString2= extras.getString("prenom");
                test.setText(newString);
                test2.setText(newString2);
        }
    }