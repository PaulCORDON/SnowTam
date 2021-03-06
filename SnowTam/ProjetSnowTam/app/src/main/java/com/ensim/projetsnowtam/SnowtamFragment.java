package com.ensim.projetsnowtam;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ensim.projetsnowtam.service.Parametre;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



/**
 * A simple {@link Fragment} subclass.
 */
public class SnowtamFragment extends Fragment  implements OnMapReadyCallback {
    private static final String TAG = "SnowtamFragment";
    private GoogleMap mMap;
    public Parametre parametre = new Parametre("",false,false);



    public SnowtamFragment() {
        // Required empty public constructor
    }

    /*on instancie un nouveau fragment*/
    public static SnowtamFragment newInstance(String title, String snowtamBrut, String snowtamDecoded, double latitude, double longitude, Parametre param) {
        SnowtamFragment fragment = new SnowtamFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("SnowtamBrut",snowtamBrut);
        args.putString("SnowtamDecoded",snowtamDecoded);
        args.putParcelable("param",param);
        args.putDouble("latitude",latitude);
        args.putDouble("longitude",longitude);
        fragment.setArguments(args);

        return fragment;
    }

    /*on remplit le fragment en récupérant les données de l'instanciations*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_snowtam, container, false);

        final Button decodedBtn = (Button) view.findViewById(R.id.decodeBtn);
        final Button rawBtn = (Button)view.findViewById(R.id.brutBtn);
        final ImageButton mapBtn = (ImageButton) view.findViewById(R.id.ButtonMap);

        final TextView title =(TextView) view.findViewById(R.id.title);
        final TextView decodeText = (TextView) view.findViewById(R.id.textDecoded);
        final TextView rawText = (TextView) view.findViewById(R.id.textRaw);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        String title1 = getArguments().getString("title");
        String snowtamBrut = getArguments().getString("SnowtamBrut");
        String snowtamDecoded = getArguments().getString("SnowtamDecoded");
        parametre = (Parametre) getArguments().get("param");
        title.setText(title1);
        rawText.setText(snowtamBrut);
        decodeText.setText(snowtamDecoded);
        Log.d("parametres" , "" + parametre.isChoixDecryptage());
        if(!parametre.isChoixDecryptage()){
            decodeText.setVisibility(View.GONE);
            rawText.setVisibility(View.VISIBLE);
        }else{
            decodeText.setVisibility(View.VISIBLE);
            rawText.setVisibility(View.GONE);
        }

        /*Si on clic sur sur le bouton decoded snowtam on affiche le snowtam décodé*/
        decodedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.VISIBLE);
                rawText.setVisibility(View.GONE);
            }
        });
        /*Si on clic sur sur le bouton raw snowtam on affiche le snowtam brut*/
        rawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.GONE);
                rawText.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    /*On centre la carte sur l'aéroport en zoomant dessus*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng currentAirport = new LatLng(getArguments().getDouble("latitude"),getArguments().getDouble("longitude"));
        mMap.addMarker(new MarkerOptions().position(currentAirport).title("COUCOU"));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(currentAirport,14.0f);
        mMap.animateCamera(location);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


    }
}
