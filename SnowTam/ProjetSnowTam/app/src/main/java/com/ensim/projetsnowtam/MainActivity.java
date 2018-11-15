package com.ensim.projetsnowtam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ensim.projetsnowtam.service.ApiService;
import com.ensim.projetsnowtam.service.DataSearchAirportSnowtam;
import com.google.android.gms.common.SignInButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search = (Button)findViewById(R.id.searchBtn);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<String> listAirport = new ArrayList<String>();
                listAirport.add("ENBO");
                for (String codeICAO:listAirport) {
                    Response.Listener<DataSearchAirportSnowtam> responseListener = new Response.Listener<DataSearchAirportSnowtam>() {
                        @Override
                        public void onResponse(DataSearchAirportSnowtam response) {
                            Log.d(TAG,response.toString());

                        }
                    };
                    Response.ErrorListener errorListener=new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG,"VolleyError");
                        }
                    };
                    ApiService.INSTANCE.searchAirportSnowtam(Uri.encode(codeICAO), responseListener, errorListener,MainActivity.this);

                }




                /*Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);*/
            }
        });
    }
}
