package com.example.series_contextmenuex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch sType;
    EditText organF, remMul;
    Button result;
    Intent toResult;
    String textOF, textRM;
    double fOrgan, srm;
    boolean oSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sType = (Switch) findViewById(R.id.sType);
        organF = (EditText) findViewById(R.id.organF);
        remMul = (EditText) findViewById(R.id.remMul);
        result = (Button) findViewById(R.id.result);
        toResult = new Intent(this,ResultsScreen.class);

    }

    public void goResults(View view) {
        textOF = organF.getText().toString();
        textRM = remMul.getText().toString();

        if((textOF.equals(""))&& (textRM.equals("")))
        {
            Toast.makeText(this,"Did not enter text!",Toast.LENGTH_LONG).show();
        }
        else {
            fOrgan = Double.valueOf(textOF);
            srm = Double.valueOf(textRM);
            oSeries = sType.isChecked();
            toResult.putExtra("fOrgan", fOrgan);
            toResult.putExtra("srm", srm);
            toResult.putExtra("oSeries", oSeries);
            startActivity(toResult);}
    }
}