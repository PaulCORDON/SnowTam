package com.ensim.projetsnowtam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.ensim.projetsnowtam.service.Parametre;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ParamActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Parametre param;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        Button sauvegarde = (Button) findViewById(R.id.save);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.langues, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Switch mapSwitch = (Switch) findViewById(R.id.MapFirst);
        Switch crypt = (Switch) findViewById(R.id.rawOrNot);



        sauvegarde.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                FileOutputStream outputStream;
                ObjectOutputStream oos;
                try {
                    outputStream = openFileOutput("Param.txt", Context.MODE_PRIVATE);
                    oos = new ObjectOutputStream(outputStream);
                    oos.writeObject(param);

                    oos.flush();
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intentParam = new Intent(ParamActivity.this,MainActivity.class);
                startActivity(intentParam);
            }
        });

    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Log.d("Selected langage",parent.getItemIdAtPosition(pos)+" selectionné");
        switch((int)parent.getItemIdAtPosition(pos)){
            case 0:
                param.setLangue("English");
                break;
            case 1:
                param.setLangue("Français");
                break;
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
