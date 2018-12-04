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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParamActivity extends AppCompatActivity  {
    Parametre param;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        try {
            FileInputStream fis = openFileInput("Param.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            param = (Parametre) ois.readObject();
            Log.d("Param de base recup: ",""+ param.isChoixAffichage() + param.isChoixDecryptage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Button sauvegarde = (Button) findViewById(R.id.save);



        final Switch mapSwitch = (Switch) findViewById(R.id.MapFirst);
        final Switch crypt = (Switch) findViewById(R.id.rawOrNot);

        mapSwitch.setChecked(param.isChoixAffichage());
        crypt.setChecked(param.isChoixDecryptage());

        sauvegarde.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                param = new Parametre("FR",mapSwitch.isChecked(),crypt.isChecked());
                Log.d("mapSwitch : ",""+ mapSwitch.isChecked() );
                Log.d("crypt : ",""+ crypt.isChecked());
                FileOutputStream outputStream;
                ObjectOutputStream oos;
                try {
                    outputStream = openFileOutput("Param.txt", Context.MODE_PRIVATE);
                    oos = new ObjectOutputStream(outputStream);
                    oos.writeObject(param);

                    oos.flush();
                    oos.close();
                    Log.d("Saving param","parametres sauvegardés" + param.isChoixAffichage() + param.isChoixDecryptage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intentParam = new Intent(ParamActivity.this,MainActivity.class);
                startActivity(intentParam);
            }
        });

    }





    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
