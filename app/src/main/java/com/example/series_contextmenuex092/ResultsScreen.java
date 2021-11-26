package com.example.series_contextmenuex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsScreen extends AppCompatActivity implements View.OnCreateContextMenuListener{
    ListView items;
    TextView chosen;
    Intent toFirst;
    double fOrgan, srm;
    double[] numbers = new double[20];
    double[] sum = new double[20];
    boolean oSeries;
    int pos = 0;
    String[] organs = new String[20];
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        items = (ListView) findViewById(R.id.items);
        chosen = (TextView) findViewById(R.id.chosen);
        toFirst = getIntent();

        fOrgan = toFirst.getDoubleExtra("fOrgan", 0);
        srm = toFirst.getDoubleExtra("srm", 0);
        oSeries = toFirst.getBooleanExtra("oSeries", true);

        numbers[0] = fOrgan;
        organs[0] = String.valueOf(numbers[0]);
        sum[0] = numbers[0];
        if (oSeries == false) {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] + srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i - 1] + numbers[i];
            }
        } else {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] * srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i - 1] + numbers[i];
            }
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,organs);
        items.setAdapter(adp);

        items.setOnCreateContextMenuListener(this);

    }

    public void goBack(View view) {
        finish();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        pos = menuInfo.
        menu.add("Location");
        menu.add("Sum");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, pos, Toast.LENGTH_LONG).show();

        //String st = item.getText().toString();
        //float num = Float.parseFloat(st);
        // if item(pos).equals("")
        if (pos == 1) {
            Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
        }

        String st = item.getTitle().toString();
        if (st.equals("Sum")) {
            Toast.makeText(this,"Did not enter text!", Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }

}
