package com.ensim.projetsnowtam;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ensim.projetsnowtam.service.AirportResult;
import com.ensim.projetsnowtam.service.Parametre;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SnowtamActivity extends FragmentActivity {
    private static final String TAG = "SnowtamActivity";
    private ViewPager viewPager;
    private SnowtamFragmentAdapter adapter;
    private ArrayList<AirportResult> listAirportResult = new ArrayList<AirportResult>();
    private Integer index = 0;
    public Parametre parametre = new Parametre("",false,false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam);

        try {
            FileInputStream fis = openFileInput("Param.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            parametre = (Parametre) ois.readObject();
            Log.d("Param de base recup: ",""+ parametre.isChoixAffichage() + parametre.isChoixDecryptage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        if (intent != null){
            listAirportResult = intent.getParcelableArrayListExtra("listAirPort");
            index = intent.getIntExtra("index",0);
            Log.d(TAG,"nombre d'aéroports : "+listAirportResult.size());


        }
        viewPager = findViewById(R.id.pager);
        adapter = new SnowtamFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }




    private class SnowtamFragmentAdapter extends FragmentStatePagerAdapter {
        public SnowtamFragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        /*On instancie le fragment selon la position dans le swipe*/
        @Override
        public Fragment getItem(int position) {

            return SnowtamFragment.newInstance(listAirportResult.get((position+index)%listAirportResult.size()).getICAO_Code(),listAirportResult.get((position+index)%listAirportResult.size()).getSnowtam(),listAirportResult.get((position+index)%listAirportResult.size()).getSnowtamDecoded(),listAirportResult.get((position+index)%listAirportResult.size()).getLatitude(),listAirportResult.get((position+index)%listAirportResult.size()).getLongitude(),parametre);
        }
        /*On retourne le nombre de fragments qui est égual au nombre d'aéroport*/
        @Override
        public int getCount() {
            Log.d(TAG,"nombre de pages : "+listAirportResult.size());
            return listAirportResult.size();
        }
    }

}
