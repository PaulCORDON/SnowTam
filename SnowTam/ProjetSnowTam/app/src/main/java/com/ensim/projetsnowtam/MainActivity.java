package com.ensim.projetsnowtam;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ensim.projetsnowtam.service.AirportResult;
import com.ensim.projetsnowtam.service.ApiService;
import com.ensim.projetsnowtam.service.DataSearchAirportLocation;
import com.ensim.projetsnowtam.service.DataSearchAirportSnowtam;
import com.ensim.projetsnowtam.service.Parametre;
import com.google.android.gms.common.SignInButton;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public int nbrAirport = 1;
    public int[] choixAirport = new int[6];
    private Integer index = 0;
    public Parametre parametre = new Parametre("",false,false);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

         /* liste des aeroport qui sont sur le trajet (à dessiner) */
        final ArrayList<String> listAirport = new ArrayList<String>();
        /* liste des aeroports pour lequelles on veut seulement des informations */
        final ArrayList<String> listAirportInfos = new ArrayList<String>();
        final ArrayList<AirportResult> listAirportResult = new ArrayList<AirportResult>();

        choixAirport[0] = 1;
        choixAirport[1] = 2;
        choixAirport[2] = 3;
        choixAirport[3] = 4;
        choixAirport[4] = 5;
        choixAirport[5] = 6;

    /** Récuperation des parametres si ils y en a déjà eu sur le téléphone. **/
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
        Log.d("Param de base : ",""+ parametre.isChoixAffichage() + parametre.isChoixDecryptage());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search = (Button)findViewById(R.id.searchBtn);

        final ImageView param = (ImageView) findViewById(R.id.param);

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

        final ImageView imgAirport1 = (ImageView) findViewById(R.id.imgAirport1);
        final ImageView imgAirport2 = (ImageView) findViewById(R.id.imgAirport2);
        final ImageView imgAirport3 = (ImageView) findViewById(R.id.imgAirport3);
        final ImageView imgAirport4 = (ImageView) findViewById(R.id.imgAirport4);
        final ImageView imgAirport5 = (ImageView) findViewById(R.id.imgAirport5);
        final ImageView imgAirport6 = (ImageView) findViewById(R.id.imgAirport6);

        final Button ajout = (Button) findViewById(R.id.Ajouter);

        /** Bouton pour acceder aux parametres*/
        param.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intentParam = new Intent(MainActivity.this,ParamActivity.class);
                startActivity(intentParam);
            }
        });


        /** Fonction de recherche **/
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** on nettoie les listes dans le cas où on revis sur cette page */
                listAirport.clear();
                listAirportInfos.clear();
                listAirportResult.clear();
                for(int i = 0;i<nbrAirport;i++){
                    listAirport.add("");
                    Log.d("tableau" ,"value" + choixAirport[i]);
                }

                /** Si les aeroports sont visibles alors on récupere les expressions qui sont à dans les champs */
                if(airport1.getVisibility() == View.VISIBLE ){

                    Log.d("add" , "airport 1 : " + choixAirport[0]);
                    if (choixAirport[0]-1>=nbrAirport){
                        listAirportInfos.add(airport1.getText().toString());
                        Log.d("add" , "airport 1 ");
                    }
                    else{
                        listAirport.set(choixAirport[0]-1,airport1.getText().toString());
                    }

                }
                if(airport2.getVisibility() == View.VISIBLE){

                    Log.d("add" , "airport 2 : " + choixAirport[1]);
                    if (choixAirport[1]-1>=nbrAirport){
                        listAirportInfos.add(airport2.getText().toString());
                        Log.d("add" , "airport 2 ");

                    }
                    else {
                        listAirport.set(choixAirport[1] - 1, airport2.getText().toString());
                    }
                }
                if(airport3.getVisibility() == View.VISIBLE){

                    Log.d("add" , "airport 3 : " + choixAirport[2]);
                    if (choixAirport[2]-1>=nbrAirport){
                        listAirportInfos.add(airport3.getText().toString());
                    }
                    else{
                        listAirport.set(choixAirport[2]-1,airport3.getText().toString());
                    }

                }
                if(airport4.getVisibility() == View.VISIBLE){
                    if (choixAirport[3]-1>=nbrAirport){
                        listAirportInfos.add(airport4.getText().toString());
                    }
                    else {
                        listAirport.set(choixAirport[3]-1,airport4.getText().toString());
                    }

                }
                if(airport5.getVisibility() == View.VISIBLE){
                    if (choixAirport[4]-1>=nbrAirport){
                        listAirportInfos.add(airport5.getText().toString());
                    }
                    else {
                        listAirport.set(choixAirport[4]-1,airport5.getText().toString());}

                }
                if(airport6.getVisibility() == View.VISIBLE){
                    if (choixAirport[5]-1>=nbrAirport){
                        listAirportInfos.add(airport6.getText().toString());
                    }
                    else {
                        listAirport.set(choixAirport[5]-1,airport6.getText().toString());
                    }
                }
                if(listAirport.size()>2){
                    listAirport.add(listAirport.get(1));
                    listAirport.remove(1);

                }

                listAirport.removeAll(Arrays.asList(null,""));
                Log.d("taille tableau", ""+listAirport.size());
                /** affichage vérification du trajet */
                for(String s : listAirport){
                    Log.d("listAirport" , " Airpot trajet : " + s);
                }
                for(String s : listAirportInfos){
                    Log.d("listAirportInfo" , " Airpot Info : " + s);
                }
                final int delimitateur = listAirport.size();
                listAirport.addAll(listAirportInfos);

                /** Pour chaque aeroport, on envoi une requete pour avoir le snowtam et la localisation **/
                for (final String codeICAO:listAirport) {
                    if(!codeICAO.isEmpty()){
                        Response.Listener<DataSearchAirportSnowtam> responseListener = new Response.Listener<DataSearchAirportSnowtam>() {
                            @Override
                            public void onResponse(DataSearchAirportSnowtam response) {
                                if(response.getData().size()>0){
                                    //Log.d(TAG,response.getData().get(response.getData().size()-1).getAll());
                                    listAirportResult.add(new AirportResult());
                                    listAirportResult.get(listAirportResult.size()-1).setSnowtam(response.getData().get(response.getData().size()-1).getAll().contains("SNOWTAM")?response.getData().get(response.getData().size()-1).getAll():"No Snowtam" );
                                    listAirportResult.get(listAirportResult.size()-1).setSnowtamDecoded(response.getData().get(response.getData().size()-1).getAll().contains("SNOWTAM")?response.getData().get(response.getData().size()-1).getAll():"No Snowtam" );
                                    listAirportResult.get(listAirportResult.size()-1).setICAO_Code(response.getData().get(response.getData().size()-1).getLocation());
                                    if(listAirport.indexOf(codeICAO)<delimitateur){
                                        listAirportResult.get(listAirportResult.size()-1).setOnTarget(true);

                                    }
                                    else{
                                        listAirportResult.get(listAirportResult.size()-1).setOnTarget(false);

                                    }

                                    final String codeICAO2=response.getData().get(response.getData().size()-1).getLocation();
                                    Response.Listener<DataSearchAirportLocation> responseListener2 = new Response.Listener<DataSearchAirportLocation>() {
                                        @Override
                                        public void onResponse(DataSearchAirportLocation response) {
                                            //Log.d(TAG,"Latitude = "+response.getData().get(response.getData().size()-1).getLatitude());
                                            //Log.d(TAG,"Longitude = "+response.getData().get(response.getData().size()-1).getLongitude());
                                            for(AirportResult ar : listAirportResult){
                                                if(ar.getICAO_Code().equals(codeICAO2)){
                                                    ar.setLatitude(response.getData().get(response.getData().size()-1).getLatitude());
                                                    ar.setLongitude(response.getData().get(response.getData().size()-1).getLongitude());
                                                }
                                            }
                                            if(listAirportResult.size()==listAirport.size()){
                                                if(parametre.isChoixAffichage()){
                                                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                                                    Bundle bundle = new Bundle();
                                                    bundle.putParcelableArrayList("listAirPort", listAirportResult);
                                                    intent.putExtras(bundle);
                                                    startActivity(intent);
                                                }else{
                                                    Intent intent = new Intent(MainActivity.this, SnowtamActivity.class);
                                                    Bundle bundle = new Bundle();
                                                    bundle.putParcelableArrayList("listAirPort", listAirportResult);
                                                    bundle.putInt("index",0);
                                                    intent.putExtras(bundle);
                                                    startActivity(intent);
                                                }

                                            }
                                            else{
                                                Log.d(TAG,"taille de listeAirPortResult : "+listAirportResult.size()+"\n taille de liste Airport : "+listAirport.size());
                                            }
                                        }
                                    };
                                    Response.ErrorListener errorListener2=new Response.ErrorListener(){
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.d(TAG,"VolleyError");
                                        }
                                    };
                                    ApiService.INSTANCE.searchAirportLocation(Uri.encode(codeICAO2), responseListener2, errorListener2,MainActivity.this);
                                }

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
                }
            }
        });
