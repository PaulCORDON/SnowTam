package com.ensim.projetsnowtam;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ensim.projetsnowtam.service.AirportResult;

import java.util.ArrayList;

public class SnowtamActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SnowtamFragmentAdapter adapter;
    private ArrayList<AirportResult> listAirportResult = new ArrayList<AirportResult>();
    private Integer index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam);
        viewPager = findViewById(R.id.pager);
        adapter = new SnowtamFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent != null){
            listAirportResult = intent.getParcelableArrayListExtra("listAirPort");
            index = intent.getIntExtra("index",0);
        }


    }
}
