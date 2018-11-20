package com.ensim.projetsnowtam;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ensim.projetsnowtam.service.AirportResult;

import java.util.ArrayList;

public class SnowtamActivity extends AppCompatActivity {
    private ArrayList<AirportResult> listAirportResult = new ArrayList<AirportResult>();
    private Integer index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam);
        Intent intent = getIntent();
        if (intent != null){
            listAirportResult = intent.getParcelableArrayListExtra("listAirPort");
            index = intent.getIntExtra("index",0);
        }


        final Button decodedBtn = (Button) findViewById(R.id.decodeBtn);
        final Button rawBtn = (Button)findViewById(R.id.brutBtn);

        final TextView title =(TextView) findViewById(R.id.title);
        final TextView decodeText = (TextView) findViewById(R.id.textDecoded);
        final TextView rawText = (TextView) findViewById(R.id.textRaw);

        final ConstraintLayout constraintLayout =(ConstraintLayout) findViewById(R.id.constraint);



        title.setText(listAirportResult.get(index).getICAO_Code());


        decodedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.VISIBLE);
                rawText.setVisibility(View.GONE);
            }
        });
        rawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.GONE);
                rawText.setVisibility(View.VISIBLE);
            }
        });
    }
}