/** on rajoute les aeroport au fur et à mesure **/
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbrAirport ++;
                Log.w("ajout" , "on ajoute un aeroport" + nbrAirport);
                if (nbrAirport == 2){
                    airport2.setVisibility(View.VISIBLE);
                    close2.setVisibility(View.VISIBLE);
                    imgAirport2.setVisibility((View.VISIBLE));
                }
                if (nbrAirport == 3){
                    airport3.setVisibility(View.VISIBLE);
                    close3.setVisibility(View.VISIBLE);
                    imgAirport3.setVisibility((View.VISIBLE));
                }
                if (nbrAirport == 4){
                    airport4.setVisibility(View.VISIBLE);
                    close4.setVisibility(View.VISIBLE);
                    imgAirport4.setVisibility((View.VISIBLE));
                }
                if (nbrAirport == 5){
                    airport5.setVisibility(View.VISIBLE);
                    close5.setVisibility(View.VISIBLE);
                    imgAirport5.setVisibility((View.VISIBLE));
                }
                if (nbrAirport == 6){
                    airport6.setVisibility(View.VISIBLE);
                    close6.setVisibility(View.VISIBLE);
                    ajout.setVisibility(View.INVISIBLE);
                    imgAirport6.setVisibility((View.VISIBLE));
                }
            }
        });

        /** Suppression des aeroports, on prend la valeur en dessous si il y en avais une **/
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                if (nbrAirport == 2){
                    nbrAirport --;
                    airport2.setVisibility(View.GONE);
                    close2.setVisibility(View.GONE);
                    imgAirport2.setVisibility((View.GONE));
                }
                if (nbrAirport == 3 ){
                    nbrAirport --;
                    airport3.setVisibility(View.GONE);
                    close3.setVisibility(View.GONE);
                    imgAirport3.setVisibility((View.GONE));
                    airport2.setText(airport3.getText());
                }
                if (nbrAirport == 4 ){
                    nbrAirport --;
                    airport4.setVisibility(View.GONE);
                    close4.setVisibility(View.GONE);
                    imgAirport4.setVisibility((View.GONE));
                    airport2.setText(airport3.getText());
                    airport3.setText(airport4.getText());
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    imgAirport5.setVisibility((View.GONE));
                    airport2.setText(airport3.getText());
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    imgAirport6.setVisibility((View.GONE));
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
                    imgAirport3.setVisibility((View.GONE));
                }
                if (nbrAirport == 4 ){
                    nbrAirport --;
                    airport4.setVisibility(View.GONE);
                    close4.setVisibility(View.GONE);
                    imgAirport4.setVisibility((View.GONE));
                    airport3.setText(airport4.getText());
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    imgAirport5.setVisibility((View.GONE));
                    airport3.setText(airport4.getText());
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    imgAirport6.setVisibility((View.GONE));
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
                    imgAirport4.setVisibility((View.GONE));
                }
                if (nbrAirport == 5 ){
                    nbrAirport --;
                    airport5.setVisibility(View.GONE);
                    close5.setVisibility(View.GONE);
                    imgAirport5.setVisibility((View.GONE));
                    airport4.setText(airport5.getText());
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    imgAirport6.setVisibility((View.GONE));
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
                    imgAirport5.setVisibility((View.GONE));
                }
                if (nbrAirport == 6 ){
                    nbrAirport --;
                    airport6.setVisibility(View.GONE);
                    close6.setVisibility(View.GONE);
                    imgAirport6.setVisibility((View.GONE));
                    airport5.setText(airport6.getText());
                    ajout.setVisibility(View.VISIBLE);
                }

            }
        });
        close6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("supprimer" , "on supprime un aeroport" + nbrAirport);
                nbrAirport --;
                airport6.setVisibility(View.GONE);
                close6.setVisibility(View.GONE);
                imgAirport6.setVisibility((View.GONE));
                ajout.setVisibility(View.VISIBLE);
            }
        });

