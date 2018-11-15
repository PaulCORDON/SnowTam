package com.ensim.projetsnowtam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ensim.projetsnowtam.service.ApiService;
import com.ensim.projetsnowtam.service.DataSearchAirportLocation;
import com.ensim.projetsnowtam.service.DataSearchAirportSnowtam;
import com.google.android.gms.common.SignInButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public int nbrAirport = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search = (Button)findViewById(R.id.searchBtn);


        final EditText airport1 = (EditText) findViewById(R.id.airport1);
        final EditText airport2 = (EditText) findViewById(R.id.airport2);
        final EditText airport3 = (EditText) findViewById(R.id.airport3);
        final EditText airport4 = (EditText) findViewById(R.id.airport4);
        final EditText airport5 = (EditText) findViewById(R.id.airport5);
        final EditText airport6 = (EditText) findViewById(R.id.airport6);


        final ImageView close2 = (ImageView) findViewById(R.id.close2);
        final ImageView close3 = (ImageView) findViewById(R.id.close3);
        final ImageView close4 = (ImageView) findViewById(R.id.close4);
        final ImageView close5 = (ImageView) findViewById(R.id.close5);
        final ImageView close6 = (ImageView) findViewById(R.id.close6);



        final Button ajout = (Button) findViewById(R.id.Ajouter);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<String> listAirport = new ArrayList<String>();
                listAirport.add("ENBO");
                for (String codeICAO:listAirport) {
                   /* Response.Listener<DataSearchAirportSnowtam> responseListener = new Response.Listener<DataSearchAirportSnowtam>() {
                        @Override
                        public void onResponse(DataSearchAirportSnowtam response) {
                            Log.d(TAG,response.getData().get(response.getData().size()-1).getAll());

                        }
                    };
                    Response.ErrorListener errorListener=new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG,"VolleyError");
                        }
                    };
                    ApiService.INSTANCE.searchAirportSnowtam(Uri.encode(codeICAO), responseListener, errorListener,MainActivity.this);

*/


                    Response.Listener<DataSearchAirportLocation> responseListener = new Response.Listener<DataSearchAirportLocation>() {
                        @Override
                        public void onResponse(DataSearchAirportLocation response) {
                            Log.d(TAG,response.getData().get(response.getData().size()-1).getLocation_Name());

                        }
                    };
                    Response.ErrorListener errorListener=new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG,"VolleyError");
                        }
                    };
                    ApiService.INSTANCE.searchAirportLocation(Uri.encode(codeICAO), responseListener, errorListener,MainActivity.this);
                }




                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbrAirport ++;
                Log.w("ajout" , "on ajoute un aeroport" + nbrAirport);
                if (nbrAirport == 2){
                    airport2.setVisibility(View.VISIBLE);
                    close2.setVisibility(View.VISIBLE);
                }
                if (nbrAirport == 3){
                    airport3.setVisibility(View.VISIBLE);
                    close3.setVisibility(View.VISIBLE);
                }
                if (nbrAirport == 4){
                    airport4.setVisibility(View.VISIBLE);
                    close4.setVisibility(View.VISIBLE);
                }
                if (nbrAirport == 5){
                    airport5.setVisibility(View.VISIBLE);
                    close5.setVisibility(View.VISIBLE);
                }
                if (nbrAirport == 6){
                    airport6.setVisibility(View.VISIBLE);
                    close6.setVisibility(View.VISIBLE);
                    ajout.setVisibility(View.INVISIBLE);
                }
            }
        });
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                if (nbrAirport == 2){
                    nbrAirport --;
                    airport2.setVisibility(View.GONE);
                    close2.setVisibility(View.GONE);
                }
                if (nbrAirport == 3 ){
                    nbrAirport --;
                    airport3.setVisibility(View.GONE);
                    close3.setVisibility(View.GONE);
                    airport2.setText(airport3.getText());
                }
                if (nbrAirport == 4 ){
                    nbrAirport --;
                    airport4.setVisibility(View.GONE);
                    close4.setVisibility(View.GONE);
                    airport2.setText(airport3.getText());
                    airport3.setText(airport4.getText());
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    airport2.setText(airport3.getText());
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    airport2.setText(airport3.getText());
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                    airport5.setText(airport6.getText());
                    ajout.setVisibility(View.VISIBLE);
                }
            }

        });

        close3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                if (nbrAirport == 3){
                    nbrAirport --;
                    airport3.setVisibility(View.GONE);
                    close3.setVisibility(View.GONE);
                }
                if (nbrAirport == 4 ){
                    nbrAirport --;
                    airport4.setVisibility(View.GONE);
                    close4.setVisibility(View.GONE);
                    airport3.setText(airport4.getText());
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                    airport5.setText(airport6.getText());
                    ajout.setVisibility(View.VISIBLE);
                }
            }
        });

        close4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                if (nbrAirport == 4){
                    nbrAirport --;
                    airport4.setVisibility(View.GONE);
                    close4.setVisibility(View.GONE);
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    airport4.setText(airport5.getText());
                    airport5.setText(airport6.getText());
                    ajout.setVisibility(View.VISIBLE);
                }
            }
        });

        close5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                if (nbrAirport == 5){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    airport5.setText(airport6.getText());
                    ajout.setVisibility(View.VISIBLE);
                }

            }
        });
        close6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                airport5.setVisibility(View.GONE);
                close5.setVisibility(View.GONE);
                ajout.setVisibility(View.VISIBLE);
            }
        });
    }
}
