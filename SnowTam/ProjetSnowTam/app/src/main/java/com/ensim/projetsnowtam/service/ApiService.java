package com.ensim.projetsnowtam.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public enum ApiService {
    INSTANCE;
    private static final String TAG = "ApiService";



   public void searchAirportSnowtam(String codeICAO, Response.Listener respListener, Response.ErrorListener errorListener, Context context){
        final String url="https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/states/notams/notams-realtime-list?api_key=6500c590-e67d-11e8-be73-c141bfe5369c&format=json&criticality=&locations="+codeICAO;
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<DataSearchAirportSnowtam> request = new GsonRequest<>(url,DataSearchAirportSnowtam.class,null,respListener,errorListener);
        queue.add(request);

    }


    public void searchAirportLocation(String codeICAO, Response.Listener respListener, Response.ErrorListener errorListener, Context context){
        final String url="https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/airports/locations/doc7910?api_key=6500c590-e67d-11e8-be73-c141bfe5369c&airports="+codeICAO+"&format=json";
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<DataSearchAirportLocation> request = new GsonRequest<>(url,DataSearchAirportLocation.class,null,respListener,errorListener);
        queue.add(request);

    }
}