/** Sélection de l'ordre du trajet **/
        imgAirport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 0---"+choixAirport[0] );
                    choixAirport[0]++;
                    if(choixAirport[0]>=10){
                        choixAirport[0] = 1;
                    }

                    if(choixAirport[0]==nbrAirport+2){
                        choixAirport[0] = 10;
                    }

                }while(estDansListe(choixAirport,choixAirport[0]));
                imgAirport1.setImageResource(returnIdImage(choixAirport[0]));
            }
        });

        imgAirport2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 1" );
                    choixAirport[1]++;
                    if(choixAirport[1]>=10){
                        choixAirport[1] = 1;
                    }
                    if(choixAirport[1]==nbrAirport+2){
                        choixAirport[1] = 20;
                    }


                }while(estDansListe(choixAirport,choixAirport[1]));
                imgAirport2.setImageResource(returnIdImage(choixAirport[1]));
            }
        });
        imgAirport3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 2" );
                    choixAirport[2]++;
                    if(choixAirport[2]>=10){
                        choixAirport[2] = 1;
                    }
                    if(choixAirport[2]==nbrAirport+2){
                        choixAirport[2] = 30;
                    }

                }while(estDansListe(choixAirport,choixAirport[2]));
                imgAirport3.setImageResource(returnIdImage(choixAirport[2]));
            }
        });
        imgAirport4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 3" );
                    choixAirport[3]++;
                    if(choixAirport[3]>=10){
                        choixAirport[3] = 1;
                    }
                    if(choixAirport[3]==nbrAirport+2){
                        choixAirport[3] = 40;
                    }

                }while(estDansListe(choixAirport,choixAirport[3]));
                imgAirport4.setImageResource(returnIdImage(choixAirport[3]));
            }
        });
        imgAirport5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 4" );
                    choixAirport[4]++;
                    if(choixAirport[4]>=10){
                        choixAirport[4] = 1;
                    }
                    if(choixAirport[4]==nbrAirport+2){
                        choixAirport[4] = 50;
                    }

                }while(estDansListe(choixAirport,choixAirport[4]));
                imgAirport5.setImageResource(returnIdImage(choixAirport[4]));
            }
        });
        imgAirport6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Log.w("Edit Ordre" , "on change l'ordre 5" );
                    choixAirport[5]++;
                    if(choixAirport[5]>=10){
                        choixAirport[5] = 1;
                    }
                    if(choixAirport[5]==nbrAirport+2){
                        choixAirport[5] = 60;
                    }

                }while(estDansListe(choixAirport,choixAirport[5]));
                imgAirport6.setImageResource(returnIdImage(choixAirport[5]));
            }
        });

    }


    boolean estDansListe (int[] tableau, int i){
        int z=0;
        for (int a : tableau){
            if(a == i){
                z++;
            }
        }
        if(z==1){
            return false;
        }
        return true;
    }

    int returnIdImage(int a){
        switch (a){
            case 1:
                return R.drawable.departures;
            case 2:
                return R.drawable.arrivals;
            case 3:
                return R.drawable.escales1;
            case 4:
                return R.drawable.escales2;
            case 5:
                return R.drawable.escales3;
            case 6:
                return R.drawable.escales4;
            case 10:
                return R.drawable.escales;
            default:
                return R.drawable.escales;
        }
    }

}
